package com.dsa.practice.datastructures.queue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class QueueTest {

    private Queue queue;

    @BeforeEach
    void setUp() {
        queue = new Queue(5);
    }

    @Test
    void testEnqueue() {
        queue.enqueue(10);
        queue.enqueue(20);
        assertEquals(2, queue.size());
    }

    @Test
    void testDequeue() {
        queue.enqueue(10);
        queue.enqueue(20);
        assertEquals(10, queue.dequeue());
        assertEquals(20, queue.dequeue());
    }

    @Test
    void testPeek() {
        queue.enqueue(10);
        queue.enqueue(20);
        assertEquals(10, queue.peek());
        assertEquals(2, queue.size());
    }

    @Test
    void testIsEmpty() {
        assertTrue(queue.isEmpty());
        queue.enqueue(10);
        assertFalse(queue.isEmpty());
    }

    @Test
    void testIsFull() {
        assertFalse(queue.isFull());
        for (int i = 0; i < 5; i++) {
            queue.enqueue(i);
        }
        assertTrue(queue.isFull());
    }

    @Test
    void testCircularBehavior() {
        for (int i = 0; i < 5; i++) {
            queue.enqueue(i);
        }
        queue.dequeue();
        queue.dequeue();
        queue.enqueue(100);
        queue.enqueue(200);
        assertEquals(5, queue.size());
    }

    @Test
    void testEnqueueFullQueue() {
        for (int i = 0; i < 5; i++) {
            queue.enqueue(i);
        }
        assertThrows(RuntimeException.class, () -> queue.enqueue(100));
    }
}
