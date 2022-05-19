package com.PlusCal.interp.symbol;

@SuppressWarnings("rawtypes")
public interface Symbol<S extends Symbol> {

    String name();

    int line();

    SymbolType<S> type();
}
