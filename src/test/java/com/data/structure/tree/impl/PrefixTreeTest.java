package com.data.structure.tree.impl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PrefixTreeTest {

    @Test
    void testInsertAndSearch() {
        PrefixTree trie = new PrefixTree();

        trie.insert("apple");
        trie.insert("app");
        trie.insert("banana");
        trie.insert("band");

        assertTrue(trie.search("apple"));
        assertTrue(trie.search("app"));
        assertFalse(trie.search("apples"));
        assertTrue(trie.search("banana"));
        assertFalse(trie.search("bandana"));
    }

    @Test
    void testStartsWith() {
        PrefixTree trie = new PrefixTree();

        trie.insert("apple");
        trie.insert("app");
        trie.insert("application");
        trie.insert("banana");

        assertTrue(trie.startsWith("app"));
        assertTrue(trie.startsWith("ban"));
        assertFalse(trie.startsWith("cat"));
        assertTrue(trie.startsWith("appl"));
        assertFalse(trie.startsWith("apx"));
    }

    @Test
    void testEmptyTrie() {
        PrefixTree trie = new PrefixTree();

        assertFalse(trie.search("word"));
        assertFalse(trie.startsWith("w"));
    }

    @Test
    void testEdgeCases() {
        PrefixTree trie = new PrefixTree();

        trie.insert("");
        assertTrue(trie.search(""));
        assertTrue(trie.startsWith(""));

        trie.insert("a");
        assertTrue(trie.search("a"));
        assertFalse(trie.search("b"));
    }
}