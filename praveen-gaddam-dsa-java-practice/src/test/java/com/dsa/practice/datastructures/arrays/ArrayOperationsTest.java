package com.dsa.practice.datastructures.arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ArrayOperationsTest {

    private ArrayOperations arrayOps;

    @BeforeEach
    void setUp() {
        arrayOps = new ArrayOperations();
    }

    @Test
    void testFindMax() {
        int[] arr = {3, 7, 2, 9, 1};
        assertEquals(9, arrayOps.findMax(arr));
    }

    @Test
    void testFindMin() {
        int[] arr = {3, 7, 2, 9, 1};
        assertEquals(1, arrayOps.findMin(arr));
    }

    @Test
    void testReverseArray() {
        int[] arr = {1, 2, 3, 4, 5};
        arrayOps.reverseArray(arr);
        assertArrayEquals(new int[]{5, 4, 3, 2, 1}, arr);
    }

    @Test
    void testRotateLeft() {
        int[] arr = {1, 2, 3, 4, 5};
        int[] result = arrayOps.rotateLeft(arr, 2);
        assertArrayEquals(new int[]{3, 4, 5, 1, 2}, result);
    }

    @Test
    void testFindMaxThrowsExceptionForEmptyArray() {
        int[] arr = {};
        assertThrows(IllegalArgumentException.class, () -> arrayOps.findMax(arr));
    }
}
