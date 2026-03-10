package com.dsa.practice.algorithms.strings;

import java.util.*;

/**
 * Collection of string manipulation and pattern matching algorithms.
 * 
 * <p>String algorithms are fundamental for text processing, searching,
 * and validation tasks.</p>
 * 
 * @author Praveen Gaddam
 * @version 1.0
 */
public class StringAlgorithms {

    /**
     * Checks if two strings are anagrams.
     * 
     * <p><b>Time Complexity:</b> O(n log n)</p>
     * <p><b>Space Complexity:</b> O(n)</p>
     * 
     * @param s1 first string
     * @param s2 second string
     * @return true if anagrams, false otherwise
     */
    public boolean isAnagram(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        return Arrays.equals(arr1, arr2);
    }

    /**
     * Reverses the order of words in a string.
     * 
     * <p><b>Time Complexity:</b> O(n)</p>
     * <p><b>Space Complexity:</b> O(n)</p>
     * 
     * @param str input string
     * @return string with words in reverse order
     */
    public String reverseWords(String str) {
        String[] words = str.trim().split("\\s+");
        StringBuilder result = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            result.append(words[i]);
            if (i > 0) {
                result.append(" ");
            }
        }
        return result.toString();
    }

    /**
     * Finds length of longest substring without repeating characters.
     * 
     * <p>Uses sliding window technique.</p>
     * 
     * <p><b>Time Complexity:</b> O(n)</p>
     * <p><b>Space Complexity:</b> O(min(n, m)) where m is charset size</p>
     * 
     * @param s input string
     * @return length of longest substring
     */
    public int longestSubstringWithoutRepeating(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int maxLength = 0;
        int start = 0;

        for (int end = 0; end < s.length(); end++) {
            char c = s.charAt(end);
            if (map.containsKey(c)) {
                start = Math.max(start, map.get(c) + 1);
            }
            map.put(c, end);
            maxLength = Math.max(maxLength, end - start + 1);
        }
        return maxLength;
    }

    /**
     * Validates if parentheses/brackets are properly matched.
     * 
     * <p><b>Time Complexity:</b> O(n)</p>
     * <p><b>Space Complexity:</b> O(n)</p>
     * 
     * @param s string containing parentheses
     * @return true if valid, false otherwise
     */
    public boolean isValidParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> pairs = new HashMap<>();
        pairs.put(')', '(');
        pairs.put('}', '{');
        pairs.put(']', '[');

        for (char c : s.toCharArray()) {
            if (pairs.containsValue(c)) {
                stack.push(c);
            } else if (pairs.containsKey(c)) {
                if (stack.isEmpty() || stack.pop() != pairs.get(c)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    /**
     * Finds all occurrences of pattern in text using KMP algorithm.
     * 
     * <p><b>Time Complexity:</b> O(n + m)</p>
     * <p><b>Space Complexity:</b> O(m)</p>
     * 
     * @param text the text to search in
     * @param pattern the pattern to search for
     * @return array of starting indices where pattern occurs
     */
    public int[] kmpSearch(String text, String pattern) {
        List<Integer> result = new ArrayList<>();
        int[] lps = computeLPSArray(pattern);
        int i = 0;
        int j = 0;

        while (i < text.length()) {
            if (pattern.charAt(j) == text.charAt(i)) {
                i++;
                j++;
            }

            if (j == pattern.length()) {
                result.add(i - j);
                j = lps[j - 1];
            } else if (i < text.length() && pattern.charAt(j) != text.charAt(i)) {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    /**
     * Computes Longest Prefix Suffix (LPS) array for KMP algorithm.
     * 
     * @param pattern the pattern string
     * @return LPS array
     */
    private int[] computeLPSArray(String pattern) {
        int[] lps = new int[pattern.length()];
        int len = 0;
        int i = 1;

        while (i < pattern.length()) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }

    /**
     * Finds the longest palindromic substring.
     * 
     * <p><b>Time Complexity:</b> O(n²)</p>
     * <p><b>Space Complexity:</b> O(1)</p>
     * 
     * @param s input string
     * @return longest palindromic substring
     */
    public String longestPalindromicSubstring(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }

        int start = 0;
        int maxLength = 0;

        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);

            if (len > maxLength) {
                maxLength = len;
                start = i - (len - 1) / 2;
            }
        }

        return s.substring(start, start + maxLength);
    }

    /**
     * Helper method to expand around center for palindrome detection.
     * 
     * @param s the string
     * @param left left pointer
     * @param right right pointer
     * @return length of palindrome
     */
    private int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}
