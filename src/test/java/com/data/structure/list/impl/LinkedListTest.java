package com.data.structure.list.impl;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {

    @Test
    void testAddAndGet() {
        LinkedList<String> list = new LinkedList<>();
        assertTrue(list.isEmpty(), "List should be empty initially");

        list.add("A");
        list.add("B");
        list.add("C");

        assertFalse(list.isEmpty(), "List should not be empty after adding elements");
        assertEquals("A", list.get(0), "First element should be 'A'");
        assertEquals("B", list.get(1), "Second element should be 'B'");
        assertEquals("C", list.get(2), "Third element should be 'C'");
    }

    @Test
    void testDelete() {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        assertEquals(3, list.size(), "List size should be 3 initially");

        int deletedValue = list.delete(1); // Удаляем второй элемент
        assertEquals(2, deletedValue, "Deleted value should be 2");
        assertEquals(2, list.size(), "List size should be 2 after deletion");
        assertEquals(1, list.get(0), "First element should remain 1");
        assertEquals(3, list.get(1), "Second element should now be 3");
    }

    @Test
    void testDeleteFirstElement() {
        LinkedList<String> list = new LinkedList<>();
        list.add("A");
        list.add("B");

        String deletedValue = list.delete(0); // Удаляем первый элемент
        assertEquals("A", deletedValue, "Deleted value should be 'A'");
        assertEquals(1, list.size(), "List size should be 1 after deletion");
        assertEquals("B", list.get(0), "First element should now be 'B'");
    }

    @Test
    void testDeleteLastElement() {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(10);
        list.add(20);
        list.add(30);

        int deletedValue = list.delete(2); // Удаляем последний элемент
        assertEquals(30, deletedValue, "Deleted value should be 30");
        assertEquals(2, list.size(), "List size should be 2 after deletion");
        assertNull(list.get(2), "There should be no element at index 2");
    }

    @Test
    void testClear() {
        LinkedList<String> list = new LinkedList<>();
        list.add("X");
        list.add("Y");
        list.add("Z");

        list.clear();
        assertTrue(list.isEmpty(), "List should be empty after clearing");
        assertEquals(0, list.size(), "List size should be 0 after clearing");
    }

    @Test
    void testGetInvalidIndex() {
        LinkedList<Double> list = new LinkedList<>();
        list.add(1.1);
        list.add(2.2);

        assertThrows(IndexOutOfBoundsException.class, () -> list.get(-1), "Negative index should throw exception");
        assertNull(list.get(2), "Accessing out-of-bounds index should return null");
    }

    @Test
    void testDeleteInvalidIndex() {
        LinkedList<Character> list = new LinkedList<>();
        list.add('A');
        list.add('B');

        assertThrows(IndexOutOfBoundsException.class, () -> list.delete(-1), "Negative index should throw exception");
        assertThrows(IndexOutOfBoundsException.class, () -> list.delete(3), "Out-of-bounds index should throw exception");
    }

    @Test
    void testIsEmpty() {
        LinkedList<Integer> list = new LinkedList<>();
        assertTrue(list.isEmpty(), "List should be empty initially");

        list.add(5);
        assertFalse(list.isEmpty(), "List should not be empty after adding an element");

        list.clear();
        assertTrue(list.isEmpty(), "List should be empty after clearing");
    }
}