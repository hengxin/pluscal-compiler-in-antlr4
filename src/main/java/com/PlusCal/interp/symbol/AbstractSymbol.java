package com.PlusCal.interp.symbol;

import java.util.Objects;

@SuppressWarnings("rawtypes")
abstract class AbstractSymbol<S extends Symbol<S>>
        implements Symbol<S> {
    final String name;
    final int line;
    final protected SymbolType<S> type;

    protected AbstractSymbol(String name, int line, SymbolType<S> type) {
        this.name = name;
        this.line = line;
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractSymbol symbol = (AbstractSymbol) o;
        return Objects.equals(name, symbol.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return name;
    }

    public int line() {
        return line;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public SymbolType<S> type() {
        return type;
    }
}
