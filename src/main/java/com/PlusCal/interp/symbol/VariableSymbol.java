package com.PlusCal.interp.symbol;

interface VariableSymbol<S extends Symbol<S>>
        extends Symbol<S> {
    String name();
}
