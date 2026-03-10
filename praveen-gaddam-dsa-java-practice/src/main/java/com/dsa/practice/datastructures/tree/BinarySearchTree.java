package com.dsa.practice.datastructures.tree;

/**
 * Binary Search Tree (BST) implementation.
 * 
 * <p>A Binary Search Tree is a binary tree with the following ordering property:
 * For each node, all values in the left subtree are less than the node's value,
 * and all values in the right subtree are greater than the node's value.</p>
 * 
 * <p><b>BST Property:</b></p>
 * <pre>
 *        50
 *       /  \
 *     30    70
 *    / \    / \
 *   20 40  60 80
 * 
 * For any node:
 * - Left subtree: all values < node value
 * - Right subtree: all values > node value
 * </pre>
 * 
 * <p><b>Key Operations:</b></p>
 * <ul>
 *   <li>Search: O(h) where h is height</li>
 *   <li>Insert: O(h)</li>
 *   <li>Delete: O(h)</li>
 *   <li>Inorder Traversal: Gives sorted order - O(n)</li>
 * </ul>
 * 
 * <p><b>Height:</b></p>
 * <ul>
 *   <li>Balanced tree: h = O(log n)</li>
 *   <li>Skewed tree: h = O(n)</li>
 * </ul>
 * 
 * <p><b>Applications:</b></p>
 * <ul>
 *   <li>Maintaining sorted data</li>
 *   <li>Database indexing</li>
 *   <li>Priority queues</li>
 *   <li>Symbol tables in compilers</li>
 * </ul>
 * 
 * @author Praveen Gaddam
 * @version 1.0
 */
public class BinarySearchTree {

    private Node root;

    /**
     * Node class represents a single element in the BST.
     * Each node contains data and references to left and right children.
     */
    private static class Node {
        int data;
        Node left;
        Node right;

        /**
         * Constructs a new node with the given data.
         * 
         * @param data the value to store in this node
         */
        Node(int data) {
            this.data = data;      // Store the value
            this.left = null;      // No left child initially
            this.right = null;     // No right child initially
        }
    }

    /**
     * Inserts a new value into the BST.
     * 
     * <p>The value is inserted at the appropriate position to maintain
     * the BST property. Duplicate values are ignored.</p>
     * 
     * <p><b>Time Complexity:</b> O(h) where h is height</p>
     * <p><b>Space Complexity:</b> O(h) - recursion stack</p>
     * 
     * @param data the value to insert
     */
    public void insert(int data) {
        root = insertRec(root, data);  // Start recursive insertion from root
    }

    /**
     * Recursive helper method to insert a value into the BST.
     * 
     * <p><b>Algorithm:</b></p>
     * <ol>
     *   <li>Base case: if current node is null, create new node here</li>
     *   <li>If data < current node's data, insert in left subtree</li>
     *   <li>If data > current node's data, insert in right subtree</li>
     *   <li>If data equals current node's data, ignore (no duplicates)</li>
     *   <li>Return the (possibly modified) node</li>
     * </ol>
     * 
     * <p><b>Example: Insert 25 into tree with root 50:</b></p>
     * <pre>
     *     50              50
     *    /  \            /  \
     *   30   70   →    30   70
     *                 /
     *                25
     * 
     * Path: 50 → 30 (25 < 50, go left) → insert as left child of 30
     * </pre>
     * 
     * @param root the root of current subtree
     * @param data the value to insert
     * @return the root of the modified subtree
     */
    private Node insertRec(Node root, int data) {
        // Base case: found the insertion point
        if (root == null) {
            return new Node(data);  // Create new node here
        }
        
        // Recursive case: navigate to correct position
        if (data < root.data) {
            // Insert in left subtree
            root.left = insertRec(root.left, data);
        } else if (data > root.data) {
            // Insert in right subtree
            root.right = insertRec(root.right, data);
        }
        // If data == root.data, do nothing (no duplicates)
        
        return root;  // Return unchanged root
    }

    /**
     * Searches for a value in the BST.
     * 
     * <p>Uses the BST property to efficiently search by eliminating
     * half the tree at each step.</p>
     * 
     * <p><b>Time Complexity:</b></p>
     * <ul>
     *   <li>Best/Average: O(log n) - balanced tree</li>
     *   <li>Worst: O(n) - skewed tree</li>
     * </ul>
     * 
     * <p><b>Space Complexity:</b> O(h) - recursion stack</p>
     * 
     * @param data the value to search for
     * @return true if value exists in tree, false otherwise
     */
    public boolean search(int data) {
        return searchRec(root, data);  // Start search from root
    }

    /**
     * Recursive helper method to search for a value.
     * 
     * <p><b>Algorithm:</b></p>
     * <ol>
     *   <li>Base case: if node is null, value not found</li>
     *   <li>If current node's data equals target, found!</li>
     *   <li>If target < current data, search left subtree</li>
     *   <li>If target > current data, search right subtree</li>
     * </ol>
     * 
     * <p><b>Example: Search for 40 in tree:</b></p>
     * <pre>
     *        50
     *       /  \
     *     30    70
     *    / \
     *   20 40
     * 
     * Path: 50 (40 < 50, go left) → 30 (40 > 30, go right) → 40 (found!)
     * </pre>
     * 
     * @param root the root of current subtree
     * @param data the value to search for
     * @return true if found, false otherwise
     */
    private boolean searchRec(Node root, int data) {
        // Base case: reached null, value not found
        if (root == null) {
            return false;
        }
        
        // Base case: found the value
        if (root.data == data) {
            return true;
        }
        
        // Recursive case: search appropriate subtree
        if (data < root.data) {
            return searchRec(root.left, data);   // Search left
        }
        return searchRec(root.right, data);      // Search right
    }

    /**
     * Performs inorder traversal of the BST.
     * 
     * <p>Inorder traversal visits nodes in sorted order (ascending).
     * Order: Left → Root → Right</p>
     * 
     * <p><b>Example:</b></p>
     * <pre>
     *     50
     *    /  \
     *   30   70
     *  / \   / \
     * 20 40 60 80
     * 
     * Inorder: 20 30 40 50 60 70 80 (sorted!)
     * </pre>
     * 
     * <p><b>Time Complexity:</b> O(n) - visits each node once</p>
     * <p><b>Space Complexity:</b> O(h) - recursion stack</p>
     */
    public void inorder() {
        inorderRec(root);          // Start traversal from root
        System.out.println();      // Print newline after traversal
    }

    /**
     * Recursive helper for inorder traversal.
     * 
     * <p>Visits nodes in order: Left subtree → Current node → Right subtree</p>
     * 
     * <p><b>Why Inorder Gives Sorted Output:</b></p>
     * <p>BST property ensures left < root < right. By visiting left first,
     * then root, then right, we process values in ascending order.</p>
     * 
     * @param root the root of current subtree
     */
    private void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);              // Visit left subtree
            System.out.print(root.data + " ");  // Process current node
            inorderRec(root.right);             // Visit right subtree
        }
    }

    /**
     * Performs preorder traversal of the BST.
     * 
     * <p>Preorder traversal visits root before its children.
     * Order: Root → Left → Right</p>
     * 
     * <p><b>Example:</b></p>
     * <pre>
     *     50
     *    /  \
     *   30   70
     *  / \   / \
     * 20 40 60 80
     * 
     * Preorder: 50 30 20 40 70 60 80
     * </pre>
     * 
     * <p><b>Use Cases:</b></p>
     * <ul>
     *   <li>Create a copy of the tree</li>
     *   <li>Get prefix expression</li>
     *   <li>Serialize tree structure</li>
     * </ul>
     * 
     * <p><b>Time Complexity:</b> O(n)</p>
     * <p><b>Space Complexity:</b> O(h)</p>
     */
    public void preorder() {
        preorderRec(root);
        System.out.println();
    }

    /**
     * Recursive helper for preorder traversal.
     * 
     * <p>Visits nodes in order: Current node → Left subtree → Right subtree</p>
     * 
     * @param root the root of current subtree
     */
    private void preorderRec(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");  // Process current node first
            preorderRec(root.left);             // Then visit left subtree
            preorderRec(root.right);            // Finally visit right subtree
        }
    }

    /**
     * Performs postorder traversal of the BST.
     * 
     * <p>Postorder traversal visits root after its children.
     * Order: Left → Right → Root</p>
     * 
     * <p><b>Example:</b></p>
     * <pre>
     *     50
     *    /  \
     *   30   70
     *  / \   / \
     * 20 40 60 80
     * 
     * Postorder: 20 40 30 60 80 70 50
     * </pre>
     * 
     * <p><b>Use Cases:</b></p>
     * <ul>
     *   <li>Delete tree (delete children before parent)</li>
     *   <li>Get postfix expression</li>
     *   <li>Calculate tree properties bottom-up</li>
     * </ul>
     * 
     * <p><b>Time Complexity:</b> O(n)</p>
     * <p><b>Space Complexity:</b> O(h)</p>
     */
    public void postorder() {
        postorderRec(root);
        System.out.println();
    }

    /**
     * Recursive helper for postorder traversal.
     * 
     * <p>Visits nodes in order: Left subtree → Right subtree → Current node</p>
     * 
     * @param root the root of current subtree
     */
    private void postorderRec(Node root) {
        if (root != null) {
            postorderRec(root.left);            // Visit left subtree first
            postorderRec(root.right);           // Then visit right subtree
            System.out.print(root.data + " ");  // Process current node last
        }
    }
}
