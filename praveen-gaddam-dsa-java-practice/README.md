# Java Data Structures and Algorithms Practice

A comprehensive Maven-based Java project for learning, practicing, and mastering data structures and algorithms. This repository contains well-documented implementations with detailed explanations, test cases, and practical examples.

## 📋 Table of Contents

- [Project Structure](#project-structure)
- [Prerequisites](#prerequisites)
- [Getting Started](#getting-started)
- [Data Structures](#data-structures)
- [Algorithms](#algorithms)
- [Running Examples](#running-examples)
- [Testing](#testing)
- [Complexity Analysis](#complexity-analysis)

## 🏗️ Project Structure

```
java-dsa-practice/
├── src/
│   ├── main/java/com/dsa/practice/
│   │   ├── datastructures/
│   │   │   ├── arrays/          # Array operations
│   │   │   ├── linkedlist/      # Singly & Doubly linked lists
│   │   │   ├── stack/           # Stack implementation
│   │   │   ├── queue/           # Circular queue
│   │   │   ├── tree/            # Binary Search Tree
│   │   │   ├── heap/            # Min Heap
│   │   │   ├── graph/           # Graph with BFS/DFS
│   │   │   └── hashtable/       # Hash table with chaining
│   │   ├── algorithms/
│   │   │   ├── sorting/         # Sorting algorithms
│   │   │   ├── searching/       # Search algorithms
│   │   │   ├── recursion/       # Recursive solutions
│   │   │   ├── dynamicprogramming/  # DP problems
│   │   │   ├── graph/           # Graph algorithms
│   │   │   └── strings/         # String algorithms
│   │   └── examples/            # Demo classes
│   └── test/java/com/dsa/practice/  # JUnit test cases
├── pom.xml
└── README.md
```

## 📦 Prerequisites

- **Java**: 17 or higher
- **Maven**: 3.6 or higher
- **IDE**: IntelliJ IDEA, Eclipse, or VS Code (recommended)

## 🚀 Getting Started

### Clone and Build

```bash
cd /path/to/java-dsa-practice
mvn clean install
```

### Run Demo Applications

```bash
# Data Structures Demo
mvn exec:java -Dexec.mainClass="com.dsa.practice.examples.DataStructuresDemo"

# Algorithms Demo
mvn exec:java -Dexec.mainClass="com.dsa.practice.examples.AlgorithmsDemo"
```

### Run Tests

```bash
# Run all tests
mvn test

# Run specific test class
mvn test -Dtest=SortingAlgorithmsTest

# Run with coverage
mvn clean test jacoco:report
```

---

## 📊 Data Structures

### 1. Arrays

**File**: `ArrayOperations.java`

**Operations Implemented**:
- `findMax(int[] arr)` - Find maximum element
- `findMin(int[] arr)` - Find minimum element
- `reverseArray(int[] arr)` - Reverse array in-place
- `rotateLeft(int[] arr, int k)` - Rotate array left by k positions

**Time Complexity**: O(n) for all operations  
**Space Complexity**: O(1) for in-place, O(n) for rotation

**Use Cases**: Data manipulation, searching, sorting foundation

---

### 2. Linked Lists

#### Singly Linked List
**File**: `SinglyLinkedList.java`

**Operations**:
- `insertAtBeginning(int data)` - Insert at head - O(1)
- `insertAtEnd(int data)` - Insert at tail - O(n)
- `deleteNode(int data)` - Delete first occurrence - O(n)
- `search(int data)` - Search for element - O(n)
- `size()` - Get list size - O(n)

**Advantages**: Dynamic size, efficient insertion/deletion at beginning  
**Disadvantages**: No random access, extra memory for pointers

#### Doubly Linked List
**File**: `DoublyLinkedList.java`

**Additional Features**:
- Bidirectional traversal
- `displayForward()` and `displayBackward()`
- More efficient deletion (no need to track previous node)

**Use Cases**: Browser history, undo/redo functionality, LRU cache

---

### 3. Stack

**File**: `Stack.java`

**Implementation**: Array-based with fixed capacity

**Operations**:
- `push(int data)` - Add element - O(1)
- `pop()` - Remove top element - O(1)
- `peek()` - View top element - O(1)
- `isEmpty()` - Check if empty - O(1)
- `isFull()` - Check if full - O(1)

**Applications**:
- Expression evaluation (infix, postfix, prefix)
- Function call management (call stack)
- Backtracking algorithms
- Undo mechanisms in editors

**LIFO Principle**: Last In, First Out

---

### 4. Queue

**File**: `Queue.java`

**Implementation**: Circular array-based queue

**Operations**:
- `enqueue(int data)` - Add to rear - O(1)
- `dequeue()` - Remove from front - O(1)
- `peek()` - View front element - O(1)
- `isEmpty()` / `isFull()` - O(1)

**Applications**:
- Task scheduling
- Breadth-First Search (BFS)
- Print spooling
- Request handling in web servers

**FIFO Principle**: First In, First Out

---

### 5. Binary Search Tree (BST)

**File**: `BinarySearchTree.java`

**Operations**:
- `insert(int data)` - Insert element - O(log n) average, O(n) worst
- `search(int data)` - Search element - O(log n) average, O(n) worst
- `inorder()` - In-order traversal (sorted order) - O(n)
- `preorder()` - Pre-order traversal - O(n)
- `postorder()` - Post-order traversal - O(n)

**Properties**:
- Left subtree contains only nodes with keys < node's key
- Right subtree contains only nodes with keys > node's key
- Both subtrees are also BSTs

**Use Cases**: Databases, file systems, autocomplete systems

---

### 6. Min Heap

**File**: `MinHeap.java`

**Implementation**: Array-based binary heap

**Operations**:
- `insert(int value)` - Insert and maintain heap property - O(log n)
- `extractMin()` - Remove and return minimum - O(log n)
- `peek()` - View minimum - O(1)
- `heapify(int i)` - Restore heap property - O(log n)

**Heap Property**: Parent node ≤ child nodes (for min heap)

**Applications**:
- Priority queues
- Heap sort algorithm
- Dijkstra's shortest path
- Huffman coding

---

### 7. Graph

**File**: `Graph.java`

**Representation**: Adjacency List

**Operations**:
- `addEdge(int src, int dest)` - Add directed edge - O(1)
- `addEdgeUndirected(int src, int dest)` - Add undirected edge - O(1)
- `bfs(int start)` - Breadth-First Search - O(V + E)
- `dfs(int start)` - Depth-First Search - O(V + E)
- `hasCycle()` - Detect cycle in directed graph - O(V + E)

**Applications**:
- Social networks
- Maps and navigation
- Network routing
- Dependency resolution

---

### 8. Hash Table

**File**: `HashTable.java`

**Collision Resolution**: Chaining with linked lists

**Operations**:
- `put(String key, int value)` - Insert/Update - O(1) average
- `get(String key)` - Retrieve value - O(1) average
- `remove(String key)` - Delete entry - O(1) average
- `containsKey(String key)` - Check existence - O(1) average

**Applications**:
- Database indexing
- Caching
- Symbol tables in compilers
- Counting frequencies

---

## 🧮 Algorithms

### Sorting Algorithms

**File**: `SortingAlgorithms.java`

| Algorithm | Best | Average | Worst | Space | Stable |
|-----------|------|---------|-------|-------|--------|
| Bubble Sort | O(n) | O(n²) | O(n²) | O(1) | Yes |
| Selection Sort | O(n²) | O(n²) | O(n²) | O(1) | No |
| Insertion Sort | O(n) | O(n²) | O(n²) | O(1) | Yes |
| Merge Sort | O(n log n) | O(n log n) | O(n log n) | O(n) | Yes |
| Quick Sort | O(n log n) | O(n log n) | O(n²) | O(log n) | No |

**When to Use**:
- **Bubble/Insertion**: Small datasets, nearly sorted data
- **Merge Sort**: Need stable sort, linked lists
- **Quick Sort**: General purpose, average case performance
- **Selection Sort**: Memory writes are costly

---

### Searching Algorithms

**File**: `SearchingAlgorithms.java`

#### Linear Search
- **Time**: O(n)
- **Space**: O(1)
- **Use**: Unsorted data, small datasets

#### Binary Search
- **Time**: O(log n)
- **Space**: O(1) iterative, O(log n) recursive
- **Prerequisite**: Sorted array
- **Use**: Large sorted datasets

---

### Recursion

**File**: `RecursionExamples.java`

**Implementations**:
1. **Factorial** - Classic recursion example
2. **Fibonacci** - Exponential time without memoization
3. **Sum of Digits** - Number manipulation
4. **Power** - Exponentiation
5. **Reverse String** - String manipulation
6. **Palindrome Check** - Two-pointer recursion
7. **GCD** - Euclidean algorithm
8. **Permutations** - Backtracking
9. **Tower of Hanoi** - Classic puzzle

**Key Concepts**:
- Base case (termination condition)
- Recursive case (self-reference)
- Stack overflow risk
- Tail recursion optimization

---

### Dynamic Programming

**File**: `DynamicProgramming.java`

**Problems Solved**:

1. **Fibonacci DP** - O(n) vs O(2ⁿ) recursive
2. **Climb Stairs** - Count ways to reach top
3. **0/1 Knapsack** - Maximize value within weight limit
4. **Longest Common Subsequence (LCS)** - String similarity
5. **Coin Change** - Minimum coins for amount
6. **Longest Increasing Subsequence (LIS)** - Array subsequence
7. **Edit Distance** - String transformation cost

**DP Principles**:
- **Optimal Substructure**: Solution built from subproblems
- **Overlapping Subproblems**: Same subproblems solved multiple times
- **Memoization**: Top-down approach with caching
- **Tabulation**: Bottom-up approach with table

---

### Graph Algorithms

**File**: `GraphAlgorithms.java`

1. **Dijkstra's Algorithm** - Shortest path from source - O((V + E) log V)
2. **Topological Sort** - Linear ordering of vertices - O(V + E)
3. **Prim's MST** - Minimum spanning tree - O(V²)
4. **Bipartite Check** - Two-coloring validation - O(V + E)

**Applications**:
- GPS navigation (Dijkstra)
- Task scheduling (Topological Sort)
- Network design (MST)
- Graph coloring (Bipartite)

---

### String Algorithms

**File**: `StringAlgorithms.java`

1. **Anagram Check** - O(n log n) or O(n) with hash map
2. **Reverse Words** - String manipulation
3. **Longest Substring Without Repeating** - Sliding window - O(n)
4. **Valid Parentheses** - Stack-based validation - O(n)
5. **KMP Pattern Matching** - Efficient search - O(n + m)
6. **Longest Palindromic Substring** - Expand around center - O(n²)

---

## 🧪 Testing

All implementations include comprehensive JUnit 5 test cases:

- **90+ test cases** covering normal, edge, and error scenarios
- **Test files** mirror the source structure
- **Assertions** validate correctness and edge cases

```bash
# Run all tests with output
mvn test

# Run specific test
mvn test -Dtest=BinarySearchTreeTest#testInsert
```

---

## 📈 Complexity Analysis

### Big O Notation Summary

| Notation | Name | Example |
|----------|------|---------|
| O(1) | Constant | Array access, hash table lookup |
| O(log n) | Logarithmic | Binary search, balanced BST |
| O(n) | Linear | Linear search, array traversal |
| O(n log n) | Linearithmic | Merge sort, quick sort |
| O(n²) | Quadratic | Bubble sort, nested loops |
| O(2ⁿ) | Exponential | Recursive fibonacci |
| O(n!) | Factorial | Permutations |

### Space Complexity Considerations

- **In-place algorithms**: O(1) extra space
- **Recursive algorithms**: O(h) stack space (h = recursion depth)
- **DP algorithms**: O(n) or O(n²) for memoization tables

---

## 🎯 Learning Path

### Beginner
1. Arrays and basic operations
2. Linked lists (singly)
3. Stack and Queue
4. Linear and Binary Search
5. Bubble and Insertion Sort

### Intermediate
6. Binary Search Trees
7. Recursion fundamentals
8. Merge Sort and Quick Sort
9. Hash Tables
10. Graph BFS/DFS

### Advanced
11. Heaps and Priority Queues
12. Dynamic Programming
13. Graph algorithms (Dijkstra, MST)
14. String algorithms (KMP)
15. Advanced tree structures

---

## 📚 Resources

- **Books**: "Introduction to Algorithms" (CLRS), "Cracking the Coding Interview"
- **Online**: LeetCode, HackerRank, GeeksforGeeks
- **Visualization**: VisuAlgo.net, Algorithm Visualizer

---

## 🤝 Contributing

Feel free to:
- Add new data structures and algorithms
- Improve existing implementations
- Add more test cases
- Enhance documentation

---

## 📝 License

This project is for educational purposes. Feel free to use and modify as needed for learning.

---

**Happy Coding! 🚀**
