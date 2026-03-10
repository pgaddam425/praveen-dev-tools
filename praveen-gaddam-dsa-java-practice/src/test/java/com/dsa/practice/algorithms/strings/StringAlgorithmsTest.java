package com.dsa.practice.algorithms.strings;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StringAlgorithmsTest {

    private StringAlgorithms stringAlgorithms;

    @BeforeEach
    void setUp() {
        stringAlgorithms = new StringAlgorithms();
    }

    @Test
    void testIsAnagram() {
        assertTrue(stringAlgorithms.isAnagram("listen", "silent"));
        assertTrue(stringAlgorithms.isAnagram("anagram", "nagaram"));
        assertFalse(stringAlgorithms.isAnagram("rat", "car"));
        assertFalse(stringAlgorithms.isAnagram("hello", "world"));
    }

    @Test
    void testReverseWords() {
        assertEquals("world hello", stringAlgorithms.reverseWords("hello world"));
        assertEquals("DSA Java", stringAlgorithms.reverseWords("Java DSA"));
        assertEquals("word", stringAlgorithms.reverseWords("word"));
    }

    @Test
    void testLongestSubstringWithoutRepeating() {
        assertEquals(3, stringAlgorithms.longestSubstringWithoutRepeating("abcabcbb"));
        assertEquals(1, stringAlgorithms.longestSubstringWithoutRepeating("bbbbb"));
        assertEquals(3, stringAlgorithms.longestSubstringWithoutRepeating("pwwkew"));
        assertEquals(0, stringAlgorithms.longestSubstringWithoutRepeating(""));
    }

    @Test
    void testIsValidParentheses() {
        assertTrue(stringAlgorithms.isValidParentheses("()"));
        assertTrue(stringAlgorithms.isValidParentheses("()[]{}"));
        assertTrue(stringAlgorithms.isValidParentheses("{[]}"));
        assertFalse(stringAlgorithms.isValidParentheses("(]"));
        assertFalse(stringAlgorithms.isValidParentheses("([)]"));
    }

    @Test
    void testKMPSearch() {
        int[] result = stringAlgorithms.kmpSearch("ABABDABACDABABCABAB", "ABABCABAB");
        assertEquals(1, result.length);
        assertEquals(10, result[0]);
    }

    @Test
    void testKMPSearchMultipleOccurrences() {
        int[] result = stringAlgorithms.kmpSearch("AABAACAADAABAABA", "AABA");
        assertEquals(3, result.length);
    }

    @Test
    void testKMPSearchNoMatch() {
        int[] result = stringAlgorithms.kmpSearch("ABABAB", "XYZ");
        assertEquals(0, result.length);
    }

    @Test
    void testLongestPalindromicSubstring() {
        assertEquals("bab", stringAlgorithms.longestPalindromicSubstring("babad"));
        assertEquals("bb", stringAlgorithms.longestPalindromicSubstring("cbbd"));
        assertEquals("a", stringAlgorithms.longestPalindromicSubstring("a"));
    }
}
