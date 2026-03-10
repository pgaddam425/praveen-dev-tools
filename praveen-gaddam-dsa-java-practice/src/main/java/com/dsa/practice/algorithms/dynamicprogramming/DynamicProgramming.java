package com.dsa.practice.algorithms.dynamicprogramming;

/**
 * Collection of Dynamic Programming (DP) algorithm solutions.
 * 
 * <p>Dynamic Programming is an optimization technique that solves complex problems
 * by breaking them down into simpler subproblems and storing their solutions to
 * avoid redundant calculations.</p>
 * 
 * <p><b>Key Principles:</b></p>
 * <ul>
 *   <li><b>Optimal Substructure:</b> Optimal solution contains optimal solutions to subproblems</li>
 *   <li><b>Overlapping Subproblems:</b> Same subproblems are solved multiple times</li>
 *   <li><b>Memoization:</b> Top-down approach with caching</li>
 *   <li><b>Tabulation:</b> Bottom-up approach with table filling</li>
 * </ul>
 * 
 * @author Praveen Gaddam
 * @version 1.0
 */
public class DynamicProgramming {

    /**
     * Calculates nth Fibonacci number using Dynamic Programming.
     * 
     * <p><b>Time Complexity:</b> O(n)</p>
     * <p><b>Space Complexity:</b> O(n)</p>
     * 
     * @param n the position in Fibonacci sequence
     * @return the nth Fibonacci number
     */
    public int fibonacciDP(int n) {
        if (n <= 1) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    /**
     * Calculates number of ways to climb n stairs (1 or 2 steps at a time).
     * 
     * <p><b>Time Complexity:</b> O(n)</p>
     * <p><b>Space Complexity:</b> O(n)</p>
     * 
     * @param n the number of stairs
     * @return the number of distinct ways to climb
     */
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    /**
     * Solves the 0/1 Knapsack problem using Dynamic Programming.
     * 
     * <p><b>Time Complexity:</b> O(n × capacity)</p>
     * <p><b>Space Complexity:</b> O(n × capacity)</p>
     * 
     * @param weights array of item weights
     * @param values array of item values
     * @param capacity maximum weight capacity
     * @return maximum value achievable
     */
    public int knapsack01(int[] weights, int[] values, int capacity) {
        int n = weights.length;
        int[][] dp = new int[n + 1][capacity + 1];

        for (int i = 1; i <= n; i++) {
            for (int w = 1; w <= capacity; w++) {
                if (weights[i - 1] <= w) {
                    dp[i][w] = Math.max(
                        values[i - 1] + dp[i - 1][w - weights[i - 1]],
                        dp[i - 1][w]
                    );
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }
        return dp[n][capacity];
    }

    /**
     * Finds the length of Longest Common Subsequence (LCS) between two strings.
     * 
     * <p><b>Time Complexity:</b> O(m × n)</p>
     * <p><b>Space Complexity:</b> O(m × n)</p>
     * 
     * @param text1 the first string
     * @param text2 the second string
     * @return length of LCS
     */
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }

    /**
     * Finds minimum number of coins needed to make given amount.
     * 
     * <p><b>Time Complexity:</b> O(amount × coins.length)</p>
     * <p><b>Space Complexity:</b> O(amount)</p>
     * 
     * @param coins array of coin denominations
     * @param amount target amount
     * @return minimum coins needed, or -1 if impossible
     */
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            dp[i] = amount + 1;
        }
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    /**
     * Finds the length of Longest Increasing Subsequence (LIS).
     * 
     * <p><b>Time Complexity:</b> O(n²)</p>
     * <p><b>Space Complexity:</b> O(n)</p>
     * 
     * @param nums the input array
     * @return length of LIS
     */
    public int longestIncreasingSubsequence(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
        }

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int max = 0;
        for (int length : dp) {
            max = Math.max(max, length);
        }
        return max;
    }

    /**
     * Calculates minimum edit distance (Levenshtein distance) between two strings.
     * 
     * <p>Operations allowed: insert, delete, replace a character.</p>
     * 
     * <p><b>Time Complexity:</b> O(m × n)</p>
     * <p><b>Space Complexity:</b> O(m × n)</p>
     * 
     * @param word1 the first string
     * @param word2 the second string
     * @return minimum number of operations needed
     */
    public int editDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(
                        Math.min(dp[i - 1][j], dp[i][j - 1]),
                        dp[i - 1][j - 1]
                    );
                }
            }
        }
        return dp[m][n];
    }
}
