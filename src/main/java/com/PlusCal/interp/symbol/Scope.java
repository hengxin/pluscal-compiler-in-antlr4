package com.PlusCal.interp.symbol;

import java.util.Collection;
import java.util.List;

import static com.PlusCal.interp.symbol.SymbolTable.*;

@SuppressWarnings("rawtypes")
public interface Scope {

    Scope GLOBAL = SymbolTable.root;

    VariableSymbol defineVariable(VariableSymbol symbol);

    VariableSymbol get(String name);

    Collection<VariableSymbol> getLocalElements();

    <S extends VariableSymbol> Collection<S> getLocalElementsOf(SymbolType<S> type);

    List<LabelSymbol> getLocalLabels();

    default void enter() { }

    default VariableSymbol getLocal(String name) {
        for (VariableSymbol v: getLocalElements()) {
            if (v.name().equals(name)) {
                return v;
            }
        }
        return null;
    }
}
