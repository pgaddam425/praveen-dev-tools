package com.dsa.practice.datastructures.stack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StackTest {

    private Stack stack;

    @BeforeEach
    void setUp() {
        stack = new Stack(5);
    }

    @Test
    void testPush() {
        stack.push(10);
        stack.push(20);
        assertEquals(2, stack.size());
    }

    @Test
    void testPop() {
        stack.push(10);
        stack.push(20);
        assertEquals(20, stack.pop());
        assertEquals(10, stack.pop());
    }

    @Test
    void testPeek() {
        stack.push(10);
        stack.push(20);
        assertEquals(20, stack.peek());
        assertEquals(2, stack.size());
    }

    @Test
    void testIsEmpty() {
        assertTrue(stack.isEmpty());
        stack.push(10);
        assertFalse(stack.isEmpty());
    }

    @Test
    void testIsFull() {
        assertFalse(stack.isFull());
        for (int i = 0; i < 5; i++) {
            stack.push(i);
        }
        assertTrue(stack.isFull());
    }

    @Test
    void testStackOverflow() {
        for (int i = 0; i < 5; i++) {
            stack.push(i);
        }
        assertThrows(StackOverflowError.class, () -> stack.push(100));
    }

    @Test
    void testPopEmptyStack() {
        assertThrows(RuntimeException.class, () -> stack.pop());
    }
}
