package com.dsa.practice.datastructures.heap;

/**
 * Min Heap implementation using an array.
 * 
 * <p>A min heap is a complete binary tree where each parent node is smaller
 * than or equal to its children. The minimum element is always at the root.</p>
 * 
 * <p><b>Heap Property:</b> For every node i: heap[i] ≤ heap[2i+1] and heap[i] ≤ heap[2i+2]</p>
 * 
 * <p><b>Array Representation:</b></p>
 * <pre>
 * Array: [10, 20, 30, 40, 50, 60]
 * 
 * Tree:       10
 *           /    \
 *         20      30
 *        /  \    /
 *       40  50  60
 * 
 * For node at index i:
 * - Parent: (i-1)/2
 * - Left child: 2i+1
 * - Right child: 2i+2
 * </pre>
 * 
 * <p><b>Key Operations:</b></p>
 * <ul>
 *   <li>Insert: O(log n) - add at end, bubble up</li>
 *   <li>Extract Min: O(log n) - remove root, bubble down</li>
 *   <li>Peek: O(1) - view root</li>
 * </ul>
 * 
 * <p><b>Applications:</b></p>
 * <ul>
 *   <li>Priority Queue implementation</li>
 *   <li>Heap Sort algorithm</li>
 *   <li>Finding k smallest/largest elements</li>
 *   <li>Dijkstra's shortest path algorithm</li>
 *   <li>Median maintenance in streaming data</li>
 * </ul>
 * 
 * @author Praveen Gaddam
 * @version 1.0
 */
public class MinHeap {

    private int[] heap;
    private int size;
    private int capacity;

    /**
     * Constructs a new min heap with the specified capacity.
     * 
     * @param capacity the maximum number of elements the heap can hold
     */
    public MinHeap(int capacity) {
        this.capacity = capacity;   // Maximum size
        this.size = 0;              // Currently empty
        this.heap = new int[capacity];  // Allocate array
    }

    /**
     * Returns the index of the parent node.
     * 
     * <p>For node at index i, parent is at (i-1)/2</p>
     * 
     * @param i the index of the child node
     * @return the index of the parent node
     */
    private int parent(int i) {
        return (i - 1) / 2;
    }

    /**
     * Returns the index of the left child node.
     * 
     * <p>For node at index i, left child is at 2i+1</p>
     * 
     * @param i the index of the parent node
     * @return the index of the left child
     */
    private int leftChild(int i) {
        return 2 * i + 1;
    }

    /**
     * Returns the index of the right child node.
     * 
     * <p>For node at index i, right child is at 2i+2</p>
     * 
     * @param i the index of the parent node
     * @return the index of the right child
     */
    private int rightChild(int i) {
        return 2 * i + 2;
    }

    /**
     * Swaps two elements in the heap array.
     * 
     * @param i the index of the first element
     * @param j the index of the second element
     */
    private void swap(int i, int j) {
        int temp = heap[i];     // Store first element
        heap[i] = heap[j];      // Move second to first position
        heap[j] = temp;         // Move first to second position
    }

    /**
     * Inserts a new value into the min heap.
     * 
     * <p>The value is added at the end of the array and then "bubbled up"
     * to maintain the heap property.</p>
     * 
     * <p><b>Algorithm (Bubble Up):</b></p>
     * <ol>
     *   <li>Add new element at the end (index = size)</li>
     *   <li>Compare with parent</li>
     *   <li>If smaller than parent, swap with parent</li>
     *   <li>Repeat until element is at correct position or becomes root</li>
     * </ol>
     * 
     * <p><b>Example: Insert 5 into [10, 20, 30, 40]</b></p>
     * <pre>
     * Step 1: Add at end
     * [10, 20, 30, 40, 5]
     *       10
     *      /  \
     *    20    30
     *   /  \
     *  40   5
     * 
     * Step 2: 5 < 20, swap
     * [10, 5, 30, 40, 20]
     *       10
     *      /  \
     *     5    30
     *   /  \
     *  40  20
     * 
     * Step 3: 5 < 10, swap
     * [5, 10, 30, 40, 20]
     *       5
     *      /  \
     *    10    30
     *   /  \
     *  40  20
     * </pre>
     * 
     * <p><b>Time Complexity:</b> O(log n) - height of tree</p>
     * <p><b>Space Complexity:</b> O(1)</p>
     * 
     * @param value the value to insert
     * @throws RuntimeException if heap is full
     */
    public void insert(int value) {
        // Check if heap is full
        if (size == capacity) {
            throw new RuntimeException("Heap is full");
        }
        
        // Step 1: Add at end
        heap[size] = value;
        int current = size;
        size++;

        // Step 2-4: Bubble up
        while (current > 0 && heap[current] < heap[parent(current)]) {
            swap(current, parent(current));  // Swap with parent
            current = parent(current);       // Move up
        }
    }

    /**
     * Removes and returns the minimum element (root) from the heap.
     * 
     * <p>The last element is moved to the root and then "bubbled down"
     * to restore the heap property.</p>
     * 
     * <p><b>Algorithm (Bubble Down):</b></p>
     * <ol>
     *   <li>Save the root value (minimum)</li>
     *   <li>Move last element to root</li>
     *   <li>Decrease size</li>
     *   <li>Heapify from root (bubble down)</li>
     *   <li>Return saved minimum value</li>
     * </ol>
     * 
     * <p><b>Example: Extract from [5, 10, 30, 40, 20]</b></p>
     * <pre>
     * Step 1: Save root (5), move last to root
     * [20, 10, 30, 40]
     *       20
     *      /  \
     *    10    30
     *   /
     *  40
     * 
     * Step 2: Heapify - 20 > 10, swap
     * [10, 20, 30, 40]
     *       10
     *      /  \
     *    20    30
     *   /
     *  40
     * 
     * Step 3: 20 < 40, done
     * Return 5
     * </pre>
     * 
     * <p><b>Time Complexity:</b> O(log n)</p>
     * <p><b>Space Complexity:</b> O(log n) - recursion stack for heapify</p>
     * 
     * @return the minimum element
     * @throws RuntimeException if heap is empty
     */
    public int extractMin() {
        // Check if heap is empty
        if (size == 0) {
            throw new RuntimeException("Heap is empty");
        }
        
        // Handle single element
        if (size == 1) {
            size--;
            return heap[0];
        }

        // Step 1: Save root
        int root = heap[0];
        
        // Step 2-3: Move last to root, decrease size
        heap[0] = heap[size - 1];
        size--;
        
        // Step 4: Restore heap property
        heapify(0);
        
        // Step 5: Return minimum
        return root;
    }

    /**
     * Restores the min heap property by bubbling down from index i.
     * 
     * <p>This method is called after removing the root or building a heap.
     * It compares the node with its children and swaps with the smaller child
     * if necessary, then recursively heapifies the affected subtree.</p>
     * 
     * <p><b>Algorithm:</b></p>
     * <ol>
     *   <li>Find the smallest among: current node, left child, right child</li>
     *   <li>If current is not smallest, swap with smallest child</li>
     *   <li>Recursively heapify the affected subtree</li>
     *   <li>Stop when current is smaller than both children or is a leaf</li>
     * </ol>
     * 
     * <p><b>Why Recursive?</b> After swapping, the subtree where we swapped
     * may violate the heap property, so we need to heapify it too.</p>
     * 
     * <p><b>Time Complexity:</b> O(log n) - height of tree</p>
     * <p><b>Space Complexity:</b> O(log n) - recursion depth</p>
     * 
     * @param i the index to start heapifying from
     */
    private void heapify(int i) {
        int left = leftChild(i);     // Get left child index
        int right = rightChild(i);   // Get right child index
        int smallest = i;            // Assume current is smallest

        // Check if left child is smaller
        if (left < size && heap[left] < heap[smallest]) {
            smallest = left;
        }
        
        // Check if right child is smaller
        if (right < size && heap[right] < heap[smallest]) {
            smallest = right;
        }
        
        // If current is not smallest, swap and continue
        if (smallest != i) {
            swap(i, smallest);       // Swap with smaller child
            heapify(smallest);       // Recursively heapify affected subtree
        }
    }

    /**
     * Returns the minimum element without removing it.
     * 
     * <p>In a min heap, the minimum is always at the root (index 0).</p>
     * 
     * <p><b>Time Complexity:</b> O(1) - direct array access</p>
     * <p><b>Space Complexity:</b> O(1)</p>
     * 
     * @return the minimum element
     * @throws RuntimeException if heap is empty
     */
    public int peek() {
        if (size == 0) {
            throw new RuntimeException("Heap is empty");
        }
        return heap[0];  // Root is always minimum
    }

    /**
     * Returns the number of elements currently in the heap.
     * 
     * <p><b>Time Complexity:</b> O(1)</p>
     * 
     * @return the number of elements
     */
    public int getSize() {
        return size;
    }

    /**
     * Checks if the heap is empty.
     * 
     * <p><b>Time Complexity:</b> O(1)</p>
     * 
     * @return true if heap contains no elements, false otherwise
     */
    public boolean isEmpty() {
        return size == 0;
    }
}
