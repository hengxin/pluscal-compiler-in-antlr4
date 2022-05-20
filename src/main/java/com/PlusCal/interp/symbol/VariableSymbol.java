package com.PlusCal.interp.symbol;

public interface VariableSymbol<S extends Symbol<S>>
        extends Symbol<S> {
    String name();
}
