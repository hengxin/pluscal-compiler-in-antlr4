package com.PlusCal.interp;

public final class Require {

    private Require() { }

    public static void nonNull(Object o) {
        if (o == null) {
            throw new AssertionError("not null");
        }
    }

    public static void require(boolean predicate) {
        if (!predicate) {
            throw new AssertionError("assertion error");
        }
    }

    public static void require(boolean predicate, String msg) {
        if (!predicate) {
            throw new AssertionError(msg);
        }
    }
}
