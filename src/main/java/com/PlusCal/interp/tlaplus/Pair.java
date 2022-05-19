package com.PlusCal.interp.tlaplus;

import java.util.Objects;

public class Pair<_T1, _T2> {

    public _T1 first;
    public _T2 second;

    public Pair(_T1 first, _T2 second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair<?, ?> pair = (Pair<?, ?>) o;
        return Objects.equals(first, pair.first) && Objects.equals(second, pair.second);
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second);
    }

    public static <_T1, _T2> Pair<_T1, _T2> makePair(_T1 t1, _T2 t2) {
        return new Pair<>(t1, t2);
    }

    public static <T, K extends T> Pair<T, T> makePair(K t) {
        return new Pair<>(t, t);
    }
}
