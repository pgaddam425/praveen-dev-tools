package com.dsa.practice.algorithms.sorting;

/**
 * Collection of fundamental sorting algorithms.
 * 
 * <p>This class provides implementations of various sorting algorithms, each with
 * different time and space complexity characteristics. All methods sort arrays
 * in ascending order and modify the input array in-place (except where noted).</p>
 * 
 * <p><b>Sorting Algorithm Comparison:</b></p>
 * <table border="1">
 *   <tr><th>Algorithm</th><th>Best</th><th>Average</th><th>Worst</th><th>Space</th><th>Stable</th></tr>
 *   <tr><td>Bubble</td><td>O(n)</td><td>O(n²)</td><td>O(n²)</td><td>O(1)</td><td>Yes</td></tr>
 *   <tr><td>Selection</td><td>O(n²)</td><td>O(n²)</td><td>O(n²)</td><td>O(1)</td><td>No</td></tr>
 *   <tr><td>Insertion</td><td>O(n)</td><td>O(n²)</td><td>O(n²)</td><td>O(1)</td><td>Yes</td></tr>
 *   <tr><td>Merge</td><td>O(n log n)</td><td>O(n log n)</td><td>O(n log n)</td><td>O(n)</td><td>Yes</td></tr>
 *   <tr><td>Quick</td><td>O(n log n)</td><td>O(n log n)</td><td>O(n²)</td><td>O(log n)</td><td>No</td></tr>
 * </table>
 * 
 * @author Praveen Gaddam
 * @version 1.0
 */
public class SortingAlgorithms {

    /**
     * Sorts an array using the Bubble Sort algorithm.
     * 
     * <p>Bubble Sort repeatedly steps through the array, compares adjacent elements,
     * and swaps them if they're in the wrong order. The largest element "bubbles up"
     * to its correct position in each pass.</p>
     * 
     * <p><b>Algorithm:</b></p>
     * <ol>
     *   <li>For each pass (i = 0 to n-1):</li>
     *   <li>Compare adjacent pairs from start to (n-i-1)</li>
     *   <li>Swap if left element > right element</li>
     *   <li>After each pass, the largest unsorted element is in its final position</li>
     * </ol>
     * 
     * <p><b>Time Complexity:</b></p>
     * <ul>
     *   <li>Best: O(n) - when array is already sorted (with optimization)</li>
     *   <li>Average: O(n²)</li>
     *   <li>Worst: O(n²) - when array is reverse sorted</li>
     * </ul>
     * 
     * <p><b>Space Complexity:</b> O(1) - in-place sorting</p>
     * <p><b>Stability:</b> Stable - maintains relative order of equal elements</p>
     * 
     * <p><b>When to Use:</b> Small datasets, nearly sorted data, educational purposes</p>
     * 
     * @param arr the array to be sorted (modified in-place)
     */
    public void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    /**
     * Sorts an array using the Selection Sort algorithm.
     * 
     * <p>Selection Sort divides the array into sorted and unsorted regions.
     * It repeatedly finds the minimum element from the unsorted region and
     * places it at the beginning of the unsorted region.</p>
     * 
     * <p><b>Algorithm:</b></p>
     * <ol>
     *   <li>For each position i (0 to n-2):</li>
     *   <li>Find the minimum element in arr[i...n-1]</li>
     *   <li>Swap it with arr[i]</li>
     *   <li>Now arr[0...i] is sorted</li>
     * </ol>
     * 
     * <p><b>Time Complexity:</b> O(n²) in all cases - always performs n(n-1)/2 comparisons</p>
     * <p><b>Space Complexity:</b> O(1) - in-place sorting</p>
     * <p><b>Stability:</b> Not stable - may change relative order of equal elements</p>
     * 
     * <p><b>Advantages:</b></p>
     * <ul>
     *   <li>Minimizes number of swaps - only n-1 swaps needed</li>
     *   <li>Useful when write operations are expensive</li>
     * </ul>
     * 
     * @param arr the array to be sorted (modified in-place)
     */
    public void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }
            int temp = arr[minIdx];
            arr[minIdx] = arr[i];
            arr[i] = temp;
        }
    }

    /**
     * Sorts an array using the Insertion Sort algorithm.
     * 
     * <p>Insertion Sort builds the final sorted array one element at a time.
     * It picks each element and inserts it into its correct position in the
     * already sorted portion of the array, similar to sorting playing cards.</p>
     * 
     * <p><b>Algorithm:</b></p>
     * <ol>
     *   <li>Start from the second element (index 1)</li>
     *   <li>Store current element as 'key'</li>
     *   <li>Shift all elements greater than key one position right</li>
     *   <li>Insert key at the correct position</li>
     * </ol>
     * 
     * <p><b>Time Complexity:</b></p>
     * <ul>
     *   <li>Best: O(n) - when array is already sorted</li>
     *   <li>Average: O(n²)</li>
     *   <li>Worst: O(n²) - when array is reverse sorted</li>
     * </ul>
     * 
     * <p><b>Space Complexity:</b> O(1) - in-place sorting</p>
     * <p><b>Stability:</b> Stable - maintains relative order of equal elements</p>
     * 
     * <p><b>When to Use:</b></p>
     * <ul>
     *   <li>Small datasets (typically n < 50)</li>
     *   <li>Nearly sorted data (performs very well)</li>
     *   <li>Online sorting (can sort data as it arrives)</li>
     * </ul>
     * 
     * @param arr the array to be sorted (modified in-place)
     */
    public void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    /**
     * Sorts an array using the Merge Sort algorithm.
     * 
     * <p>Merge Sort is a divide-and-conquer algorithm that divides the array into
     * two halves, recursively sorts them, and then merges the sorted halves.
     * It guarantees O(n log n) performance in all cases.</p>
     * 
     * <p><b>Algorithm (Divide and Conquer):</b></p>
     * <ol>
     *   <li>Divide: Split array into two halves</li>
     *   <li>Conquer: Recursively sort both halves</li>
     *   <li>Combine: Merge the two sorted halves</li>
     * </ol>
     * 
     * <p><b>Time Complexity:</b> O(n log n) in all cases (best, average, worst)</p>
     * <p><b>Space Complexity:</b> O(n) - requires temporary arrays for merging</p>
     * <p><b>Stability:</b> Stable - maintains relative order of equal elements</p>
     * 
     * <p><b>Advantages:</b></p>
     * <ul>
     *   <li>Guaranteed O(n log n) performance</li>
     *   <li>Stable sorting algorithm</li>
     *   <li>Excellent for linked lists (no random access needed)</li>
     *   <li>Parallelizable</li>
     * </ul>
     * 
     * <p><b>When to Use:</b> Large datasets, need guaranteed performance, stability required</p>
     * 
     * @param arr the array to be sorted (modified in-place)
     */
    public void mergeSort(int[] arr) {
        if (arr.length < 2) {
            return;
        }
        mergeSortRec(arr, 0, arr.length - 1);
    }

    /**
     * Recursive helper method for merge sort.
     * 
     * @param arr the array being sorted
     * @param left the starting index of the subarray
     * @param right the ending index of the subarray
     */
    private void mergeSortRec(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSortRec(arr, left, mid);
            mergeSortRec(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    /**
     * Merges two sorted subarrays into a single sorted subarray.
     * 
     * <p>This is the "combine" step of merge sort. It takes two sorted
     * subarrays arr[left...mid] and arr[mid+1...right] and merges them
     * into a single sorted subarray.</p>
     * 
     * @param arr the array containing the subarrays
     * @param left the starting index of the first subarray
     * @param mid the ending index of the first subarray
     * @param right the ending index of the second subarray
     */
    private void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];

        for (int i = 0; i < n1; i++) {
            leftArr[i] = arr[left + i];
        }
        for (int j = 0; j < n2; j++) {
            rightArr[j] = arr[mid + 1 + j];
        }

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k++] = leftArr[i++];
            } else {
                arr[k++] = rightArr[j++];
            }
        }

        while (i < n1) {
            arr[k++] = leftArr[i++];
        }
        while (j < n2) {
            arr[k++] = rightArr[j++];
        }
    }

    /**
     * Sorts an array using the Quick Sort algorithm.
     * 
     * <p>Quick Sort is a highly efficient divide-and-conquer algorithm that:
     * <ol>
     *   <li>Picks a 'pivot' element</li>
     *   <li>Partitions array so elements < pivot are on left, > pivot on right</li>
     *   <li>Recursively sorts the left and right partitions</li>
     * </ol></p>
     * 
     * <p><b>Time Complexity:</b></p>
     * <ul>
     *   <li>Best: O(n log n) - balanced partitions</li>
     *   <li>Average: O(n log n)</li>
     *   <li>Worst: O(n²) - already sorted array with poor pivot selection</li>
     * </ul>
     * 
     * <p><b>Space Complexity:</b> O(log n) - recursion stack</p>
     * <p><b>Stability:</b> Not stable - may change relative order of equal elements</p>
     * 
     * <p><b>Advantages:</b></p>
     * <ul>
     *   <li>In-place sorting (low memory overhead)</li>
     *   <li>Cache-friendly (good locality of reference)</li>
     *   <li>Average case is very fast in practice</li>
     *   <li>Used in many standard libraries (e.g., Java's Arrays.sort for primitives)</li>
     * </ul>
     * 
     * <p><b>When to Use:</b> General purpose sorting, large datasets, when average
     * case performance is more important than worst case</p>
     * 
     * @param arr the array to be sorted (modified in-place)
     */
    public void quickSort(int[] arr) {
        if (arr.length < 2) {
            return;
        }
        quickSortRec(arr, 0, arr.length - 1);
    }

    /**
     * Recursive helper method for quick sort.
     * 
     * @param arr the array being sorted
     * @param low the starting index of the partition
     * @param high the ending index of the partition
     */
    private void quickSortRec(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSortRec(arr, low, pi - 1);
            quickSortRec(arr, pi + 1, high);
        }
    }

    /**
     * Partitions the array around a pivot element.
     * 
     * <p>This method uses the last element as pivot and rearranges the array
     * so that all elements smaller than pivot come before it, and all elements
     * greater come after it. This is the key operation in quick sort.</p>
     * 
     * <p><b>Lomuto Partition Scheme:</b></p>
     * <ol>
     *   <li>Choose last element as pivot</li>
     *   <li>Maintain index i for smaller elements</li>
     *   <li>Traverse array, swap elements smaller than pivot to left</li>
     *   <li>Place pivot in its final position</li>
     * </ol>
     * 
     * @param arr the array to partition
     * @param low the starting index
     * @param high the ending index (pivot position)
     * @return the final position of the pivot element
     */
    private int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }
}
