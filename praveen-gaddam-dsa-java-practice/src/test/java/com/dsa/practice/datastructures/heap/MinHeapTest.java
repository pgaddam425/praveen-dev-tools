package com.dsa.practice.datastructures.heap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MinHeapTest {

    private MinHeap heap;

    @BeforeEach
    void setUp() {
        heap = new MinHeap(10);
    }

    @Test
    void testInsert() {
        heap.insert(10);
        heap.insert(5);
        heap.insert(20);
        assertEquals(5, heap.peek());
    }

    @Test
    void testExtractMin() {
        heap.insert(10);
        heap.insert(5);
        heap.insert(20);
        heap.insert(1);
        assertEquals(1, heap.extractMin());
        assertEquals(5, heap.extractMin());
        assertEquals(10, heap.extractMin());
    }

    @Test
    void testPeek() {
        heap.insert(10);
        heap.insert(5);
        assertEquals(5, heap.peek());
        assertEquals(2, heap.getSize());
    }

    @Test
    void testIsEmpty() {
        assertTrue(heap.isEmpty());
        heap.insert(10);
        assertFalse(heap.isEmpty());
    }

    @Test
    void testHeapProperty() {
        int[] values = {50, 30, 20, 15, 10, 8, 16};
        for (int val : values) {
            heap.insert(val);
        }
        int prev = heap.extractMin();
        while (!heap.isEmpty()) {
            int current = heap.extractMin();
            assertTrue(current >= prev);
            prev = current;
        }
    }

    @Test
    void testInsertFullHeap() {
        for (int i = 0; i < 10; i++) {
            heap.insert(i);
        }
        assertThrows(RuntimeException.class, () -> heap.insert(100));
    }
}
