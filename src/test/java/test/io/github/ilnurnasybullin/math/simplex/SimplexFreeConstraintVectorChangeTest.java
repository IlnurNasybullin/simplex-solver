package test.io.github.ilnurnasybullin.math.simplex;

import io.github.ilnurnasybullin.math.simplex.FunctionType;
import io.github.ilnurnasybullin.math.simplex.Inequality;
import io.github.ilnurnasybullin.math.simplex.Simplex;
import io.github.ilnurnasybullin.math.simplex.SimplexAnswer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static io.github.ilnurnasybullin.math.simplex.FunctionType.MAX;
import static io.github.ilnurnasybullin.math.simplex.Inequality.GE;
import static io.github.ilnurnasybullin.math.simplex.Inequality.LQ;

public class SimplexFreeConstraintVectorChangeTest {

    /**
     * Test free constraint change #1:
     * <div>
     *      <img src="./doc-files/test_free_constraint_change_1.png"/>
     * </div>
     */
    @ParameterizedTest
    @MethodSource("freeConstraintChange_1_Success_Data")
    public void test_FreeConstraintChange_1_Success(Simplex simplex, double[] B, double[] expectedX, double expectedFx) {
        SimplexAnswer answer = simplex.changeB(B);

        Assertions.assertArrayEquals(expectedX, answer.X(), Simplex.EPSILON);
        Assertions.assertEquals(expectedFx, answer.fx(), Simplex.EPSILON);
    }

    public static Stream<Arguments> freeConstraintChange_1_Success_Data() {
        double[][] A = {
                {-1, 1},
                {0, 1},
                {1, 0}
        };

        double[] oldB = {2, 1, 3};
        double[] C = {6, 10};
        FunctionType functionType = MAX;
        Inequality[] inequalities = {LQ, LQ, LQ};

        Simplex simplex = new Simplex.Builder()
                .setA(A)
                .setB(oldB)
                .setC(C)
                .setFunctionType(functionType)
                .setInequalities(inequalities)
                .build();

        simplex.solve();

        double[] newB = {4, 2, 6};
        double[] X = {6, 2};
        double fx = 56;

        return Stream.of(Arguments.of(simplex, newB, X, fx));
    }

    /**
     * Test free constraint change #2:
     * <div>
     *      <img src="./doc-files/test_free_constraint_change_2.png"/>
     * </div>
     */
    @ParameterizedTest
    @MethodSource("freeConstraintChange_2_Success_Data")
    public void test_FreeConstraintChange_2_Success(Simplex simplex, double[] B, double[] expectedX, double expectedFx) {
        SimplexAnswer answer = simplex.changeB(B);

        Assertions.assertArrayEquals(expectedX, answer.X(), Simplex.EPSILON);
        Assertions.assertEquals(expectedFx, answer.fx(), Simplex.EPSILON);
    }

    public static Stream<Arguments> freeConstraintChange_2_Success_Data() {
        double[][] A = {
                {-1, 1},
                {0, 1},
                {1, 0}
        };

        double[] oldB = {2, 1, 3};
        double[] C = {6, 10};
        FunctionType functionType = MAX;
        Inequality[] inequalities = {LQ, LQ, LQ};

        Simplex simplex = new Simplex.Builder()
                .setA(A)
                .setB(oldB)
                .setC(C)
                .setFunctionType(functionType)
                .setInequalities(inequalities)
                .build();

        simplex.solve();

        double[] newB = {2, 6, 3};
        double[] X = {3, 5};
        double fx = 68;

        return Stream.of(Arguments.of(simplex, newB, X, fx));
    }

    /**
     * Test free constraint change #3:
     * <div>
     *      <img src="./doc-files/test_free_constraint_change_3.png"/>
     * </div>
     */
    @ParameterizedTest
    @MethodSource("freeConstraintChange_3_Success_Data")
    public void test_FreeConstraintChange_3_Success(Simplex simplex, double[] B, double[] expectedX, double expectedFx) {
        SimplexAnswer answer = simplex.changeB(B);

        Assertions.assertArrayEquals(expectedX, answer.X(), Simplex.EPSILON);
        Assertions.assertEquals(expectedFx, answer.fx(), Simplex.EPSILON);
    }

    public static Stream<Arguments> freeConstraintChange_3_Success_Data() {
        double[][] A = {
                {3, -7, -1},
                {5, 6, 10},
        };

        double[] oldB = {490, 620};
        double[] C = {4, 5, -3};
        Inequality[] inequalities = {GE, LQ};
        boolean[] normalizeX = {true, true, false};

        Simplex simplex = new Simplex.Builder()
                .setA(A)
                .setB(oldB)
                .setC(C)
                .setInequalities(inequalities)
                .setNormalizedX(normalizeX)
                .build();

        simplex.solve();

        double[] newB = {490, 650};
        double[] X = {158 + 4d/7, 0d, -14 - 2d/7};
        double fx = 677 + 1d/7;

        return Stream.of(Arguments.of(simplex, newB, X, fx));
    }

    /**
     * Test free constraint change #4:
     * <div>
     *      <img src="./doc-files/test_free_constraint_change_4.png"/>
     * </div>
     */
    @ParameterizedTest
    @MethodSource("freeConstraintChange_4_Success_Data")
    public void test_FreeConstraintChange_4_Success(Simplex simplex, double[] B, double[] expectedX, double expectedFx) {
        SimplexAnswer answer = simplex.changeB(B);

        Assertions.assertArrayEquals(expectedX, answer.X(), Simplex.EPSILON);
        Assertions.assertEquals(expectedFx, answer.fx(), Simplex.EPSILON);
    }

    public static Stream<Arguments> freeConstraintChange_4_Success_Data() {
        double[][] A = {
                {0, 2, 7},
                {4, 5, -4},
                {-2, 1, -9}
        };

        double[] oldB = {970, 260, 770};
        double[] C = {-3, 3, -5};
        Inequality[] inequalities = {GE, LQ, GE};
        boolean[] normalizeX = {false, false, false};

        Simplex simplex = new Simplex.Builder()
                .setA(A)
                .setB(oldB)
                .setC(C)
                .setInequalities(inequalities)
                .setNormalizedX(normalizeX)
                .build();

        simplex.solve();

        double[] newB = {1010, 270, 790};
        double[] X = {-368 - 91d/93, 378 + 16d/93, 36 + 22d/93};
        double fx = 2060 + 25d/93;

        return Stream.of(Arguments.of(simplex, newB, X, fx));
    }

    /**
     * Test free constraint change #5:
     * <div>
     *      <img src="./doc-files/test_free_constraint_change_5.png"/>
     * </div>
     */
    @ParameterizedTest
    @MethodSource("freeConstraintChange_5_Success_Data")
    public void test_FreeConstraintChange_5_Success(Simplex simplex, double[] B, double[] expectedX, double expectedFx) {
        SimplexAnswer answer = simplex.changeB(B);

        Assertions.assertArrayEquals(expectedX, answer.X(), Simplex.EPSILON);
        Assertions.assertEquals(expectedFx, answer.fx(), Simplex.EPSILON);
    }

    public static Stream<Arguments> freeConstraintChange_5_Success_Data() {
        double[][] A = {
                {0, 6, -3, 8},
                {2, -1, 2, 7},
                {0, 1, 7, -7},
                {-6, 6, -9, -4},
                {0, 10, 0, -9}
        };

        double[] oldB = {690, 810, 560, 270, 660};
        double[] C = {2, -2, 1, -2};
        Inequality[] inequalities = {LQ, LQ, LQ, LQ, LQ};
        boolean[] normalizeX = {false, true, false, false};

        Simplex simplex = new Simplex.Builder()
                .setA(A)
                .setB(oldB)
                .setC(C)
                .setInequalities(inequalities)
                .setNormalizedX(normalizeX)
                .build();

        simplex.solve();

        double[] newB = {720, 820, 600, 240, 610};
        double[] X = {-592, 0, 281 + 1d/7, 195 + 3d/7};
        double fx = -1293 - 5d/7;

        return Stream.of(Arguments.of(simplex, newB, X, fx));
    }

    /**
     * Test free constraint change #6:
     * <div>
     *      <img src="./doc-files/test_free_constraint_change_6.png"/>
     * </div>
     */
    @ParameterizedTest
    @MethodSource("freeConstraintChange_6_Success_Data")
    public void test_FreeConstraintChange_6_Success(Simplex simplex, double[] B, double[] expectedX, double expectedFx) {
        SimplexAnswer answer = simplex.changeB(B);

        Assertions.assertArrayEquals(expectedX, answer.X(), Simplex.EPSILON);
        Assertions.assertEquals(expectedFx, answer.fx(), Simplex.EPSILON);
    }

    public static Stream<Arguments> freeConstraintChange_6_Success_Data() {
        double[][] A = {
                {4, -5, -10},
                {1, 9, -4},
                {9, 5, 1},
                {9, 8, 7}
        };

        double[] oldB = {230, 700, 430, 990};
        double[] C = {-2, -3, 4};
        Inequality[] inequalities = {LQ, LQ, LQ, GE};

        Simplex simplex = new Simplex.Builder()
                .setA(A)
                .setB(oldB)
                .setC(C)
                .setInequalities(inequalities)
                .build();

        simplex.solve();

        double[] newB = {200, 710, 440, 1030};
        double[] X = {0, 75 + 25d/27, 60 + 10d/27};
        double fx = 13 + 19d/27;

        return Stream.of(Arguments.of(simplex, newB, X, fx));
    }

    /**
     * Test free constraint change #7:
     * <div>
     *      <img src="./doc-files/test_free_constraint_change_7.png"/>
     * </div>
     */
    @ParameterizedTest
    @MethodSource("freeConstraintChange_7_Success_Data")
    public void test_FreeConstraintChange_7_Success(Simplex simplex, double[] B, double[] expectedX, double expectedFx) {
        SimplexAnswer answer = simplex.changeB(B);

        Assertions.assertArrayEquals(expectedX, answer.X(), Simplex.EPSILON);
        Assertions.assertEquals(expectedFx, answer.fx(), Simplex.EPSILON);
    }

    public static Stream<Arguments> freeConstraintChange_7_Success_Data() {
        double[][] A = {
                {3, -2, 4},
                {-4, -9, 1}
        };

        double[] oldB = {950, 810};
        double[] C = {-2, -3, -1};
        FunctionType functionType = MAX;
        Inequality[] inequalities = {GE, LQ};
        boolean[] normalizedX = {false, false, true};

        Simplex simplex = new Simplex.Builder()
                .setA(A)
                .setB(oldB)
                .setC(C)
                .setFunctionType(functionType)
                .setInequalities(inequalities)
                .setNormalizedX(normalizedX)
                .build();

        simplex.solve();

        double[] newB = {940, 830};
        double[] X = {194 + 2d/7, -178 -4d/7, 0};
        double fx = 147 + 1d/7;

        return Stream.of(Arguments.of(simplex, newB, X, fx));
    }

    /**
     * Test free constraint change #8:
     * <div>
     *      <img src="./doc-files/test_free_constraint_change_8.png"/>
     * </div>
     */
    @ParameterizedTest
    @MethodSource("freeConstraintChange_8_Success_Data")
    public void test_FreeConstraintChange_8_Success(Simplex simplex, double[] B, double[] expectedX, double expectedFx) {
        SimplexAnswer answer = simplex.changeB(B);

        Assertions.assertArrayEquals(expectedX, answer.X(), Simplex.EPSILON);
        Assertions.assertEquals(expectedFx, answer.fx(), Simplex.EPSILON);
    }

    public static Stream<Arguments> freeConstraintChange_8_Success_Data() {
        double[][] A = {
                {8, -1, 7},
                {2, -10, 9},
                {9, 3, 0},
                {-7, 3, 3},
                {4, 0, -5}
        };

        double[] oldB = {450, 140, 180, 210, 430};
        double[] C = {-4, -2, -2};
        FunctionType functionType = MAX;
        Inequality[] inequalities = {LQ, GE, GE, LQ, LQ};
        boolean[] normalizedX = {true, false, true};

        Simplex simplex = new Simplex.Builder()
                .setA(A)
                .setB(oldB)
                .setC(C)
                .setFunctionType(functionType)
                .setInequalities(inequalities)
                .setNormalizedX(normalizedX)
                .build();

        simplex.solve();

        double[] newB = {430, 140, 170, 160, 440};
        double[] X = {44 + 8d/33, -76 - 2d/33, 0};
        double fx = -24 -28d/33;

        return Stream.of(Arguments.of(simplex, newB, X, fx));
    }

    /**
     * Test free constraint change #9:
     * <div>
     *      <img src="./doc-files/test_free_constraint_change_9.png"/>
     * </div>
     */
    @ParameterizedTest
    @MethodSource("freeConstraintChange_9_Success_Data")
    public void test_FreeConstraintChange_9_Success(Simplex simplex, double[] B, double[] expectedX, double expectedFx) {
        SimplexAnswer answer = simplex.changeB(B);

        Assertions.assertArrayEquals(expectedX, answer.X(), Simplex.EPSILON);
        Assertions.assertEquals(expectedFx, answer.fx(), Simplex.EPSILON);
    }

    public static Stream<Arguments> freeConstraintChange_9_Success_Data() {
        double[][] A = {
                {-7, -6, 2},
                {-7, -8, -1},
                {9, 8, -2}
        };

        double[] oldB = {350, 310, 730};
        double[] C = {-1, 4, 5};
        Inequality[] inequalities = {LQ, LQ, LQ};
        boolean[] normalizedX = {false, true, true};

        Simplex simplex = new Simplex.Builder()
                .setA(A)
                .setB(oldB)
                .setC(C)
                .setInequalities(inequalities)
                .setNormalizedX(normalizedX)
                .build();

        simplex.solve();

        double[] newB = {310, 260, 720};
        double[] X = {80, 0, 0};
        double fx = -80;

        return Stream.of(Arguments.of(simplex, newB, X, fx));
    }
}
