package com.PlusCal.interp.tlaplus;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

class MultiMap<K, V> extends LinkedHashMap<K, List<V>> {

    public void map(K k, V v) {
        List<V> l = get(k);
        if (l == null) {
            l = new ArrayList<>();
            put(k, l);
        }
        l.add(v);
    }
}
