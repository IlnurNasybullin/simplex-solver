package io.github.ilnurnasybullin.math.simplex;

import java.util.Arrays;

public class SimplexAnswer {

    private final double[] X;
    private final double fx;

    public SimplexAnswer(double[] X, double fx) {
        this.X = X;
        this.fx = fx;
    }

    public double[] X() {
        return Arrays.copyOf(X, X.length);
    }

    public double fx() {
        return fx;
    }
}
