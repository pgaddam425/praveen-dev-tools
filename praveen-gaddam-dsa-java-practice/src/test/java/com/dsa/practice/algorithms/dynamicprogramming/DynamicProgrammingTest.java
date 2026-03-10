package com.dsa.practice.algorithms.dynamicprogramming;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DynamicProgrammingTest {

    private DynamicProgramming dp;

    @BeforeEach
    void setUp() {
        dp = new DynamicProgramming();
    }

    @Test
    void testFibonacciDP() {
        assertEquals(0, dp.fibonacciDP(0));
        assertEquals(1, dp.fibonacciDP(1));
        assertEquals(55, dp.fibonacciDP(10));
        assertEquals(6765, dp.fibonacciDP(20));
    }

    @Test
    void testClimbStairs() {
        assertEquals(1, dp.climbStairs(1));
        assertEquals(2, dp.climbStairs(2));
        assertEquals(3, dp.climbStairs(3));
        assertEquals(5, dp.climbStairs(4));
        assertEquals(8, dp.climbStairs(5));
    }

    @Test
    void testKnapsack01() {
        int[] weights = {1, 2, 3};
        int[] values = {10, 15, 40};
        assertEquals(55, dp.knapsack01(weights, values, 6));
    }

    @Test
    void testKnapsack01NoItems() {
        int[] weights = {5, 6, 7};
        int[] values = {10, 15, 20};
        assertEquals(0, dp.knapsack01(weights, values, 3));
    }

    @Test
    void testLongestCommonSubsequence() {
        assertEquals(3, dp.longestCommonSubsequence("abcde", "ace"));
        assertEquals(3, dp.longestCommonSubsequence("abc", "abc"));
        assertEquals(0, dp.longestCommonSubsequence("abc", "def"));
        assertEquals(4, dp.longestCommonSubsequence("AGGTAB", "GXTXAYB"));
    }

    @Test
    void testCoinChange() {
        int[] coins = {1, 2, 5};
        assertEquals(3, dp.coinChange(coins, 11));
        assertEquals(1, dp.coinChange(coins, 5));
        assertEquals(-1, dp.coinChange(new int[]{2}, 3));
    }

    @Test
    void testLongestIncreasingSubsequence() {
        assertEquals(4, dp.longestIncreasingSubsequence(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
        assertEquals(1, dp.longestIncreasingSubsequence(new int[]{7, 7, 7, 7}));
        assertEquals(6, dp.longestIncreasingSubsequence(new int[]{0, 1, 0, 3, 2, 3}));
    }

    @Test
    void testEditDistance() {
        assertEquals(3, dp.editDistance("horse", "ros"));
        assertEquals(5, dp.editDistance("intention", "execution"));
        assertEquals(0, dp.editDistance("abc", "abc"));
        assertEquals(3, dp.editDistance("abc", ""));
    }
}
