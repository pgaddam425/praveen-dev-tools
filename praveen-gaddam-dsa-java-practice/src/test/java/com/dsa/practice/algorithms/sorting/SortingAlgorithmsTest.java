package com.dsa.practice.algorithms.sorting;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SortingAlgorithmsTest {

    private SortingAlgorithms sortingAlgorithms;

    @BeforeEach
    void setUp() {
        sortingAlgorithms = new SortingAlgorithms();
    }

    @Test
    void testBubbleSort() {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        sortingAlgorithms.bubbleSort(arr);
        assertArrayEquals(new int[]{11, 12, 22, 25, 34, 64, 90}, arr);
    }

    @Test
    void testSelectionSort() {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        sortingAlgorithms.selectionSort(arr);
        assertArrayEquals(new int[]{11, 12, 22, 25, 34, 64, 90}, arr);
    }

    @Test
    void testInsertionSort() {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        sortingAlgorithms.insertionSort(arr);
        assertArrayEquals(new int[]{11, 12, 22, 25, 34, 64, 90}, arr);
    }

    @Test
    void testMergeSort() {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        sortingAlgorithms.mergeSort(arr);
        assertArrayEquals(new int[]{11, 12, 22, 25, 34, 64, 90}, arr);
    }

    @Test
    void testQuickSort() {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        sortingAlgorithms.quickSort(arr);
        assertArrayEquals(new int[]{11, 12, 22, 25, 34, 64, 90}, arr);
    }
}
