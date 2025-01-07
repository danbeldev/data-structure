package com.data.structure.list;

public interface List<V> {

    V get(int index);

    int size();

    boolean isEmpty();

    int add(V value);

    V delete(int index);

    void clear();
}
