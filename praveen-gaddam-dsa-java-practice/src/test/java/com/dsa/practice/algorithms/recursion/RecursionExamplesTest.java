package com.dsa.practice.algorithms.recursion;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RecursionExamplesTest {

    private RecursionExamples recursion;

    @BeforeEach
    void setUp() {
        recursion = new RecursionExamples();
    }

    @Test
    void testFactorial() {
        assertEquals(1, recursion.factorial(0));
        assertEquals(1, recursion.factorial(1));
        assertEquals(120, recursion.factorial(5));
        assertEquals(3628800, recursion.factorial(10));
    }

    @Test
    void testFibonacci() {
        assertEquals(0, recursion.fibonacci(0));
        assertEquals(1, recursion.fibonacci(1));
        assertEquals(1, recursion.fibonacci(2));
        assertEquals(5, recursion.fibonacci(5));
        assertEquals(55, recursion.fibonacci(10));
    }

    @Test
    void testSumOfDigits() {
        assertEquals(0, recursion.sumOfDigits(0));
        assertEquals(6, recursion.sumOfDigits(123));
        assertEquals(15, recursion.sumOfDigits(12345));
    }

    @Test
    void testPower() {
        assertEquals(1, recursion.power(5, 0));
        assertEquals(5, recursion.power(5, 1));
        assertEquals(25, recursion.power(5, 2));
        assertEquals(1024, recursion.power(2, 10));
    }

    @Test
    void testReverseString() {
        assertEquals("", recursion.reverseString(""));
        assertEquals("a", recursion.reverseString("a"));
        assertEquals("olleh", recursion.reverseString("hello"));
        assertEquals("dlrow", recursion.reverseString("world"));
    }

    @Test
    void testIsPalindrome() {
        assertTrue(recursion.isPalindrome(""));
        assertTrue(recursion.isPalindrome("a"));
        assertTrue(recursion.isPalindrome("racecar"));
        assertTrue(recursion.isPalindrome("madam"));
        assertFalse(recursion.isPalindrome("hello"));
    }

    @Test
    void testGCD() {
        assertEquals(5, recursion.gcd(10, 5));
        assertEquals(6, recursion.gcd(54, 24));
        assertEquals(1, recursion.gcd(17, 13));
        assertEquals(12, recursion.gcd(48, 36));
    }

    @Test
    void testTowerOfHanoi() {
        assertEquals(1, recursion.towerOfHanoi(1, 'A', 'C', 'B'));
        assertEquals(3, recursion.towerOfHanoi(2, 'A', 'C', 'B'));
        assertEquals(7, recursion.towerOfHanoi(3, 'A', 'C', 'B'));
        assertEquals(15, recursion.towerOfHanoi(4, 'A', 'C', 'B'));
    }
}
