package com.data.structure.tree.impl;

import com.data.structure.tree.Tree;

public class PrefixTree implements Tree<String> {

    public static class Node {
        private final Node[] children = new Node[26];
        private boolean isEndOfWord;
    }

    private final Node root = new Node();

    @Override
    //  O(L) , где  L  — длина слова word
    public void insert(String word) {
        Node node = root;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (node.children[index] == null) {
                node.children[index] = new Node();
            }
            node = node.children[index];
        }
        node.isEndOfWord = true;
    }

    @Override
    //  O(L) , где  L  — длина слова word
    public boolean search(String word) {
        Node node = root;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (node.children[index] == null) {
                return false;
            }
            node = node.children[index];
        }
        return node.isEndOfWord;
    }

    @Override
    public void delete(String value) {}

    @Override
    public String minValue() {
        return "";
    }

    @Override
    public String maxValue() {
        return "";
    }

    // O(L) , где  L  — длина префикса
    public boolean startsWith(String prefix) {
        Node node = root;
        for (char ch : prefix.toCharArray()) {
            int index = ch - 'a';
            if (node.children[index] == null) {
                return false;
            }
            node = node.children[index];
        }
        return true;
    }
}

