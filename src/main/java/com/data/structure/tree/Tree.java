package com.data.structure.tree;

public interface Tree<T> {

    boolean search(T value);

    void insert(T value);

    void delete(T value);

    T minValue();

    T maxValue();
}
