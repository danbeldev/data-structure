package com.data.structure.tree.impl;

import com.data.structure.tree.Tree;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeTest {


    private Tree<Integer> tree;

    @BeforeEach
    void setUp() {
        tree = new BinarySearchTree();
    }

    @Test
    void testInsertAndSearch() {
        tree.insert(10);
        tree.insert(5);
        tree.insert(15);

        assertTrue(tree.search(10), "Value 10 should be found in the tree.");
        assertTrue(tree.search(5), "Value 5 should be found in the tree.");
        assertTrue(tree.search(15), "Value 15 should be found in the tree.");
        assertFalse(tree.search(20), "Value 20 should not be found in the tree.");
    }

    @Test
    void testDelete() {
        tree.insert(10);
        tree.insert(5);
        tree.insert(15);
        tree.delete(5);

        assertFalse(tree.search(5), "Value 5 should be removed from the tree.");
        assertTrue(tree.search(10), "Value 10 should still be in the tree.");
        assertTrue(tree.search(15), "Value 15 should still be in the tree.");
    }

    @Test
    void testMinValue() {
        tree.insert(10);
        tree.insert(5);
        tree.insert(15);
        tree.insert(3);

        assertEquals(3, tree.minValue(), "Minimum value should be 3.");
    }

    @Test
    void testMaxValue() {
        tree.insert(10);
        tree.insert(5);
        tree.insert(15);
        tree.insert(20);

        assertEquals(20, tree.maxValue(), "Maximum value should be 20.");
    }

    @Test
    void testEmptyTreeMinValue() {
        assertNull(tree.minValue());
    }

    @Test
    void testEmptyTreeMaxValue() {
        assertNull(tree.maxValue());
    }
}