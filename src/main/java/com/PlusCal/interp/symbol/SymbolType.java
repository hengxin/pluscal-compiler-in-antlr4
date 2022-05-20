package com.PlusCal.interp.symbol;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import static com.PlusCal.interp.symbol.SymbolTable.*;

@SuppressWarnings("rawtypes")
public final class SymbolType<S extends Symbol> {
    /**
     * Type Variable
     */
    public static final SymbolType<NormalVariableSymbol> VARIABLE
            = new SymbolType<>("variable", NormalVariableSymbol.class,
            (s) -> !(s.name.equals("pc") || s.name.equals("stack") || s.name.equals("self")),
            () -> ((s) -> getCurrentScope().defineVariable(s)),
            () -> ((s) -> (NormalVariableSymbol) getCurrentScope().get(s)),
            () -> getCurrentScope().variables.values().stream().
                    filter((s) -> s instanceof NormalVariableSymbol).map(s -> (NormalVariableSymbol)s).
                    collect(Collectors.toList()));

    /**
     * Type Procedure
     */
    public static final SymbolType<ProcedureSymbol> PROCEDURE
            = new SymbolType<>("procedure", ProcedureSymbol.class,
            () -> ((s) -> procedures.putIfAbsent(s.name, s)),
            () -> procedures::get,
            procedures::values);

    /**
     * Type Process
     */
    public static final SymbolType<ProcessSymbol> PROCESS
            = new SymbolType<>("process", ProcessSymbol.class,
            () -> ((s) -> processes.putIfAbsent(s.name, s)),
            () -> processes::get,
            processes::values);

    /**
     * Type Label
     */
    public static final SymbolType<LabelSymbol> LABEL
            = new SymbolType<>("label", LabelSymbol.class,
            (s) -> (!(s.name.equals("Done") || s.name.equals("Error"))),
            () -> ((s) -> labels.putIfAbsent(s.name, s)),
            () -> labels::get,
            labels::values);

    /**
     * Type operator
     */
    public static final SymbolType<OperatorSymbol> OPERATOR
            = new SymbolType<>("operator", OperatorSymbol.class,
            () -> ((s) -> getCurrentScope().defineVariable(s)),
            () -> ((s) -> (OperatorSymbol) getCurrentScope().get(s)),
            () -> getCurrentScope().variables.values().stream().
                    filter((s) -> s instanceof OperatorSymbol).map(s -> (OperatorSymbol)s).
                    collect(Collectors.toList()));

    public final String name;
    public final Class<S> symbolClass;

    /**
     * assert that
     */
    private final Predicate<S> assertion;

    /**
     * From which to get symbol of this type
     */
    private final Supplier<Function<String, S>> symbolOfTypeGetter;

    /**
     * From which to set symbol of this type
     */
    private final Supplier<Function<? super S, ? extends Symbol>> symbolOfTypeSetter;

    /**
     * From which to get all symbols of this type
     */
    private final Supplier<Collection<S>> typeSymbolsGetter;

    private SymbolType(String name, Class<S> symbolClass,
                       Supplier<Function<? super S, ? extends Symbol>> symbolOfTypeSetter,
                       Supplier<Function<String, S>> symbolOfTypeGetter,
                       Supplier<Collection<S>> typeSymbolsGetter) {
        this(name, symbolClass, (t) -> true, symbolOfTypeSetter, symbolOfTypeGetter, typeSymbolsGetter);
    }

    private SymbolType(String name, Class<S> symbolClass, Predicate<S> assertion,
                       Supplier<Function<? super S, ? extends Symbol>> symbolOfTypeSetter,
                       Supplier<Function<String, S>> symbolOfTypeGetter,
                       Supplier<Collection<S>> typeSymbolsGetter) {
        this.name = name;
        this.assertion = assertion;
        this.symbolOfTypeSetter = symbolOfTypeSetter;
        this.symbolOfTypeGetter = symbolOfTypeGetter;
        this.symbolClass = symbolClass;
        this.typeSymbolsGetter = typeSymbolsGetter;
    }

    public boolean equals(String s) {
        return name.equals(s);
    }

    public S getSymbolOfType(String symbol) {
        try {
            return symbolOfTypeGetter.get().apply(symbol);
        }
        catch (ClassCastException e) {
            throw new SymbolResolveException("\"" + symbol + "\" is not a/an " + name, e);
        }
    }

    @Override
    public String toString() {
        return name;
    }

    public Symbol defineSymbolOfType(S symbol) {
        if (!assertion.test(symbol)) {
            // TODO: assertion
            throw new DefinitionException();
        }
        return symbolOfTypeSetter.get().apply(symbol);
    }

    public Collection<S> getCurrentElements() {
        return Collections.unmodifiableCollection(typeSymbolsGetter.get());
    }
}
