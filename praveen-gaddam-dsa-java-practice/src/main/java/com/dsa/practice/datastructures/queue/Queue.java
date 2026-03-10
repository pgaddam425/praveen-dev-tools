package com.dsa.practice.datastructures.queue;

/**
 * Circular array-based implementation of a Queue data structure.
 * 
 * <p>A queue is a linear data structure that follows the First-In-First-Out (FIFO)
 * principle. Elements are added at the rear and removed from the front, like a
 * line of people waiting.</p>
 * 
 * <p><b>Circular Queue Design:</b></p>
 * <pre>
 * Array: [_, _, _, _, _]
 *         ↑           ↑
 *       front       rear
 * 
 * After wraparound:
 * Array: [3, 4, _, _, 2]
 *            ↑       ↑
 *          rear    front
 * </pre>
 * 
 * <p><b>Key Operations:</b></p>
 * <ul>
 *   <li>Enqueue - Add element at rear - O(1)</li>
 *   <li>Dequeue - Remove element from front - O(1)</li>
 *   <li>Peek - View front element - O(1)</li>
 * </ul>
 * 
 * <p><b>Why Circular Queue?</b></p>
 * <ul>
 *   <li>Efficient space utilization - no wasted space after dequeue</li>
 *   <li>Front and rear can wrap around to beginning</li>
 *   <li>Prevents need to shift elements</li>
 * </ul>
 * 
 * <p><b>Applications:</b></p>
 * <ul>
 *   <li>CPU scheduling (Round Robin)</li>
 *   <li>Breadth-First Search (BFS)</li>
 *   <li>Print queue management</li>
 *   <li>Handling requests in web servers</li>
 *   <li>Asynchronous data transfer (IO buffers)</li>
 * </ul>
 * 
 * @author Praveen Gaddam
 * @version 1.0
 */
public class Queue {

    private int[] arr;
    private int front;
    private int rear;
    private int capacity;
    private int count;

    /**
     * Constructs a new circular queue with the specified capacity.
     * 
     * <p>Initializes the queue with:</p>
     * <ul>
     *   <li>front = 0 (points to first element)</li>
     *   <li>rear = -1 (no elements yet)</li>
     *   <li>count = 0 (empty queue)</li>
     * </ul>
     * 
     * @param size the maximum number of elements the queue can hold
     */
    public Queue(int size) {
        arr = new int[size];        // Allocate array of given size
        capacity = size;            // Store maximum capacity
        front = 0;                  // Front starts at index 0
        rear = -1;                  // Rear at -1 (no elements yet)
        count = 0;                  // Queue is initially empty
    }

    /**
     * Adds an element to the rear of the queue.
     * 
     * <p>This operation uses modulo arithmetic to implement circular behavior.
     * When rear reaches the end of the array, it wraps around to the beginning.</p>
     * 
     * <p><b>Algorithm:</b></p>
     * <ol>
     *   <li>Check if queue is full</li>
     *   <li>Move rear forward (with wraparound using modulo)</li>
     *   <li>Place element at new rear position</li>
     *   <li>Increment count</li>
     * </ol>
     * 
     * <p><b>Circular Wraparound Example:</b></p>
     * <pre>
     * Capacity = 5, rear = 4
     * rear = (4 + 1) % 5 = 0  (wraps to beginning)
     * </pre>
     * 
     * <p><b>Time Complexity:</b> O(1) - constant time operation</p>
     * <p><b>Space Complexity:</b> O(1)</p>
     * 
     * @param data the element to add to the queue
     * @throws RuntimeException if the queue is full
     */
    public void enqueue(int data) {
        // Step 1: Check if queue is full
        if (isFull()) {
            throw new RuntimeException("Queue is full");
        }
        
        // Step 2: Move rear forward with circular wraparound
        rear = (rear + 1) % capacity;  // Modulo ensures wraparound
        
        // Step 3: Place element at rear
        arr[rear] = data;
        
        // Step 4: Increment count
        count++;
    }

    /**
     * Removes and returns the element at the front of the queue.
     * 
     * <p>This operation implements the FIFO principle - the first element
     * added is the first one removed. Front pointer moves forward with
     * circular wraparound.</p>
     * 
     * <p><b>Algorithm:</b></p>
     * <ol>
     *   <li>Check if queue is empty</li>
     *   <li>Retrieve element at front</li>
     *   <li>Move front forward (with wraparound)</li>
     *   <li>Decrement count</li>
     *   <li>Return the retrieved element</li>
     * </ol>
     * 
     * <p><b>Visual Example:</b></p>
     * <pre>
     * Before: front=0, rear=2, [10, 20, 30, _, _]
     * Dequeue returns 10
     * After:  front=1, rear=2, [_, 20, 30, _, _]
     * </pre>
     * 
     * <p><b>Time Complexity:</b> O(1)</p>
     * <p><b>Space Complexity:</b> O(1)</p>
     * 
     * @return the element at the front of the queue
     * @throws RuntimeException if the queue is empty
     */
    public int dequeue() {
        // Step 1: Check if queue is empty
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        
        // Step 2: Get element at front
        int data = arr[front];
        
        // Step 3: Move front forward with wraparound
        front = (front + 1) % capacity;  // Circular increment
        
        // Step 4: Decrement count
        count--;
        
        // Step 5: Return the element
        return data;
    }

    /**
     * Returns the element at the front without removing it.
     * 
     * <p>This operation allows you to view the next element that would be
     * dequeued without actually removing it from the queue.</p>
     * 
     * <p><b>Time Complexity:</b> O(1) - direct array access</p>
     * <p><b>Space Complexity:</b> O(1)</p>
     * 
     * @return the element at the front of the queue
     * @throws RuntimeException if the queue is empty
     */
    public int peek() {
        // Check if queue is empty
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        
        // Return front element without removing
        return arr[front];
    }

    /**
     * Checks if the queue is empty.
     * 
     * <p>A queue is empty when count equals 0, meaning no elements
     * have been added or all elements have been removed.</p>
     * 
     * <p><b>Time Complexity:</b> O(1)</p>
     * 
     * @return true if the queue contains no elements, false otherwise
     */
    public boolean isEmpty() {
        return count == 0;  // Empty when no elements
    }

    /**
     * Checks if the queue is full.
     * 
     * <p>A queue is full when count equals capacity, meaning all
     * available positions in the array are occupied.</p>
     * 
     * <p><b>Time Complexity:</b> O(1)</p>
     * 
     * @return true if the queue has reached its capacity, false otherwise
     */
    public boolean isFull() {
        return count == capacity;  // Full when count reaches capacity
    }

    /**
     * Returns the number of elements currently in the queue.
     * 
     * <p>This is tracked by the count variable which is updated
     * with each enqueue and dequeue operation.</p>
     * 
     * <p><b>Time Complexity:</b> O(1)</p>
     * 
     * @return the number of elements in the queue
     */
    public int size() {
        return count;  // Return current number of elements
    }
}
