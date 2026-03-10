package com.dsa.practice.datastructures.linkedlist;

/**
 * Doubly Linked List implementation.
 * 
 * <p>A doubly linked list is a linear data structure where each node contains
 * data and two references: one to the next node and one to the previous node.
 * This allows bidirectional traversal.</p>
 * 
 * <p><b>Structure:</b></p>
 * <pre>
 * null ← [prev|data|next] ↔ [prev|data|next] ↔ [prev|data|next] → null
 *         ↑                                           ↑
 *        head                                        tail
 * </pre>
 * 
 * <p><b>Advantages over Singly Linked List:</b></p>
 * <ul>
 *   <li>Bidirectional traversal - can move forward and backward</li>
 *   <li>Easier deletion - no need to track previous node</li>
 *   <li>Can insert before a given node efficiently</li>
 *   <li>Tail pointer enables O(1) insertion at end</li>
 * </ul>
 * 
 * <p><b>Disadvantages:</b></p>
 * <ul>
 *   <li>Extra memory for prev pointer (8 bytes per node on 64-bit)</li>
 *   <li>More complex pointer manipulation</li>
 *   <li>Slightly slower operations due to extra pointer updates</li>
 * </ul>
 * 
 * <p><b>Applications:</b></p>
 * <ul>
 *   <li>Browser forward/backward navigation</li>
 *   <li>Undo/Redo functionality</li>
 *   <li>Music player playlists</li>
 *   <li>LRU cache implementation</li>
 * </ul>
 * 
 * @author Praveen Gaddam
 * @version 1.0
 */
public class DoublyLinkedList {

    private Node head;
    private Node tail;

    /**
     * Node class for doubly linked list.
     * Contains data and references to both next and previous nodes.
     */
    private static class Node {
        int data;
        Node next;
        Node prev;

        /**
         * Constructs a new node with the given data.
         * 
         * @param data the value to store in this node
         */
        Node(int data) {
            this.data = data;      // Store the value
            this.next = null;      // No next node initially
            this.prev = null;      // No previous node initially
        }
    }

    /**
     * Inserts a new node at the beginning of the list.
     * 
     * <p>This operation is O(1) as it only updates a few pointers.</p>
     * 
     * <p><b>Algorithm:</b></p>
     * <ol>
     *   <li>Create new node</li>
     *   <li>If list is empty, set both head and tail to new node</li>
     *   <li>Otherwise:
     *     <ul>
     *       <li>Point new node's next to current head</li>
     *       <li>Point current head's prev to new node</li>
     *       <li>Update head to new node</li>
     *     </ul>
     *   </li>
     * </ol>
     * 
     * <p><b>Visual Example:</b></p>
     * <pre>
     * Before: null ← [10] ↔ [20] → null
     *                 ↑       ↑
     *                head   tail
     * 
     * Insert 5:
     * After:  null ← [5] ↔ [10] ↔ [20] → null
     *                ↑             ↑
     *               head          tail
     * </pre>
     * 
     * <p><b>Time Complexity:</b> O(1)</p>
     * <p><b>Space Complexity:</b> O(1)</p>
     * 
     * @param data the value to insert
     */
    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);  // Step 1: Create new node
        
        // Step 2: Handle empty list
        if (head == null) {
            head = tail = newNode;      // Both head and tail point to new node
            return;
        }
        
        // Step 3: Insert at beginning
        newNode.next = head;            // New node points to current head
        head.prev = newNode;            // Current head's prev points to new node
        head = newNode;                 // Update head to new node
    }

    /**
     * Inserts a new node at the end of the list.
     * 
     * <p>Thanks to the tail pointer, this is also O(1) unlike singly linked list.</p>
     * 
     * <p><b>Algorithm:</b></p>
     * <ol>
     *   <li>Create new node</li>
     *   <li>If list is empty, set both head and tail to new node</li>
     *   <li>Otherwise:
     *     <ul>
     *       <li>Point current tail's next to new node</li>
     *       <li>Point new node's prev to current tail</li>
     *       <li>Update tail to new node</li>
     *     </ul>
     *   </li>
     * </ol>
     * 
     * <p><b>Visual Example:</b></p>
     * <pre>
     * Before: null ← [10] ↔ [20] → null
     *                 ↑       ↑
     *                head   tail
     * 
     * Insert 30:
     * After:  null ← [10] ↔ [20] ↔ [30] → null
     *                 ↑             ↑
     *                head          tail
     * </pre>
     * 
     * <p><b>Time Complexity:</b> O(1) - thanks to tail pointer</p>
     * <p><b>Space Complexity:</b> O(1)</p>
     * 
     * @param data the value to insert
     */
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);  // Step 1: Create new node
        
        // Step 2: Handle empty list
        if (tail == null) {
            head = tail = newNode;      // Both head and tail point to new node
            return;
        }
        
        // Step 3: Insert at end
        tail.next = newNode;            // Current tail points to new node
        newNode.prev = tail;            // New node's prev points to current tail
        tail = newNode;                 // Update tail to new node
    }

    /**
     * Deletes the first occurrence of a node with the specified data.
     * 
     * <p>Deletion in doubly linked list is easier than singly linked list
     * because we have access to the previous node through the prev pointer.</p>
     * 
     * <p><b>Algorithm:</b></p>
     * <ol>
     *   <li>Find the node to delete</li>
     *   <li>Handle three cases:
     *     <ul>
     *       <li>Deleting head: update head and its prev pointer</li>
     *       <li>Deleting tail: update tail and its next pointer</li>
     *       <li>Deleting middle: update both neighbors' pointers</li>
     *     </ul>
     *   </li>
     * </ol>
     * 
     * <p><b>Visual Example (Delete 20):</b></p>
     * <pre>
     * Before: null ← [10] ↔ [20] ↔ [30] → null
     *                 ↑             ↑
     *                head          tail
     * 
     * After:  null ← [10] ↔ [30] → null
     *                 ↑       ↑
     *                head   tail
     *                  ↓_____↑ (pointers updated to skip 20)
     * </pre>
     * 
     * <p><b>Time Complexity:</b> O(n) - must search for node</p>
     * <p><b>Space Complexity:</b> O(1)</p>
     * 
     * @param data the value to delete
     */
    public void deleteNode(int data) {
        // Handle empty list
        if (head == null) {
            return;
        }

        // Find the node to delete
        Node current = head;
        while (current != null && current.data != data) {
            current = current.next;
        }

        // Node not found
        if (current == null) {
            return;
        }

        // Case 1: Deleting head
        if (current == head) {
            head = head.next;           // Move head to next node
            if (head != null) {
                head.prev = null;       // New head has no previous
            } else {
                tail = null;            // List is now empty
            }
            return;
        }

        // Case 2: Deleting tail
        if (current == tail) {
            tail = tail.prev;           // Move tail to previous node
            tail.next = null;           // New tail has no next
            return;
        }

        // Case 3: Deleting middle node
        current.prev.next = current.next;  // Previous node skips current
        current.next.prev = current.prev;  // Next node's prev skips current
    }

    /**
     * Searches for a node with the specified data.
     * 
     * <p>Performs linear search from head to tail.</p>
     * 
     * <p><b>Time Complexity:</b> O(n)</p>
     * <p><b>Space Complexity:</b> O(1)</p>
     * 
     * @param data the value to search for
     * @return true if found, false otherwise
     */
    public boolean search(int data) {
        Node current = head;            // Start from head
        while (current != null) {       // Traverse until end
            if (current.data == data) { // Check current node
                return true;            // Found!
            }
            current = current.next;     // Move to next node
        }
        return false;                   // Not found
    }

    /**
     * Returns the number of nodes in the list.
     * 
     * <p><b>Time Complexity:</b> O(n) - must traverse entire list</p>
     * <p><b>Space Complexity:</b> O(1)</p>
     * 
     * @return the number of nodes
     */
    public int size() {
        int count = 0;                  // Initialize counter
        Node current = head;            // Start from head
        while (current != null) {       // Traverse entire list
            count++;                    // Count each node
            current = current.next;     // Move to next
        }
        return count;                   // Return total
    }

    /**
     * Displays all elements from head to tail.
     * 
     * <p>Prints in format: data1 ↔ data2 ↔ data3 ↔ null</p>
     * 
     * <p><b>Time Complexity:</b> O(n)</p>
     * <p><b>Space Complexity:</b> O(1)</p>
     */
    public void displayForward() {
        Node current = head;            // Start from head
        while (current != null) {       // Traverse forward
            System.out.print(current.data + " <-> ");
            current = current.next;     // Move to next
        }
        System.out.println("null");     // End of list
    }

    /**
     * Displays all elements from tail to head (reverse order).
     * 
     * <p>This demonstrates the bidirectional traversal capability
     * of doubly linked lists. Not possible in singly linked list.</p>
     * 
     * <p>Prints in format: data3 ↔ data2 ↔ data1 ↔ null</p>
     * 
     * <p><b>Time Complexity:</b> O(n)</p>
     * <p><b>Space Complexity:</b> O(1)</p>
     */
    public void displayBackward() {
        Node current = tail;            // Start from tail
        while (current != null) {       // Traverse backward
            System.out.print(current.data + " <-> ");
            current = current.prev;     // Move to previous
        }
        System.out.println("null");     // End of list
    }
}
