package test.io.github.ilnurnasybullin.math.simplex;

import io.github.ilnurnasybullin.math.simplex.FunctionType;
import io.github.ilnurnasybullin.math.simplex.Inequality;
import io.github.ilnurnasybullin.math.simplex.Simplex;
import io.github.ilnurnasybullin.math.simplex.SimplexAnswer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SimplexAlternativeSolutionsTest {

    @ParameterizedTest
    @MethodSource(value = {
            "_1_Success_Data",
            "_2_Success_Data",
            "_3_Success_Data"
    })
    public void test_1_Success(double[][] A, double[] B, double[] C,
                               FunctionType functionType, Inequality[] inequalities,
                               List<double[]> expectedXAnswers, double expectedFx) {
        var answers = new ArrayList<>(expectedXAnswers);
        Simplex simplex = new Simplex.Builder()
                .setA(A)
                .setB(B)
                .setC(C)
                .setInequalities(inequalities)
                .setFunctionType(functionType)
                .build();
        SimplexAnswer answer = simplex.solve();
        Assertions.assertEquals(expectedFx, answer.fx(), Simplex.EPSILON);
        Assertions.assertTrue(removeArrayEquals(answer.X(), answers, Simplex.EPSILON),
                errorMessage(answer.X(), answers, expectedXAnswers)
        );

        List<Simplex> alternativeSolutions = simplex.findAlternativeSolutions();

        alternativeSolutions.stream()
                .map(Simplex::solve)
                .map(SimplexAnswer::fx)
                .forEach(fx -> Assertions.assertEquals(expectedFx, fx, Simplex.EPSILON));

        alternativeSolutions.stream()
                .map(Simplex::solve)
                .map(SimplexAnswer::X)
                .forEach(x -> Assertions.assertTrue(
                        removeArrayEquals(x, answers, Simplex.EPSILON) || checkThatContains(x, expectedXAnswers, Simplex.EPSILON),
                        errorMessage(x, answers, expectedXAnswers)
                ));

        Assertions.assertTrue(answers.isEmpty());
    }

    private boolean checkThatContains(double[] checkingArray, List<double[]> expectedXAnswers, double epsilon) {
        return expectedXAnswers.stream().anyMatch(array -> arrayEquals(checkingArray, array, epsilon));
    }

    private Supplier<String> errorMessage(double[] array, Collection<double[]> arrays1, Collection<double[]> arrays2) {
        return () -> String.format(
                "Expected that collection of arrays %s or %s contains array %s",
                arrays1.stream()
                        .map(Arrays::toString)
                        .collect(Collectors.joining(", ", "[", "]")),
                arrays2.stream()
                        .map(Arrays::toString)
                        .collect(Collectors.joining(", ", "[", "]")),
                Arrays.toString(array)
        );
    }

    private boolean removeArrayEquals(double[] checkingArray, Collection<double[]> arrays, double epsilon) {
        return arrays.removeIf(array -> arrayEquals(checkingArray, array, epsilon));
    }

    private boolean arrayEquals(double[] array1, double[] array2, double epsilon) {
        if (array1.length != array2.length) {
            return false;
        }

        for (int i = 0; i < array1.length; i++) {
            if (!isApproximateValue(array1[i], array2[i], epsilon)) {
                return false;
            }
        }

        return true;
    }

    private boolean isApproximateValue(double v1, double v2, double epsilon) {
        return Math.abs(v1 - v2) < epsilon;
    }

    public static Stream<Arguments> _1_Success_Data() {
        // x + y + z <= 2
        double[][] A = {
                {1, 1, 1}
        };
        double[] B = {2};
        var inequalities = new Inequality[]{Inequality.LQ};

        // x + y + z -> MAX
        double[] C = {1, 1, 1};
        var functionType = FunctionType.MAX;

        double[] X1 = {2, 0, 0};
        double[] X2 = {0, 2, 0};
        double[] X3 = {0, 0, 2};

        double fx = 2;

        return Stream.of(Arguments.of(
                A, B, C, functionType, inequalities, List.of(X1, X2, X3), fx
        ));
    }

    public static Stream<Arguments> _2_Success_Data() {
        // x + y <= 3
        // 1 <= x <= 2
        // 1 <= y <= 2

        double[][] A = {
                {1, 1},
                {1, 0},
                {1, 0},
                {0, 1},
                {0, 1}
        };
        double[] B = {3, 1, 2, 1, 2};
        var inequalities = new Inequality[]{Inequality.LQ, Inequality.GE, Inequality.LQ, Inequality.GE, Inequality.LQ};

        // x + y -> MAX
        double[] C = {1, 1};
        var functionType = FunctionType.MAX;

        double[] X1 = {1, 2};
        double[] X2 = {2, 1};

        double fx = 3;

        return Stream.of(Arguments.of(
                A, B, C, functionType, inequalities, List.of(X1, X2), fx
        ));
    }

    public static Stream<Arguments> _3_Success_Data() {
        double[][] A = {
                {0.0, 1.0, 0.0, 0.0, 1.0, 1.0},
                {0.0, 0.0, 1.0, 1.0, 0.0, 1.0},
                {1.0, 0.0, 0.0, 1.0, 1.0, 0.0},
                {1.0, 1.0, 1.0, 0.0, 0.0, 0.0},
                {1.0, 1.0, 1.0, 1.0, 1.0, 1.0}
        };
        double[] B = {1, 1, 1, 1, 1};
        var inequalities = new Inequality[]{Inequality.LQ, Inequality.LQ, Inequality.LQ, Inequality.LQ, Inequality.LQ};

        // x + y -> MAX
        double[] C = {1, 1, 1, 1, 1, 1};
        var functionType = FunctionType.MAX;

        double[] X1 = {1, 0, 0, 0, 0, 0};
        double[] X2 = {0, 1, 0, 0, 0, 0};
        double[] X3 = {0, 0, 1, 0, 0, 0};
        double[] X4 = {0, 0, 0, 1, 0, 0};
        double[] X5 = {0, 0, 0, 0, 1, 0};
        double[] X6 = {0, 0, 0, 0, 0, 1};

        double fx = 1;

        return Stream.of(Arguments.of(
                A, B, C, functionType, inequalities, List.of(X1, X2, X3, X4, X5, X6), fx
        ));
    }

}
