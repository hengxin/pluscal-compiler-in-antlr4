package com.PlusCal.interp.tlaplus;

import com.PlusCal.interp.symbol.Scope;

import java.util.Collection;
import java.util.Collections;

/**
 * Represent a state in tla+ for translating
 * into tla+ language
 */
abstract class State {

    protected final String context;

    protected final Scope scope;

    protected String PCNext;

    public State(String context, Scope scope) {
        this.context = context;
        this.scope = scope;
    }

    /**
     * return variables to be changed in this state
     * @return
     */
    public Collection<String> getMustChanged() {
        return Collections.emptyList();
    }

    /**
     * return variables may be changed in this state
     * @return
     */
    public Collection<String> getMayChanged() {
        return Collections.emptyList();
    }

    public final String toString() {
        throw new UnsupportedOperationException();
    }

    public abstract String toString(final boolean multi_process, boolean omitPC, int indent,
                                    Collection<String> unchanged, Collection<String> hasChanged);

    public boolean backTrack(String PCNext) {
        return false;
    }

}
