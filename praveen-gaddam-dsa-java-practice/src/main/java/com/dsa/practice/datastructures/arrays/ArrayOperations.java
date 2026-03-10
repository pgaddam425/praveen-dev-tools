package com.dsa.practice.datastructures.arrays;

/**
 * ArrayOperations provides fundamental operations on integer arrays.
 * 
 * <p>This class demonstrates basic array manipulation techniques including
 * finding extrema, reversing, and rotating arrays. All operations are
 * implemented with optimal time and space complexity.</p>
 * 
 * <p><b>Key Concepts:</b></p>
 * <ul>
 *   <li>Arrays are fixed-size, contiguous memory structures</li>
 *   <li>Random access is O(1) using indices</li>
 *   <li>In-place operations minimize space usage</li>
 * </ul>
 * 
 * @author DSA Practice
 * @version 1.0
 */
public class ArrayOperations {

    /**
     * Finds the maximum element in an array.
     * 
     * <p>This method performs a linear scan through the array, comparing each
     * element with the current maximum. It's a fundamental operation used in
     * many algorithms.</p>
     * 
     * <p><b>Algorithm:</b></p>
     * <ol>
     *   <li>Initialize max with the first element</li>
     *   <li>Iterate through remaining elements</li>
     *   <li>Update max if a larger element is found</li>
     * </ol>
     * 
     * <p><b>Time Complexity:</b> O(n) - must examine every element</p>
     * <p><b>Space Complexity:</b> O(1) - only uses a single variable</p>
     * 
     * @param arr the input array to search
     * @return the maximum value in the array
     * @throws IllegalArgumentException if array is null or empty
     * 
     * @example
     * <pre>
     * int[] arr = {3, 7, 2, 9, 1};
     * int max = findMax(arr); // returns 9
     * </pre>
     */
    public int findMax(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Array cannot be null or empty");
        }
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    /**
     * Finds the minimum element in an array.
     * 
     * <p>Similar to findMax, this method performs a linear scan to identify
     * the smallest element. This is useful for range calculations, normalization,
     * and various statistical operations.</p>
     * 
     * <p><b>Algorithm:</b></p>
     * <ol>
     *   <li>Initialize min with the first element</li>
     *   <li>Iterate through remaining elements</li>
     *   <li>Update min if a smaller element is found</li>
     * </ol>
     * 
     * <p><b>Time Complexity:</b> O(n)</p>
     * <p><b>Space Complexity:</b> O(1)</p>
     * 
     * @param arr the input array to search
     * @return the minimum value in the array
     * @throws IllegalArgumentException if array is null or empty
     * 
     * @example
     * <pre>
     * int[] arr = {3, 7, 2, 9, 1};
     * int min = findMin(arr); // returns 1
     * </pre>
     */
    public int findMin(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Array cannot be null or empty");
        }
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }

    /**
     * Reverses an array in-place using the two-pointer technique.
     * 
     * <p>This method swaps elements from both ends of the array, moving towards
     * the center. It's an efficient in-place algorithm that doesn't require
     * additional memory.</p>
     * 
     * <p><b>Algorithm (Two-Pointer Technique):</b></p>
     * <ol>
     *   <li>Initialize left pointer at start (0)</li>
     *   <li>Initialize right pointer at end (length-1)</li>
     *   <li>While left < right:
     *     <ul>
     *       <li>Swap arr[left] and arr[right]</li>
     *       <li>Move left forward, right backward</li>
     *     </ul>
     *   </li>
     * </ol>
     * 
     * <p><b>Time Complexity:</b> O(n) - visits n/2 pairs</p>
     * <p><b>Space Complexity:</b> O(1) - in-place modification</p>
     * 
     * @param arr the array to reverse (modified in-place)
     * 
     * @example
     * <pre>
     * int[] arr = {1, 2, 3, 4, 5};
     * reverseArray(arr);
     * // arr is now {5, 4, 3, 2, 1}
     * </pre>
     */
    public void reverseArray(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    /**
     * Rotates an array to the left by k positions.
     * 
     * <p>This method creates a new array where each element is shifted left
     * by k positions. Elements that "fall off" the left end wrap around to
     * the right end. The rotation amount is normalized using modulo to handle
     * cases where k > array length.</p>
     * 
     * <p><b>Algorithm:</b></p>
     * <ol>
     *   <li>Normalize k using modulo (k = k % n)</li>
     *   <li>Create result array of same size</li>
     *   <li>For each position i, place arr[(i+k) % n] at result[i]</li>
     * </ol>
     * 
     * <p><b>Example:</b> Rotating [1,2,3,4,5] left by 2 gives [3,4,5,1,2]</p>
     * 
     * <p><b>Time Complexity:</b> O(n) - single pass through array</p>
     * <p><b>Space Complexity:</b> O(n) - creates new array</p>
     * 
     * <p><b>Note:</b> For in-place rotation with O(1) space, consider the
     * reversal algorithm: reverse(0,k-1), reverse(k,n-1), reverse(0,n-1)</p>
     * 
     * @param arr the input array to rotate
     * @param k the number of positions to rotate left
     * @return a new array with elements rotated left by k positions
     * 
     * @example
     * <pre>
     * int[] arr = {1, 2, 3, 4, 5};
     * int[] rotated = rotateLeft(arr, 2);
     * // rotated is {3, 4, 5, 1, 2}
     * </pre>
     */
    public int[] rotateLeft(int[] arr, int k) {
        if (arr == null || arr.length == 0) {
            return arr;
        }
        int n = arr.length;
        k = k % n;
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = arr[(i + k) % n];
        }
        return result;
    }
}
