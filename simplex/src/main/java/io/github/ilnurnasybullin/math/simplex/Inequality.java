package io.github.ilnurnasybullin.math.simplex;

import java.util.Map;

public enum Inequality {
    EQ("="),
    LQ("<="),
    LE("<"),
    GE(">="),
    GR(">");

    private final static Map<Inequality, Inequality> inequalities;

    static {
        inequalities = Map.of(
                EQ, EQ,
                LQ, GR,
                LE, GE,
                GE, LE,
                GR, LQ
        );
    }

    private final String symbol;

    Inequality(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

    public static Inequality inversion(Inequality inequality) {
        return inequalities.get(inequality);
    }

    @Override
    public String toString() {
        return getSymbol();
    }
}
