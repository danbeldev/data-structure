package com.data.structure.list.impl;

import com.data.structure.list.List;

public class LinkedList<V> implements List<V> {

    private Node<V> root;

    private static class Node<V> {
        V value;
        Node<V> next;

        Node(V value, Node<V> next) {
            this.value = value;
            this.next = next;
        }
    }

    @Override
    // Time: O(n)
    public V get(int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException("Index cannot be negative.");
        }
        var node = getNode(index);
        return node == null ? null : node.value;
    }

    @Override
    // Time: O(n)
    public int size() {
        int size = 0;
        var currentNode = root;
        while (currentNode != null) {
            size++;
            currentNode = currentNode.next;
        }
        return size;
    }

    @Override
    // Time: O(1)
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    // Time: O(n)
    public int add(V value) {
        if (root == null) {
            root = new Node<>(value, null);
            return 0;
        }

        var currentIndex = 0;
        var currentNode = root;

        while (currentNode.next != null) {
            currentIndex++;
            currentNode = currentNode.next;
        }

        currentNode.next = new Node<>(value, null);
        return currentIndex + 1;
    }

    @Override
    // Time: O(n)
    public V delete(int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException("Index is out of bounds.");
        }

        if (root == null) {
            return null;
        }

        if (index == 0) {
            var deletedValue = root.value;
            root = root.next;
            return deletedValue;
        }

        var prev = getNode(index - 1);
        if (prev == null || prev.next == null) {
            throw new IndexOutOfBoundsException("Index is out of bounds.");
        }

        var deletedValue = prev.next.value;
        prev.next = prev.next.next;
        return deletedValue;
    }

    @Override
    // Time: O(1)
    public void clear() {
        root = null;
    }

    // Time: O(n)
    private Node<V> getNode(int index) {
        if (index < 0) {
            return null;
        }

        var currentIndex = 0;
        var currentNode = root;

        while (currentNode != null && currentIndex < index) {
            currentNode = currentNode.next;
            currentIndex++;
        }

        return currentNode;
    }
}