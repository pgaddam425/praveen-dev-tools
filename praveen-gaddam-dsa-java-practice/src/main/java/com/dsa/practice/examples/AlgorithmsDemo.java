package com.dsa.practice.examples;

import com.dsa.practice.algorithms.sorting.SortingAlgorithms;
import com.dsa.practice.algorithms.searching.SearchingAlgorithms;
import com.dsa.practice.algorithms.recursion.RecursionExamples;
import com.dsa.practice.algorithms.dynamicprogramming.DynamicProgramming;
import com.dsa.practice.algorithms.strings.StringAlgorithms;

import java.util.Arrays;

/**
 * Demonstration of all algorithm implementations.
 * 
 * <p>This class provides example usage of sorting, searching,
 * recursion, dynamic programming, and string algorithms.</p>
 * 
 * @author Praveen Gaddam
 * @version 1.0
 */
public class AlgorithmsDemo {

    /**
     * Main method to run all algorithm demonstrations.
     * 
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        System.out.println("=== Algorithms Demo ===\n");

        sortingDemo();
        searchingDemo();
        recursionDemo();
        dynamicProgrammingDemo();
        stringAlgorithmsDemo();
    }

    private static void sortingDemo() {
        System.out.println("1. Sorting Algorithms:");
        SortingAlgorithms sorting = new SortingAlgorithms();

        int[] arr1 = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("Original: " + Arrays.toString(arr1));
        sorting.bubbleSort(arr1);
        System.out.println("Bubble Sort: " + Arrays.toString(arr1));

        int[] arr2 = {64, 34, 25, 12, 22, 11, 90};
        sorting.quickSort(arr2);
        System.out.println("Quick Sort: " + Arrays.toString(arr2));
        System.out.println();
    }

    private static void searchingDemo() {
        System.out.println("2. Searching Algorithms:");
        SearchingAlgorithms searching = new SearchingAlgorithms();

        int[] arr = {10, 20, 30, 40, 50, 60, 70};
        System.out.println("Array: " + Arrays.toString(arr));
        System.out.println("Linear Search for 40: Index " + searching.linearSearch(arr, 40));
        System.out.println("Binary Search for 40: Index " + searching.binarySearch(arr, 40));
        System.out.println();
    }

    private static void recursionDemo() {
        System.out.println("3. Recursion Examples:");
        RecursionExamples recursion = new RecursionExamples();

        System.out.println("Factorial of 5: " + recursion.factorial(5));
        System.out.println("Fibonacci of 10: " + recursion.fibonacci(10));
        System.out.println("Sum of digits 12345: " + recursion.sumOfDigits(12345));
        System.out.println("Is 'racecar' palindrome? " + recursion.isPalindrome("racecar"));
        System.out.println();
    }

    private static void dynamicProgrammingDemo() {
        System.out.println("4. Dynamic Programming:");
        DynamicProgramming dp = new DynamicProgramming();

        System.out.println("Fibonacci DP of 10: " + dp.fibonacciDP(10));
        System.out.println("Climb stairs (5 steps): " + dp.climbStairs(5));
        System.out.println("LCS of 'AGGTAB' and 'GXTXAYB': " + dp.longestCommonSubsequence("AGGTAB", "GXTXAYB"));
        System.out.println();
    }

    private static void stringAlgorithmsDemo() {
        System.out.println("5. String Algorithms:");
        StringAlgorithms stringAlgo = new StringAlgorithms();

        System.out.println("Is 'listen' anagram of 'silent'? " + stringAlgo.isAnagram("listen", "silent"));
        System.out.println("Reverse words 'hello world': " + stringAlgo.reverseWords("hello world"));
        System.out.println("Longest substring without repeating in 'abcabcbb': " + 
            stringAlgo.longestSubstringWithoutRepeating("abcabcbb"));
        System.out.println();
    }
}
