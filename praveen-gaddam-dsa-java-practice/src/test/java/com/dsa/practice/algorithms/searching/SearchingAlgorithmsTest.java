package com.dsa.practice.algorithms.searching;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SearchingAlgorithmsTest {

    private SearchingAlgorithms searchingAlgorithms;

    @BeforeEach
    void setUp() {
        searchingAlgorithms = new SearchingAlgorithms();
    }

    @Test
    void testLinearSearch() {
        int[] arr = {10, 20, 30, 40, 50};
        assertEquals(2, searchingAlgorithms.linearSearch(arr, 30));
        assertEquals(-1, searchingAlgorithms.linearSearch(arr, 100));
    }

    @Test
    void testLinearSearchFirstElement() {
        int[] arr = {10, 20, 30, 40, 50};
        assertEquals(0, searchingAlgorithms.linearSearch(arr, 10));
    }

    @Test
    void testLinearSearchLastElement() {
        int[] arr = {10, 20, 30, 40, 50};
        assertEquals(4, searchingAlgorithms.linearSearch(arr, 50));
    }

    @Test
    void testBinarySearch() {
        int[] arr = {10, 20, 30, 40, 50, 60, 70};
        assertEquals(3, searchingAlgorithms.binarySearch(arr, 40));
        assertEquals(-1, searchingAlgorithms.binarySearch(arr, 100));
    }

    @Test
    void testBinarySearchRecursive() {
        int[] arr = {10, 20, 30, 40, 50, 60, 70};
        assertEquals(3, searchingAlgorithms.binarySearchRecursive(arr, 40));
        assertEquals(-1, searchingAlgorithms.binarySearchRecursive(arr, 100));
    }

    @Test
    void testBinarySearchSingleElement() {
        int[] arr = {50};
        assertEquals(0, searchingAlgorithms.binarySearch(arr, 50));
        assertEquals(-1, searchingAlgorithms.binarySearch(arr, 100));
    }

    @Test
    void testBinarySearchEmptyArray() {
        int[] arr = {};
        assertEquals(-1, searchingAlgorithms.binarySearch(arr, 50));
    }
}
