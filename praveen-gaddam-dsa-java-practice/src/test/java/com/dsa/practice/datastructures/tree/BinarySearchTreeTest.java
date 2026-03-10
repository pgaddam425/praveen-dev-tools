package com.dsa.practice.datastructures.tree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeTest {

    private BinarySearchTree bst;

    @BeforeEach
    void setUp() {
        bst = new BinarySearchTree();
    }

    @Test
    void testInsert() {
        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        assertTrue(bst.search(50));
        assertTrue(bst.search(30));
        assertTrue(bst.search(70));
    }

    @Test
    void testSearch() {
        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        bst.insert(20);
        bst.insert(40);
        assertTrue(bst.search(20));
        assertTrue(bst.search(40));
        assertFalse(bst.search(100));
    }

    @Test
    void testSearchEmptyTree() {
        assertFalse(bst.search(50));
    }

    @Test
    void testInsertDuplicates() {
        bst.insert(50);
        bst.insert(50);
        assertTrue(bst.search(50));
    }

    @Test
    void testMultipleInserts() {
        int[] values = {50, 30, 70, 20, 40, 60, 80};
        for (int val : values) {
            bst.insert(val);
        }
        for (int val : values) {
            assertTrue(bst.search(val));
        }
    }
}
