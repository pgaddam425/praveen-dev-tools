package com.dsa.practice.examples;

import com.dsa.practice.datastructures.arrays.ArrayOperations;
import com.dsa.practice.datastructures.linkedlist.SinglyLinkedList;
import com.dsa.practice.datastructures.stack.Stack;
import com.dsa.practice.datastructures.queue.Queue;
import com.dsa.practice.datastructures.tree.BinarySearchTree;
import com.dsa.practice.datastructures.heap.MinHeap;
import com.dsa.practice.datastructures.graph.Graph;
import com.dsa.practice.datastructures.hashtable.HashTable;

/**
 * Demonstration of all data structure implementations.
 * 
 * <p>This class provides example usage of each data structure
 * with sample data and operations.</p>
 * 
 * @author Praveen Gaddam
 * @version 1.0
 */
public class DataStructuresDemo {

    /**
     * Main method to run all data structure demonstrations.
     * 
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        System.out.println("=== Data Structures Demo ===\n");

        arrayOperationsDemo();
        linkedListDemo();
        stackDemo();
        queueDemo();
        binarySearchTreeDemo();
        minHeapDemo();
        graphDemo();
        hashTableDemo();
    }

    private static void arrayOperationsDemo() {
        System.out.println("1. Array Operations:");
        ArrayOperations arrayOps = new ArrayOperations();
        int[] arr = {5, 2, 8, 1, 9};
        System.out.println("Array: [5, 2, 8, 1, 9]");
        System.out.println("Max: " + arrayOps.findMax(arr));
        System.out.println("Min: " + arrayOps.findMin(arr));
        arrayOps.reverseArray(arr);
        System.out.print("Reversed: ");
        for (int num : arr) System.out.print(num + " ");
        System.out.println("\n");
    }

    private static void linkedListDemo() {
        System.out.println("2. Singly Linked List:");
        SinglyLinkedList list = new SinglyLinkedList();
        list.insertAtEnd(10);
        list.insertAtEnd(20);
        list.insertAtEnd(30);
        System.out.print("List: ");
        list.display();
        System.out.println("Search 20: " + list.search(20));
        list.deleteNode(20);
        System.out.print("After deleting 20: ");
        list.display();
        System.out.println();
    }

    private static void stackDemo() {
        System.out.println("3. Stack:");
        Stack stack = new Stack(5);
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println("Pushed: 10, 20, 30");
        System.out.println("Peek: " + stack.peek());
        System.out.println("Pop: " + stack.pop());
        System.out.println("Size: " + stack.size());
        System.out.println();
    }

    private static void queueDemo() {
        System.out.println("4. Queue:");
        Queue queue = new Queue(5);
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        System.out.println("Enqueued: 10, 20, 30");
        System.out.println("Peek: " + queue.peek());
        System.out.println("Dequeue: " + queue.dequeue());
        System.out.println("Size: " + queue.size());
        System.out.println();
    }

    private static void binarySearchTreeDemo() {
        System.out.println("5. Binary Search Tree:");
        BinarySearchTree bst = new BinarySearchTree();
        int[] values = {50, 30, 70, 20, 40, 60, 80};
        System.out.print("Inserting: ");
        for (int val : values) {
            bst.insert(val);
            System.out.print(val + " ");
        }
        System.out.println();
        System.out.print("Inorder Traversal: ");
        bst.inorder();
        System.out.println("Search 40: " + bst.search(40));
        System.out.println();
    }

    private static void minHeapDemo() {
        System.out.println("6. Min Heap:");
        MinHeap heap = new MinHeap(10);
        int[] values = {20, 15, 30, 10, 5};
        System.out.print("Inserting: ");
        for (int val : values) {
            heap.insert(val);
            System.out.print(val + " ");
        }
        System.out.println();
        System.out.println("Extract Min: " + heap.extractMin());
        System.out.println("Peek: " + heap.peek());
        System.out.println();
    }

    private static void graphDemo() {
        System.out.println("7. Graph (BFS & DFS):");
        Graph graph = new Graph(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        System.out.println("Graph edges: 0->1, 0->2, 1->3, 2->4");
        System.out.print("BFS from vertex 0: ");
        graph.bfs(0);
        System.out.print("DFS from vertex 0: ");
        graph.dfs(0);
        System.out.println();
    }

    private static void hashTableDemo() {
        System.out.println("8. Hash Table:");
        HashTable hashTable = new HashTable(10);
        hashTable.put("apple", 100);
        hashTable.put("banana", 200);
        hashTable.put("orange", 300);
        System.out.println("Put: apple=100, banana=200, orange=300");
        System.out.println("Get apple: " + hashTable.get("apple"));
        System.out.println("Contains banana: " + hashTable.containsKey("banana"));
        hashTable.remove("banana");
        System.out.println("After removing banana, size: " + hashTable.size());
        System.out.println();
    }
}
