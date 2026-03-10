package com.dsa.practice.datastructures.stack;

/**
 * Array-based implementation of a Stack data structure.
 * 
 * <p>A stack is a linear data structure that follows the Last-In-First-Out (LIFO)
 * principle. The last element added to the stack will be the first one to be removed.
 * This implementation uses a fixed-size array for storage.</p>
 * 
 * <p><b>Key Operations:</b></p>
 * <ul>
 *   <li>Push - Add element to top - O(1)</li>
 *   <li>Pop - Remove element from top - O(1)</li>
 *   <li>Peek - View top element without removing - O(1)</li>
 * </ul>
 * 
 * <p><b>Applications:</b></p>
 * <ul>
 *   <li>Function call stack in programming languages</li>
 *   <li>Expression evaluation (infix, postfix, prefix)</li>
 *   <li>Backtracking algorithms (maze solving, DFS)</li>
 *   <li>Undo/Redo functionality in applications</li>
 *   <li>Browser history navigation</li>
 * </ul>
 * 
 * @author Praveen Gaddam
 * @version 1.0
 */
public class Stack {

    private int[] arr;
    private int top;
    private int capacity;

    /**
     * Constructs a new Stack with the specified capacity.
     * 
     * <p>Initializes the internal array and sets the top pointer to -1,
     * indicating an empty stack.</p>
     * 
     * @param size the maximum number of elements the stack can hold
     */
    public Stack(int size) {
        arr = new int[size];
        capacity = size;
        top = -1;
    }

    /**
     * Pushes an element onto the top of the stack.
     * 
     * <p>This operation adds a new element to the top of the stack by:
     * <ol>
     *   <li>Checking if stack is full</li>
     *   <li>Incrementing the top pointer</li>
     *   <li>Placing the element at the new top position</li>
     * </ol></p>
     * 
     * <p><b>Time Complexity:</b> O(1) - constant time operation</p>
     * <p><b>Space Complexity:</b> O(1)</p>
     * 
     * @param data the element to push onto the stack
     * @throws StackOverflowError if the stack is full
     * 
     * @example
     * <pre>
     * Stack stack = new Stack(5);
     * stack.push(10);
     * stack.push(20);
     * </pre>
     */
    public void push(int data) {
        if (isFull()) {
            throw new StackOverflowError("Stack is full");
        }
        arr[++top] = data;
    }

    /**
     * Removes and returns the element at the top of the stack.
     * 
     * <p>This operation removes the most recently added element (LIFO principle).
     * The top pointer is decremented after returning the element.</p>
     * 
     * <p><b>Time Complexity:</b> O(1)</p>
     * <p><b>Space Complexity:</b> O(1)</p>
     * 
     * @return the element at the top of the stack
     * @throws RuntimeException if the stack is empty
     * 
     * @example
     * <pre>
     * stack.push(10);
     * stack.push(20);
     * int value = stack.pop(); // returns 20
     * </pre>
     */
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return arr[top--];
    }

    /**
     * Returns the element at the top of the stack without removing it.
     * 
     * <p>This operation allows you to view the top element without modifying
     * the stack. Useful for checking the next element to be popped.</p>
     * 
     * <p><b>Time Complexity:</b> O(1)</p>
     * <p><b>Space Complexity:</b> O(1)</p>
     * 
     * @return the element at the top of the stack
     * @throws RuntimeException if the stack is empty
     * 
     * @example
     * <pre>
     * stack.push(10);
     * int top = stack.peek(); // returns 10, stack unchanged
     * </pre>
     */
    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return arr[top];
    }

    /**
     * Checks if the stack is empty.
     * 
     * <p>A stack is empty when the top pointer is -1, indicating no elements
     * have been added or all elements have been removed.</p>
     * 
     * <p><b>Time Complexity:</b> O(1)</p>
     * 
     * @return true if the stack contains no elements, false otherwise
     */
    public boolean isEmpty() {
        return top == -1;
    }

    /**
     * Checks if the stack is full.
     * 
     * <p>A stack is full when the top pointer equals capacity - 1, meaning
     * all available positions in the array are occupied.</p>
     * 
     * <p><b>Time Complexity:</b> O(1)</p>
     * 
     * @return true if the stack has reached its capacity, false otherwise
     */
    public boolean isFull() {
        return top == capacity - 1;
    }

    /**
     * Returns the number of elements currently in the stack.
     * 
     * <p>The size is calculated as (top + 1) since top is 0-indexed and
     * starts at -1 for an empty stack.</p>
     * 
     * <p><b>Time Complexity:</b> O(1)</p>
     * 
     * @return the number of elements in the stack
     */
    public int size() {
        return top + 1;
    }
}
