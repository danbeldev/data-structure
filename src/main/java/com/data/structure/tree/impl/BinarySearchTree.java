package com.data.structure.tree.impl;

import com.data.structure.tree.Tree;

public class BinarySearchTree implements Tree<Integer> {

    private Node root;

    private static class Node {

        int value;
        Node left;
        Node right;

        Node(int value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    @Override
    //Сбалансированное дерево:  O(log N)
    //Несбалансированное дерево:  O(N)
    public boolean search(Integer value) {
        return search(value, root);
    }


    //Сбалансированное дерево:  O(log N)
    //Несбалансированное дерево:  O(N)
    private boolean search(Integer value, Node node) {
        if (node == null) return false;
        if (node.value == value) return true;
        if (node.value < value) return search(value, node.right);
        return search(value, node.left);
    }

    @Override
    //Сбалансированное дерево:  O(log N)
    //Несбалансированное дерево:  O(N)
    public void insert(Integer value) {
        root = insert(value, root);
    }

    //Сбалансированное дерево:  O(log N)
    //Несбалансированное дерево:  O(N)
    private Node insert(Integer value, Node node) {
        if (node == null) return new Node(value, null, null);

        if (value < node.value) {
            node.left = insert(value, node.left);
        } else if (value > node.value) {
            node.right = insert(value, node.right);
        }

        return node;
    }

    @Override
    //Сбалансированное дерево:  O(log N)
    //Несбалансированное дерево:  O(N)
    public void delete(Integer value) {
        root = delete(value, root);
    }

    //Сбалансированное дерево:  O(log N)
    //Несбалансированное дерево:  O(N)
    private Node delete(Integer value, Node node) {
        if (node == null) return null;

        if (value < node.value) {
            node.left = delete(value, node.left);
        } else if (value > node.value) {
            node.right = delete(value, node.right);
        } else {
            if (node.left == null && node.right == null) return null;
            if (node.left == null) return node.right;
            if (node.right == null) return node.left;
            var minValue = findMin(node.right).value;
            node.value = minValue;
            node.right = delete(minValue, node.right);
        }

        return node;
    }

    @Override
    //Сбалансированное дерево:  O(log N)
    //Несбалансированное дерево:  O(N)
    public Integer minValue() {
        var minNode = findMin(root);
        return minNode != null ? minNode.value : null;
    }

    @Override
    //Сбалансированное дерево:  O(log N)
    //Несбалансированное дерево:  O(N)
    public Integer maxValue() {
        var maxNode = findMax(root);
        return maxNode != null ? maxNode.value : null;
    }

    //Сбалансированное дерево:  O(log N)
    //Несбалансированное дерево:  O(N)
    private Node findMin(Node node) {
        if (node == null) return null;

        var currentNode = node;

        while (currentNode.left != null) {
            currentNode = currentNode.left;
        }

        return currentNode;
    }

    //Сбалансированное дерево:  O(log N)
    //Несбалансированное дерево:  O(N)
    private Node findMax(Node node) {
        if (node == null) return null;

        var currentNode = node;

        while (currentNode.right != null) {
            currentNode = currentNode.right;
        }

        return currentNode;
    }
}
