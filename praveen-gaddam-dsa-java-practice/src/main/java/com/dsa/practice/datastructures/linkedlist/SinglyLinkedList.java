package com.dsa.practice.datastructures.linkedlist;

/**
 * Singly Linked List implementation.
 * 
 * <p>A singly linked list is a linear data structure where each element (node)
 * contains data and a reference to the next node. Unlike arrays, linked lists
 * don't require contiguous memory and can grow/shrink dynamically.</p>
 * 
 * <p><b>Structure:</b></p>
 * <pre>
 * head → [data|next] → [data|next] → [data|next] → null
 * </pre>
 * 
 * <p><b>Key Characteristics:</b></p>
 * <ul>
 *   <li>Dynamic size - grows and shrinks at runtime</li>
 *   <li>No random access - must traverse from head</li>
 *   <li>Efficient insertion/deletion at beginning - O(1)</li>
 *   <li>Each node stores data and pointer to next node</li>
 * </ul>
 * 
 * <p><b>Advantages:</b></p>
 * <ul>
 *   <li>Dynamic memory allocation</li>
 *   <li>Easy insertion/deletion at beginning</li>
 *   <li>No wasted memory (unlike fixed arrays)</li>
 *   <li>Can implement stacks, queues, graphs</li>
 * </ul>
 * 
 * <p><b>Disadvantages:</b></p>
 * <ul>
 *   <li>No random access - O(n) to access element at index</li>
 *   <li>Extra memory for storing pointers</li>
 *   <li>Not cache friendly (scattered memory)</li>
 *   <li>Reverse traversal not possible</li>
 * </ul>
 * 
 * @author Praveen Gaddam
 * @version 1.0
 */
public class SinglyLinkedList {

    private Node head;

    /**
     * Node class represents a single element in the linked list.
     * 
     * <p>Each node contains:</p>
     * <ul>
     *   <li>data - the value stored in the node</li>
     *   <li>next - reference to the next node in the list</li>
 * </ul>
     */
    private static class Node {
        int data;
        Node next;

        /**
         * Constructs a new node with the given data.
         * 
         * @param data the value to store in this node
         */
        Node(int data) {
            this.data = data;      // Store the value
            this.next = null;      // Initially points to nothing
        }
    }

    /**
     * Inserts a new node at the beginning of the linked list.
     * 
     * <p>This is the most efficient insertion operation in a singly linked list
     * because we only need to update two pointers.</p>
     * 
     * <p><b>Algorithm:</b></p>
     * <ol>
     *   <li>Create a new node with the given data</li>
     *   <li>Point new node's next to current head</li>
     *   <li>Update head to point to new node</li>
     * </ol>
     * 
     * <p><b>Visual Example:</b></p>
     * <pre>
     * Before: head → [10] → [20] → null
     * Insert 5 at beginning:
     * After:  head → [5] → [10] → [20] → null
     * </pre>
     * 
     * <p><b>Time Complexity:</b> O(1) - constant time, no traversal needed</p>
     * <p><b>Space Complexity:</b> O(1) - only one new node created</p>
     * 
     * @param data the value to insert at the beginning
     */
    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);  // Step 1: Create new node
        newNode.next = head;            // Step 2: New node points to current head
        head = newNode;                 // Step 3: Head now points to new node
    }

    /**
     * Inserts a new node at the end of the linked list.
     * 
     * <p>This operation requires traversing the entire list to find the last node,
     * making it less efficient than insertion at the beginning.</p>
     * 
     * <p><b>Algorithm:</b></p>
     * <ol>
     *   <li>Create a new node with the given data</li>
     *   <li>If list is empty, make new node the head</li>
     *   <li>Otherwise, traverse to the last node</li>
     *   <li>Point last node's next to new node</li>
     * </ol>
     * 
     * <p><b>Visual Example:</b></p>
     * <pre>
     * Before: head → [10] → [20] → null
     * Insert 30 at end:
     * After:  head → [10] → [20] → [30] → null
     * </pre>
     * 
     * <p><b>Time Complexity:</b> O(n) - must traverse entire list</p>
     * <p><b>Space Complexity:</b> O(1)</p>
     * 
     * <p><b>Optimization:</b> Maintain a tail pointer for O(1) insertion at end</p>
     * 
     * @param data the value to insert at the end
     */
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);  // Step 1: Create new node
        
        // Step 2: Handle empty list case
        if (head == null) {
            head = newNode;             // New node becomes the head
            return;
        }
        
        // Step 3: Traverse to the last node
        Node current = head;
        while (current.next != null) {  // Loop until we find last node
            current = current.next;     // Move to next node
        }
        
        // Step 4: Link last node to new node
        current.next = newNode;         // Last node now points to new node
    }

    /**
     * Deletes the first occurrence of a node with the specified data.
     * 
     * <p>This method searches for the first node containing the given data
     * and removes it from the list by updating pointers.</p>
     * 
     * <p><b>Algorithm:</b></p>
     * <ol>
     *   <li>If list is empty, return (nothing to delete)</li>
     *   <li>If head contains the data, move head to next node</li>
     *   <li>Otherwise, traverse to find the node before target</li>
     *   <li>Update pointer to skip the target node</li>
     * </ol>
     * 
     * <p><b>Visual Example:</b></p>
     * <pre>
     * Before: head → [10] → [20] → [30] → null
     * Delete 20:
     * After:  head → [10] → [30] → null
     *                   ↓_________↑ (pointer updated to skip 20)
     * </pre>
     * 
     * <p><b>Time Complexity:</b> O(n) - may need to traverse entire list</p>
     * <p><b>Space Complexity:</b> O(1) - only pointer manipulation</p>
     * 
     * @param data the value to delete from the list
     */
    public void deleteNode(int data) {
        // Step 1: Handle empty list
        if (head == null) {
            return;                     // Nothing to delete
        }
        
        // Step 2: Handle deletion of head node
        if (head.data == data) {
            head = head.next;           // Move head to next node
            return;                     // Old head will be garbage collected
        }
        
        // Step 3: Find the node before the one to delete
        Node current = head;
        while (current.next != null && current.next.data != data) {
            current = current.next;     // Move to next node
        }
        
        // Step 4: Delete the node by updating pointer
        if (current.next != null) {
            current.next = current.next.next;  // Skip over the target node
        }
    }

    /**
     * Searches for a node with the specified data.
     * 
     * <p>This method performs a linear search through the linked list,
     * checking each node until the data is found or the end is reached.</p>
     * 
     * <p><b>Algorithm:</b></p>
     * <ol>
     *   <li>Start from head</li>
     *   <li>Check if current node contains the data</li>
     *   <li>If found, return true</li>
     *   <li>If not found, move to next node</li>
     *   <li>Repeat until end of list</li>
     * </ol>
     * 
     * <p><b>Time Complexity:</b></p>
     * <ul>
     *   <li>Best Case: O(1) - element is at head</li>
     *   <li>Average Case: O(n/2) ≈ O(n)</li>
     *   <li>Worst Case: O(n) - element is at end or not present</li>
     * </ul>
     * 
     * <p><b>Space Complexity:</b> O(1) - only uses one pointer</p>
     * 
     * @param data the value to search for
     * @return true if the data is found, false otherwise
     */
    public boolean search(int data) {
        Node current = head;            // Start from the beginning
        
        while (current != null) {       // Traverse until end of list
            if (current.data == data) { // Check if current node has the data
                return true;            // Found it!
            }
            current = current.next;     // Move to next node
        }
        
        return false;                   // Reached end, data not found
    }

    /**
     * Returns the number of nodes in the linked list.
     * 
     * <p>This method counts all nodes by traversing the entire list.
     * For better performance, consider maintaining a size variable that
     * updates with each insertion/deletion.</p>
     * 
     * <p><b>Algorithm:</b></p>
     * <ol>
     *   <li>Initialize counter to 0</li>
     *   <li>Start from head</li>
     *   <li>For each node, increment counter</li>
     *   <li>Move to next node</li>
     *   <li>Return final count</li>
     * </ol>
     * 
     * <p><b>Time Complexity:</b> O(n) - must visit every node</p>
     * <p><b>Space Complexity:</b> O(1) - only uses counter variable</p>
     * 
     * @return the number of nodes in the list
     */
    public int size() {
        int count = 0;                  // Initialize counter
        Node current = head;            // Start from head
        
        while (current != null) {       // Traverse entire list
            count++;                    // Increment for each node
            current = current.next;     // Move to next node
        }
        
        return count;                   // Return total count
    }

    /**
     * Displays all elements in the linked list.
     * 
     * <p>Prints the list in the format: data1 → data2 → data3 → null</p>
     * 
     * <p>This is useful for debugging and visualizing the list structure.</p>
     * 
     * <p><b>Time Complexity:</b> O(n) - visits each node once</p>
     * <p><b>Space Complexity:</b> O(1) - only uses one pointer</p>
     */
    public void display() {
        Node current = head;            // Start from head
        
        while (current != null) {       // Traverse entire list
            System.out.print(current.data + " -> ");  // Print current data
            current = current.next;     // Move to next node
        }
        
        System.out.println("null");     // End of list
    }
}
