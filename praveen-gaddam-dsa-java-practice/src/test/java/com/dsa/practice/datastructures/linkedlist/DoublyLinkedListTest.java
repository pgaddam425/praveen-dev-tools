package com.dsa.practice.datastructures.linkedlist;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DoublyLinkedListTest {

    private DoublyLinkedList list;

    @BeforeEach
    void setUp() {
        list = new DoublyLinkedList();
    }

    @Test
    void testInsertAtBeginning() {
        list.insertAtBeginning(10);
        list.insertAtBeginning(20);
        assertEquals(2, list.size());
        assertTrue(list.search(10));
        assertTrue(list.search(20));
    }

    @Test
    void testInsertAtEnd() {
        list.insertAtEnd(10);
        list.insertAtEnd(20);
        list.insertAtEnd(30);
        assertEquals(3, list.size());
    }

    @Test
    void testDeleteNode() {
        list.insertAtEnd(10);
        list.insertAtEnd(20);
        list.insertAtEnd(30);
        list.deleteNode(20);
        assertEquals(2, list.size());
        assertFalse(list.search(20));
    }

    @Test
    void testDeleteFirstNode() {
        list.insertAtEnd(10);
        list.insertAtEnd(20);
        list.deleteNode(10);
        assertEquals(1, list.size());
        assertFalse(list.search(10));
    }

    @Test
    void testDeleteLastNode() {
        list.insertAtEnd(10);
        list.insertAtEnd(20);
        list.deleteNode(20);
        assertEquals(1, list.size());
        assertFalse(list.search(20));
    }

    @Test
    void testSearch() {
        list.insertAtEnd(10);
        list.insertAtEnd(20);
        assertTrue(list.search(10));
        assertTrue(list.search(20));
        assertFalse(list.search(30));
    }
}
