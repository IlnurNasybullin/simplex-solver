package test.io.github.ilnurnasybullin.math.simplex;

import io.github.ilnurnasybullin.math.simplex.FunctionType;
import io.github.ilnurnasybullin.math.simplex.Inequality;
import io.github.ilnurnasybullin.math.simplex.Simplex;
import io.github.ilnurnasybullin.math.simplex.SimplexAnswer;
import io.github.ilnurnasybullin.math.simplex.exception.IncompatibleSimplexSolveException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static io.github.ilnurnasybullin.math.simplex.FunctionType.MAX;
import static io.github.ilnurnasybullin.math.simplex.Inequality.GE;
import static io.github.ilnurnasybullin.math.simplex.Inequality.LQ;

public class SimplexAddConstraintTest {

    /**
     * Test add constraint #1:
     * <div>
     *      <img src="./doc-files/test_add_constraint_1.png"/>
     * </div>
     */
    @ParameterizedTest
    @MethodSource("addConstraint_1_Success_Data")
    public void test_AddConstraint_1_Success(Simplex simplex, double[] ai, Inequality inequality, double bi,
                                             double[] expectedX, double expectedFx) {
        SimplexAnswer answer = simplex.addConstraint(ai, inequality, bi);

        Assertions.assertArrayEquals(expectedX, answer.X(), Simplex.EPSILON);
        Assertions.assertEquals(expectedFx, answer.fx(), Simplex.EPSILON);
    }

    public static Stream<Arguments> addConstraint_1_Success_Data() {
        double[][] A = {
                {50, 75},
                {60, 30},
                {10, 25}
        };
        double[] B = {15000, 12000, 5000};
        double[] C = {100, 120};

        Inequality[] inequalities = {GE, GE, LQ};

        Simplex simplex = new Simplex.Builder()
                .setA(A)
                .setB(B)
                .setC(C)
                .setInequalities(inequalities)
                .build();

        simplex.solve();

        double[] ai = {1, 3};
        Inequality inequality = LQ;
        double bi = 360;

        double[] X = {240, 40};
        double fx = 28800;

        return Stream.of(Arguments.of(simplex, ai, inequality, bi, X, fx));
    }

    /**
     * Test add constraint #2:
     * <div>
     *      <img src="./doc-files/test_add_constraint_2.png"/>
     * </div>
     */
    @ParameterizedTest
    @MethodSource("addConstraint_2_Success_Data")
    public void test_AddConstraint_2_Success(Simplex simplex, double[] ai, Inequality inequality, double bi,
                                             double[] expectedX, double expectedFx) {
        SimplexAnswer answer = simplex.addConstraint(ai, inequality, bi);

        Assertions.assertArrayEquals(expectedX, answer.X(), Simplex.EPSILON);
        Assertions.assertEquals(expectedFx, answer.fx(), Simplex.EPSILON);
    }

    public static Stream<Arguments> addConstraint_2_Success_Data() {
        double[][] A = {
                {-1, 1},
                {0, 1},
                {1, 0}
        };
        double[] B = {2, 1, 3};
        double[] C = {6, 10};

        Inequality[] inequalities = {LQ, LQ, LQ};
        FunctionType functionType = MAX;

        Simplex simplex = new Simplex.Builder()
                .setA(A)
                .setB(B)
                .setC(C)
                .setFunctionType(functionType)
                .setInequalities(inequalities)
                .build();

        simplex.solve();

        double[] ai = {1, 0};
        Inequality inequality = LQ;
        double bi = 5;

        double[] X = {3, 1};
        double fx = 28;

        return Stream.of(Arguments.of(simplex, ai, inequality, bi, X, fx));
    }

    /**
     * Test add constraint #3:
     * <div>
     *      <img src="./doc-files/test_add_constraint_3.png"/>
     * </div>
     */
    @ParameterizedTest
    @MethodSource("addConstraint_3_Success_Data")
    public void test_AddConstraint_3_Success(Simplex simplex, double[] ai, Inequality inequality, double bi,
                                             double[] expectedX, double expectedFx) {
        SimplexAnswer answer = simplex.addConstraint(ai, inequality, bi);

        Assertions.assertArrayEquals(expectedX, answer.X(), Simplex.EPSILON);
        Assertions.assertEquals(expectedFx, answer.fx(), Simplex.EPSILON);
    }

    public static Stream<Arguments> addConstraint_3_Success_Data() {
        double[][] A = {
                {5, -2},
                {1, -2},
                {1, 1}
        };
        double[] B = {4, -4, 4};
        double[] C = {1, 2};

        Inequality[] inequalities = {LQ, GE, LQ};
        FunctionType functionType = MAX;

        Simplex simplex = new Simplex.Builder()
                .setA(A)
                .setB(B)
                .setC(C)
                .setFunctionType(functionType)
                .setInequalities(inequalities)
                .build();

        simplex.solve();

        double[] ai = {1, 0};
        Inequality inequality = LQ;
        double bi = 1.5;

        double[] X = {4d/3, 2 + 2d/3};
        double fx = 20d/3;

        return Stream.of(Arguments.of(simplex, ai, inequality, bi, X, fx));
    }

    /**
     * Test add constraint #4:
     * <div>
     *      <img src="./doc-files/test_add_constraint_4.png"/>
     * </div>
     */
    @ParameterizedTest
    @MethodSource("addConstraint_4_Success_Data")
    public void test_AddConstraint_4_Success(Simplex simplex, double[] ai, Inequality inequality, double bi,
                                             double[] expectedX, double expectedFx) {
        SimplexAnswer answer = simplex.addConstraint(ai, inequality, bi);

        Assertions.assertArrayEquals(expectedX, answer.X(), Simplex.EPSILON);
        Assertions.assertEquals(expectedFx, answer.fx(), Simplex.EPSILON);
    }

    public static Stream<Arguments> addConstraint_4_Success_Data() {
        double[][] A = {
                {5, -2},
                {1, -2},
                {1, 1}
        };
        double[] B = {4, -4, 4};
        double[] C = {1, 2};

        Inequality[] inequalities = {LQ, GE, LQ};
        FunctionType functionType = MAX;

        Simplex simplex = new Simplex.Builder()
                .setA(A)
                .setB(B)
                .setC(C)
                .setFunctionType(functionType)
                .setInequalities(inequalities)
                .build();

        simplex.solve();

        double[] ai = {1, 0};
        Inequality inequality = LQ;
        double bi = 1;

        double[] X = {1, 5d/2};
        double fx = 6;

        return Stream.of(Arguments.of(simplex, ai, inequality, bi, X, fx));
    }

    /**
     * Test add constraint #5:
     * <div>
     *      <img src="./doc-files/test_add_constraint_5.png"/>
     * </div>
     */
    @ParameterizedTest
    @MethodSource("addConstraint_5_Success_Data")
    public void test_AddConstraint_5_Success(Simplex simplex, double[] ai, Inequality inequality, double bi,
                                             double[] expectedX, double expectedFx) {
        SimplexAnswer answer = simplex.addConstraint(ai, inequality, bi);

        Assertions.assertArrayEquals(expectedX, answer.X(), Simplex.EPSILON);
        Assertions.assertEquals(expectedFx, answer.fx(), Simplex.EPSILON);
    }

    public static Stream<Arguments> addConstraint_5_Success_Data() {
        double[][] A = {
                {1, 2},
                {2, 1},
                {-1, 1},
                {0, 1}
        };
        double[] B = {6, 8, 1, 2};
        double[] C = {3, 2};

        Inequality[] inequalities = {LQ, LQ, LQ, LQ};
        FunctionType functionType = MAX;

        Simplex simplex = new Simplex.Builder()
                .setA(A)
                .setB(B)
                .setC(C)
                .setFunctionType(functionType)
                .setInequalities(inequalities)
                .build();

        simplex.solve();

        double[] ai = {1, 0};
        Inequality inequality = LQ;
        double bi = 4;

        double[] X = {10d/3, 4d/3};
        double fx = 12 + 2d/3;

        return Stream.of(Arguments.of(simplex, ai, inequality, bi, X, fx));
    }

    /**
     * Test add constraint #6:
     * <div>
     *      <img src="./doc-files/test_add_constraint_6.png"/>
     * </div>
     */
    @ParameterizedTest
    @MethodSource("addConstraint_6_Success_Data")
    public void test_AddConstraint_6_Success(Simplex simplex, double[] ai, Inequality inequality, double bi,
                                             double[] expectedX, double expectedFx) {
        SimplexAnswer answer = simplex.addConstraint(ai, inequality, bi);

        Assertions.assertArrayEquals(expectedX, answer.X(), Simplex.EPSILON);
        Assertions.assertEquals(expectedFx, answer.fx(), Simplex.EPSILON);
    }

    public static Stream<Arguments> addConstraint_6_Success_Data() {
        double[][] A = {
                {1, 2},
                {2, 1},
                {-1, 1},
                {0, 1}
        };
        double[] B = {6, 8, 1, 2};
        double[] C = {3, 2};

        Inequality[] inequalities = {LQ, LQ, LQ, LQ};
        FunctionType functionType = MAX;

        Simplex simplex = new Simplex.Builder()
                .setA(A)
                .setB(B)
                .setC(C)
                .setFunctionType(functionType)
                .setInequalities(inequalities)
                .build();

        simplex.solve();

        double[] ai = {1, 0};
        Inequality inequality = LQ;
        double bi = 3;

        double[] X = {3, 3d/2};
        double fx = 12;

        return Stream.of(Arguments.of(simplex, ai, inequality, bi, X, fx));
    }

    /**
     * Test add constraint #7:
     * <div>
     *      <img src="./doc-files/test_add_constraint_7.png"/>
     * </div>
     */
    @ParameterizedTest
    @MethodSource("addConstraint_7_IncompatibleSimplexSolveException_Data")
    public void test_AddConstraint_7_IncompatibleSimplexSolveException_Success(Simplex simplex,
                                                                       double[] ai, Inequality inequality, double bi,
                                                                       Class<? extends Exception> exceptionClass) {
        Assertions.assertThrows(exceptionClass, () -> simplex.addConstraint(ai, inequality, bi));
    }

    public static Stream<Arguments> addConstraint_7_IncompatibleSimplexSolveException_Data() {
        double[][] A = {
                {1, 2},
                {2, 1},
                {1, 3},
                {0, 1}
        };
        double[] B = {6, 8, 9, 2};
        double[] C = {3, 2};

        Inequality[] inequalities = {LQ, LQ, LQ, LQ};
        FunctionType functionType = MAX;

        Simplex simplex = new Simplex.Builder()
                .setA(A)
                .setB(B)
                .setC(C)
                .setFunctionType(functionType)
                .setInequalities(inequalities)
                .build();

        simplex.solve();

        double[] ai = {1, 1};
        Inequality inequality = GE;
        double bi = 5;

        Class<? extends Exception> exceptionClass = IncompatibleSimplexSolveException.class;

        return Stream.of(Arguments.of(simplex, ai, inequality, bi, exceptionClass));
    }

    /**
     * Test add constraint #8:
     * <div>
     *      <img src="./doc-files/test_add_constraint_8.png"/>
     * </div>
     */
    @ParameterizedTest
    @MethodSource("addConstraint_8_Success_Data")
    public void test_AddConstraint_8_Success(Simplex simplex, double[] ai, Inequality inequality, double bi,
                                             double[] expectedX, double expectedFx) {
        SimplexAnswer answer = simplex.addConstraint(ai, inequality, bi);

        Assertions.assertArrayEquals(expectedX, answer.X(), Simplex.EPSILON);
        Assertions.assertEquals(expectedFx, answer.fx(), Simplex.EPSILON);
    }

    public static Stream<Arguments> addConstraint_8_Success_Data() {
        double[][] A = {
                {1, 2},
                {2, 1},
                {1, 3},
                {0, 1}
        };
        double[] B = {6, 8, 9, 2};
        double[] C = {3, 2};

        Inequality[] inequalities = {LQ, LQ, LQ, LQ};
        FunctionType functionType = MAX;

        Simplex simplex = new Simplex.Builder()
                .setA(A)
                .setB(B)
                .setC(C)
                .setFunctionType(functionType)
                .setInequalities(inequalities)
                .build();

        simplex.solve();

        double[] ai = {1, 0};
        Inequality inequality = GE;
        double bi = 3.5;

        double[] X = {3.5, 1};
        double fx = 12.5;

        return Stream.of(Arguments.of(simplex, ai, inequality, bi, X, fx));
    }
}
