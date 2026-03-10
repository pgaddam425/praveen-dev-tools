package com.dsa.practice.algorithms.searching;

/**
 * Collection of fundamental searching algorithms.
 * 
 * <p>Searching algorithms are used to find a specific element in a collection.
 * The choice of algorithm depends on whether the data is sorted and the size
 * of the dataset.</p>
 * 
 * <p><b>Algorithm Comparison:</b></p>
 * <table border="1">
 *   <tr><th>Algorithm</th><th>Time (Avg)</th><th>Time (Worst)</th><th>Requires Sorted</th></tr>
 *   <tr><td>Linear Search</td><td>O(n)</td><td>O(n)</td><td>No</td></tr>
 *   <tr><td>Binary Search</td><td>O(log n)</td><td>O(log n)</td><td>Yes</td></tr>
 * </table>
 * 
 * @author Praveen Gaddam
 * @version 1.0
 */
public class SearchingAlgorithms {

    /**
     * Performs linear search to find target element in array.
     * 
     * <p>Linear search checks each element sequentially until the target
     * is found or the end of array is reached. Works on both sorted and
     * unsorted arrays.</p>
     * 
     * <p><b>Algorithm:</b></p>
     * <ol>
     *   <li>Start from first element (index 0)</li>
     *   <li>Compare current element with target</li>
     *   <li>If match found, return current index</li>
     *   <li>If not found, move to next element</li>
     *   <li>Repeat until element found or end reached</li>
     * </ol>
     * 
     * <p><b>Example:</b></p>
     * <pre>
     * Array: [5, 2, 8, 1, 9], Target: 8
     * Check 5 ≠ 8
     * Check 2 ≠ 8
     * Check 8 = 8 ✓ Found at index 2
     * </pre>
     * 
     * <p><b>Time Complexity:</b></p>
     * <ul>
     *   <li>Best Case: O(1) - element at first position</li>
     *   <li>Average Case: O(n/2) ≈ O(n)</li>
     *   <li>Worst Case: O(n) - element at end or not present</li>
     * </ul>
     * 
     * <p><b>Space Complexity:</b> O(1) - only uses loop variable</p>
     * 
     * <p><b>When to Use:</b></p>
     * <ul>
     *   <li>Small datasets (n < 100)</li>
     *   <li>Unsorted data</li>
     *   <li>Single search operation</li>
     * </ul>
     * 
     * @param arr the array to search in
     * @param target the value to search for
     * @return the index of target if found, -1 otherwise
     */
    public int linearSearch(int[] arr, int target) {
        // Check each element sequentially
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {  // Found the target
                return i;             // Return its index
            }
        }
        return -1;  // Target not found in array
    }

    /**
     * Performs iterative binary search on a sorted array.
     * 
     * <p>Binary search is a divide-and-conquer algorithm that repeatedly
     * divides the search space in half. It requires the array to be sorted.</p>
     * 
     * <p><b>Algorithm:</b></p>
     * <ol>
     *   <li>Set left = 0, right = array length - 1</li>
     *   <li>While left ≤ right:</li>
     *   <li>  - Calculate mid = left + (right - left) / 2</li>
     *   <li>  - If arr[mid] equals target, return mid</li>
     *   <li>  - If arr[mid] < target, search right half (left = mid + 1)</li>
     *   <li>  - If arr[mid] > target, search left half (right = mid - 1)</li>
     *   <li>If not found, return -1</li>
     * </ol>
     * 
     * <p><b>Visual Example:</b></p>
     * <pre>
     * Array: [1, 3, 5, 7, 9, 11, 13], Target: 7
     * 
     * Step 1: left=0, right=6, mid=3
     *         [1, 3, 5, |7|, 9, 11, 13]
     *         arr[3]=7 = target ✓ Found!
     * 
     * Example 2: Target: 11
     * Step 1: left=0, right=6, mid=3, arr[3]=7 < 11
     *         Search right: [9, 11, 13]
     * Step 2: left=4, right=6, mid=5, arr[5]=11 = target ✓
     * </pre>
     * 
     * <p><b>Why mid = left + (right - left) / 2?</b></p>
     * <p>Prevents integer overflow that could occur with (left + right) / 2</p>
     * 
     * <p><b>Time Complexity:</b> O(log n) - halves search space each iteration</p>
     * <p><b>Space Complexity:</b> O(1) - only uses a few variables</p>
     * 
     * <p><b>When to Use:</b></p>
     * <ul>
     *   <li>Large sorted datasets</li>
     *   <li>Multiple search operations</li>
     *   <li>Need fast lookups</li>
     * </ul>
     * 
     * @param arr the sorted array to search in (must be sorted!)
     * @param target the value to search for
     * @return the index of target if found, -1 otherwise
     */
    public int binarySearch(int[] arr, int target) {
        int left = 0;                    // Start of search range
        int right = arr.length - 1;      // End of search range

        while (left <= right) {          // While search range is valid
            // Calculate middle index (avoids overflow)
            int mid = left + (right - left) / 2;

            // Check if middle element is the target
            if (arr[mid] == target) {
                return mid;              // Found! Return index
            }

            // Decide which half to search
            if (arr[mid] < target) {
                left = mid + 1;          // Target in right half
            } else {
                right = mid - 1;         // Target in left half
            }
        }
        return -1;  // Target not found
    }

    /**
     * Performs recursive binary search on a sorted array.
     * 
     * <p>This is the recursive version of binary search. It uses the same
     * divide-and-conquer approach but with recursive calls instead of a loop.</p>
     * 
     * <p><b>Time Complexity:</b> O(log n)</p>
     * <p><b>Space Complexity:</b> O(log n) - recursion stack depth</p>
     * 
     * @param arr the sorted array to search in
     * @param target the value to search for
     * @return the index of target if found, -1 otherwise
     */
    public int binarySearchRecursive(int[] arr, int target) {
        return binarySearchRec(arr, target, 0, arr.length - 1);
    }

    /**
     * Helper method for recursive binary search.
     * 
     * <p>This method implements the recursive logic for binary search.
     * Each recursive call searches a smaller portion of the array.</p>
     * 
     * <p><b>Recursion Tree Example for [1,3,5,7,9], target=7:</b></p>
     * <pre>
     * binarySearchRec(arr, 7, 0, 4)
     *   mid=2, arr[2]=5 < 7
     *   → binarySearchRec(arr, 7, 3, 4)
     *       mid=3, arr[3]=7 = 7 ✓
     *       → return 3
     *   → return 3
     * </pre>
     * 
     * <p><b>Base Cases:</b></p>
     * <ul>
     *   <li>left > right: search space exhausted, element not found</li>
     *   <li>arr[mid] == target: element found at mid</li>
     * </ul>
     * 
     * <p><b>Recursive Cases:</b></p>
     * <ul>
     *   <li>arr[mid] < target: search right half</li>
     *   <li>arr[mid] > target: search left half</li>
     * </ul>
     * 
     * @param arr the sorted array
     * @param target the value to find
     * @param left the left boundary of current search range
     * @param right the right boundary of current search range
     * @return the index of target if found, -1 otherwise
     */
    private int binarySearchRec(int[] arr, int target, int left, int right) {
        // Base case: search space is empty
        if (left > right) {
            return -1;  // Element not found
        }

        // Calculate middle index
        int mid = left + (right - left) / 2;

        // Base case: found the target
        if (arr[mid] == target) {
            return mid;
        }

        // Recursive case: search appropriate half
        if (arr[mid] < target) {
            // Target is in right half
            return binarySearchRec(arr, target, mid + 1, right);
        } else {
            // Target is in left half
            return binarySearchRec(arr, target, left, mid - 1);
        }
    }
}
