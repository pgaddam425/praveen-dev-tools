# Data Structures and Algorithms - In-Depth Explanation

**Author:** Praveen Gaddam  
**Project:** Java DSA Practice  
**Last Updated:** March 2026

---

## Table of Contents

1. [Introduction to Data Structures](#introduction-to-data-structures)
2. [Arrays](#arrays)
3. [Linked Lists](#linked-lists)
4. [Stacks](#stacks)
5. [Queues](#queues)
6. [Trees](#trees)
7. [Heaps](#heaps)
8. [Graphs](#graphs)
9. [Hash Tables](#hash-tables)
10. [Sorting Algorithms](#sorting-algorithms)
11. [Searching Algorithms](#searching-algorithms)
12. [Recursion](#recursion)
13. [Dynamic Programming](#dynamic-programming)
14. [Graph Algorithms](#graph-algorithms)
15. [String Algorithms](#string-algorithms)
16. [Complexity Analysis](#complexity-analysis)

---

## Introduction to Data Structures

### What is a Data Structure?

A **data structure** is a specialized format for organizing, processing, retrieving, and storing data. It defines the relationship between data elements and the operations that can be performed on them. Choosing the right data structure is crucial for writing efficient algorithms.

### Why Study Data Structures?

1. **Efficiency**: Proper data structures enable faster data access and manipulation
2. **Organization**: They provide systematic ways to organize data
3. **Reusability**: Well-designed data structures can be reused across different applications
4. **Problem Solving**: Many complex problems become simpler with the right data structure
5. **Interview Preparation**: Core topic in technical interviews

### Classification of Data Structures

#### Linear Data Structures
- Elements are arranged sequentially
- Each element has exactly one predecessor and one successor (except first and last)
- Examples: Arrays, Linked Lists, Stacks, Queues

#### Non-Linear Data Structures
- Elements are arranged hierarchically or in a network
- Each element can have multiple predecessors and successors
- Examples: Trees, Graphs, Heaps

#### Static vs Dynamic
- **Static**: Fixed size (Arrays)
- **Dynamic**: Size can change during runtime (Linked Lists, Dynamic Arrays)

---

## Arrays

### Deep Dive into Arrays

An **array** is a collection of elements stored at contiguous memory locations. It's the simplest and most widely used data structure.

### Internal Memory Representation

```
Memory Address:  1000   1004   1008   1012   1016
Array Index:     [0]    [1]    [2]    [3]    [4]
Values:          10     20     30     40     50
```

For an integer array (4 bytes per int), if the base address is 1000:
- Element at index i is located at: `base_address + (i × size_of_element)`
- arr[3] is at: 1000 + (3 × 4) = 1012

### Why O(1) Random Access?

Arrays provide **constant-time access** because:
1. Elements are stored contiguously in memory
2. Address calculation is a simple arithmetic operation
3. No traversal needed - direct jump to any index

### Array Operations - Detailed Analysis

#### 1. Access (Read/Write)
```java
int value = arr[5];  // O(1)
arr[5] = 100;        // O(1)
```
- **Time**: O(1) - Direct address calculation
- **Why**: CPU can compute memory address instantly

#### 2. Search (Unsorted Array)
```java
for (int i = 0; i < n; i++) {
    if (arr[i] == target) return i;
}
```
- **Time**: O(n) - Must check each element
- **Best Case**: O(1) - Element is first
- **Worst Case**: O(n) - Element is last or not present
- **Average Case**: O(n/2) ≈ O(n)

#### 3. Insertion at End
```java
arr[size++] = newElement;  // If space available
```
- **Time**: O(1) - If capacity exists
- **Time**: O(n) - If array needs resizing (copy all elements)

#### 4. Insertion at Beginning
```java
// Shift all elements right
for (int i = size; i > 0; i--) {
    arr[i] = arr[i-1];
}
arr[0] = newElement;
```
- **Time**: O(n) - Must shift all n elements
- **Space**: O(1) - In-place operation

#### 5. Deletion
```java
// Delete at index k
for (int i = k; i < size-1; i++) {
    arr[i] = arr[i+1];
}
size--;
```
- **Time**: O(n) - Shift elements to fill gap
- **Deletion at end**: O(1)
- **Deletion at beginning**: O(n)

### Advantages of Arrays

1. **Fast Access**: O(1) random access by index
2. **Cache Friendly**: Contiguous memory improves cache performance
3. **Simple**: Easy to understand and implement
4. **Memory Efficient**: No extra memory for pointers/references

### Disadvantages of Arrays

1. **Fixed Size**: Cannot grow/shrink (in static arrays)
2. **Expensive Insertion/Deletion**: O(n) for shifting elements
3. **Wasted Space**: If array is not fully utilized
4. **Homogeneous**: Can only store same data type

### When to Use Arrays

✅ **Use Arrays When:**
- You know the size in advance
- You need fast random access
- Memory is limited (no pointer overhead)
- You're implementing other data structures (stacks, queues, heaps)

❌ **Avoid Arrays When:**
- Frequent insertions/deletions in middle
- Size changes frequently
- Need to maintain sorted order with insertions

---

## Linked Lists

### Deep Dive into Linked Lists

A **linked list** is a linear data structure where elements (nodes) are stored at non-contiguous memory locations. Each node contains data and a reference (pointer) to the next node.

### Memory Representation

```
Singly Linked List:
[Data|Next] -> [Data|Next] -> [Data|Next] -> null
  10   •        20   •        30   null

Doubly Linked List:
null <- [Prev|Data|Next] <-> [Prev|Data|Next] <-> [Prev|Data|Next] -> null
         null  10   •          •    20   •          •    30   null
```

### Node Structure

```java
class Node {
    int data;        // Stores the value
    Node next;       // Reference to next node
    
    // For doubly linked list
    Node prev;       // Reference to previous node
}
```

### Types of Linked Lists

#### 1. Singly Linked List
- Each node points to the next node
- Traversal only in forward direction
- Less memory per node (one pointer)

#### 2. Doubly Linked List
- Each node has two pointers: next and previous
- Bidirectional traversal
- More memory per node (two pointers)
- Easier deletion (no need to track previous node)

#### 3. Circular Linked List
- Last node points back to first node
- No null at the end
- Useful for round-robin scheduling

### Linked List Operations - Detailed Analysis

#### 1. Insertion at Beginning
```java
Node newNode = new Node(data);
newNode.next = head;
head = newNode;
```
- **Time**: O(1) - Just update pointers
- **Why**: No shifting needed, direct pointer manipulation
- **Space**: O(1) - One new node

#### 2. Insertion at End
```java
Node newNode = new Node(data);
if (head == null) {
    head = newNode;
    return;
}
Node current = head;
while (current.next != null) {
    current = current.next;
}
current.next = newNode;
```
- **Time**: O(n) - Must traverse to end
- **Optimization**: Keep tail pointer → O(1)
- **Space**: O(1)

#### 3. Insertion at Position k
```java
Node newNode = new Node(data);
Node current = head;
for (int i = 0; i < k-1; i++) {
    current = current.next;
}
newNode.next = current.next;
current.next = newNode;
```
- **Time**: O(k) - Traverse to position k
- **Average**: O(n/2) ≈ O(n)

#### 4. Deletion
```java
// Delete node with value 'key'
if (head.data == key) {
    head = head.next;
    return;
}
Node current = head;
while (current.next != null && current.next.data != key) {
    current = current.next;
}
if (current.next != null) {
    current.next = current.next.next;
}
```
- **Time**: O(n) - May need to traverse entire list
- **Best Case**: O(1) - Delete head
- **Worst Case**: O(n) - Delete last or not found

#### 5. Search
```java
Node current = head;
while (current != null) {
    if (current.data == target) return current;
    current = current.next;
}
return null;
```
- **Time**: O(n) - Linear search only
- **No random access** like arrays

### Why Linked Lists?

#### Advantages
1. **Dynamic Size**: Grow/shrink at runtime
2. **Efficient Insertion/Deletion**: O(1) if position is known
3. **No Wasted Space**: Allocate memory as needed
4. **Easy Implementation**: Of stacks, queues, graphs

#### Disadvantages
1. **No Random Access**: Must traverse from head
2. **Extra Memory**: Pointers consume additional space
3. **Cache Unfriendly**: Non-contiguous memory
4. **Reverse Traversal**: Difficult in singly linked list

### Array vs Linked List

| Feature | Array | Linked List |
|---------|-------|-------------|
| Access | O(1) | O(n) |
| Search | O(n) unsorted, O(log n) sorted | O(n) |
| Insertion at beginning | O(n) | O(1) |
| Insertion at end | O(1) if space, O(n) if resize | O(n) or O(1) with tail |
| Deletion | O(n) | O(n) to find, O(1) to delete |
| Memory | Contiguous | Scattered |
| Size | Fixed (static) | Dynamic |
| Cache | Friendly | Unfriendly |

---

## Stacks

### Deep Dive into Stacks

A **stack** is a linear data structure that follows the **Last-In-First-Out (LIFO)** principle. Think of it like a stack of plates - you can only add or remove from the top.

### The LIFO Principle

```
Push(10) → Push(20) → Push(30) → Pop() returns 30

Stack State:
         [30] ← Top     After Pop:
         [20]                [20] ← Top
         [10]                [10]
```

### Real-World Analogies

1. **Stack of Plates**: Add/remove from top only
2. **Browser Back Button**: Last visited page is first to return to
3. **Undo Operation**: Last action is first to undo
4. **Function Calls**: Last called function returns first

### Stack Implementation Methods

#### 1. Array-Based Stack
```java
class Stack {
    int[] arr;
    int top;
    int capacity;
    
    // Fixed size, fast operations
    // O(1) push/pop
    // Limited by capacity
}
```

**Advantages:**
- Simple implementation
- Fast operations (no pointer manipulation)
- Cache friendly

**Disadvantages:**
- Fixed size
- Stack overflow if full

#### 2. Linked List-Based Stack
```java
class Stack {
    Node top;
    
    // Dynamic size
    // O(1) push/pop
    // No size limit (except memory)
}
```

**Advantages:**
- Dynamic size
- No overflow (until memory exhausted)

**Disadvantages:**
- Extra memory for pointers
- Slightly slower (pointer manipulation)

### Stack Operations - Deep Analysis

#### 1. Push (Add to Top)
```java
// Array implementation
void push(int data) {
    if (top == capacity - 1) {
        throw new StackOverflowError();
    }
    arr[++top] = data;
}
```
- **Time**: O(1) - Single array assignment
- **Space**: O(1) - No extra space
- **Why O(1)**: Direct index access, no loops

#### 2. Pop (Remove from Top)
```java
int pop() {
    if (top == -1) {
        throw new EmptyStackException();
    }
    return arr[top--];
}
```
- **Time**: O(1) - Single array access
- **Space**: O(1)
- **Returns**: The removed element

#### 3. Peek (View Top)
```java
int peek() {
    if (top == -1) {
        throw new EmptyStackException();
    }
    return arr[top];
}
```
- **Time**: O(1) - Just read, don't modify
- **Non-destructive**: Stack unchanged

### Applications of Stacks

#### 1. Function Call Stack (Call Stack)

Every programming language uses a stack for function calls:

```java
void main() {
    foo();  // Push foo's context
}

void foo() {
    bar();  // Push bar's context
}

void bar() {
    // Do work
}  // Pop bar, return to foo
   // Pop foo, return to main
```

**Stack Frames Include:**
- Local variables
- Parameters
- Return address
- Previous frame pointer

#### 2. Expression Evaluation

**Infix to Postfix Conversion:**
```
Infix:    (A + B) * C
Postfix:  A B + C *

Algorithm uses stack to track operators
```

**Postfix Evaluation:**
```
Expression: 5 3 + 2 *
Stack operations:
Push 5 → [5]
Push 3 → [5, 3]
+ → Pop 3, 5, push 8 → [8]
Push 2 → [8, 2]
* → Pop 2, 8, push 16 → [16]
Result: 16
```

#### 3. Backtracking Algorithms

**Maze Solving:**
```
1. Push starting position
2. While stack not empty:
   - Pop current position
   - If goal, done!
   - Push all valid neighbors
3. Backtrack when dead end
```

**N-Queens Problem:**
- Try placing queen
- Push state to stack
- If conflict, pop and try next position

#### 4. Depth-First Search (DFS)

```java
void dfs(Graph g, int start) {
    Stack<Integer> stack = new Stack<>();
    boolean[] visited = new boolean[g.vertices];
    
    stack.push(start);
    while (!stack.isEmpty()) {
        int vertex = stack.pop();
        if (!visited[vertex]) {
            visited[vertex] = true;
            // Process vertex
            for (int neighbor : g.getNeighbors(vertex)) {
                stack.push(neighbor);
            }
        }
    }
}
```

#### 5. Parentheses Matching

```java
boolean isValid(String s) {
    Stack<Character> stack = new Stack<>();
    for (char c : s.toCharArray()) {
        if (c == '(' || c == '{' || c == '[') {
            stack.push(c);
        } else {
            if (stack.isEmpty()) return false;
            char top = stack.pop();
            if (!matches(top, c)) return false;
        }
    }
    return stack.isEmpty();
}
```

**Examples:**
- `"(())"` → Valid
- `"({[]})"` → Valid
- `"(()"` → Invalid (unclosed)
- `"())"` → Invalid (extra closing)

---

## Queues

### Deep Dive into Queues

A **queue** is a linear data structure that follows the **First-In-First-Out (FIFO)** principle. Elements are added at the rear and removed from the front.

### The FIFO Principle

```
Enqueue(10) → Enqueue(20) → Enqueue(30) → Dequeue() returns 10

Queue State:
Front → [10] [20] [30] ← Rear

After Dequeue:
Front → [20] [30] ← Rear
```

### Real-World Analogies

1. **Line at Store**: First person in line is served first
2. **Print Queue**: First document sent prints first
3. **CPU Scheduling**: First process ready gets CPU first
4. **Breadth-First Search**: Process nodes level by level

### Types of Queues

#### 1. Simple Queue (Linear Queue)
- Standard FIFO
- Enqueue at rear, dequeue from front

#### 2. Circular Queue
- Last position connects to first
- Efficient space utilization
- No wasted space after dequeue

```
Circular Queue (size 5):
[3][4][ ][ ][2]
     ↑       ↑
   rear    front

After enqueue(5):
[3][4][5][ ][2]
        ↑   ↑
      rear front
```

#### 3. Priority Queue
- Elements have priorities
- Highest priority dequeued first
- Implemented using heaps

#### 4. Deque (Double-Ended Queue)
- Insert/delete from both ends
- Can act as stack or queue

### Queue Implementation Methods

#### 1. Array-Based Queue (Circular)
```java
class Queue {
    int[] arr;
    int front, rear, size, capacity;
    
    int enqueue(int data) {
        rear = (rear + 1) % capacity;
        arr[rear] = data;
        size++;
    }
}
```

**Why Circular?**
- Prevents wasted space
- After dequeue, front moves forward
- Rear can wrap around to beginning

#### 2. Linked List-Based Queue
```java
class Queue {
    Node front, rear;
    
    void enqueue(int data) {
        Node newNode = new Node(data);
        if (rear != null) {
            rear.next = newNode;
        }
        rear = newNode;
        if (front == null) {
            front = rear;
        }
    }
}
```

### Queue Operations - Deep Analysis

#### 1. Enqueue (Add to Rear)
```java
// Circular array implementation
void enqueue(int data) {
    if (isFull()) {
        throw new QueueFullException();
    }
    rear = (rear + 1) % capacity;
    arr[rear] = data;
    size++;
}
```
- **Time**: O(1) - Direct index calculation
- **Modulo Operation**: Wraps rear to beginning
- **Space**: O(1)

#### 2. Dequeue (Remove from Front)
```java
int dequeue() {
    if (isEmpty()) {
        throw new QueueEmptyException();
    }
    int data = arr[front];
    front = (front + 1) % capacity;
    size--;
    return data;
}
```
- **Time**: O(1) - Direct access
- **Returns**: Front element
- **Updates**: front pointer

#### 3. Peek (View Front)
```java
int peek() {
    if (isEmpty()) {
        throw new QueueEmptyException();
    }
    return arr[front];
}
```
- **Time**: O(1)
- **Non-destructive**: Queue unchanged

### Applications of Queues

#### 1. Breadth-First Search (BFS)

```java
void bfs(Graph g, int start) {
    Queue<Integer> queue = new LinkedList<>();
    boolean[] visited = new boolean[g.vertices];
    
    queue.add(start);
    visited[start] = true;
    
    while (!queue.isEmpty()) {
        int vertex = queue.remove();
        // Process vertex
        
        for (int neighbor : g.getNeighbors(vertex)) {
            if (!visited[neighbor]) {
                visited[neighbor] = true;
                queue.add(neighbor);
            }
        }
    }
}
```

**Why Queue for BFS?**
- Processes nodes level by level
- FIFO ensures closest nodes processed first
- Finds shortest path in unweighted graphs

#### 2. CPU Scheduling

**Round Robin Scheduling:**
```
Process Queue: [P1, P2, P3]
Time Quantum: 10ms

1. Dequeue P1, execute 10ms
2. If not done, enqueue P1
3. Dequeue P2, execute 10ms
4. Continue...
```

#### 3. Printer Queue
- Documents sent to printer form queue
- First document sent prints first
- Fair ordering

#### 4. Asynchronous Data Transfer
- IO Buffers
- Pipes between processes
- Message queues in systems

---

## Trees

### Deep Dive into Trees

A **tree** is a hierarchical data structure consisting of nodes connected by edges. It's a non-linear structure that represents hierarchical relationships.

### Tree Terminology

```
         1          ← Root
       /   \
      2     3       ← Internal Nodes
     / \   /
    4   5 6         ← Leaf Nodes

Height of tree: 2 (longest path from root to leaf)
Depth of node 5: 2 (distance from root)
```

**Key Terms:**
- **Root**: Topmost node (no parent)
- **Parent**: Node with children
- **Child**: Node with a parent
- **Leaf**: Node with no children
- **Internal Node**: Node with at least one child
- **Siblings**: Nodes with same parent
- **Ancestor**: Node on path from root to current node
- **Descendant**: Node in subtree of current node
- **Height**: Longest path from node to leaf
- **Depth**: Distance from root to node
- **Level**: Depth + 1

### Binary Trees

A **binary tree** is a tree where each node has at most two children (left and right).

#### Types of Binary Trees

**1. Full Binary Tree**
```
       1
      / \
     2   3
    / \
   4   5
```
- Every node has 0 or 2 children
- No node has exactly 1 child

**2. Complete Binary Tree**
```
       1
      / \
     2   3
    / \  /
   4  5 6
```
- All levels filled except possibly last
- Last level filled from left to right
- Used in heaps

**3. Perfect Binary Tree**
```
       1
      / \
     2   3
    / \ / \
   4  5 6  7
```
- All internal nodes have 2 children
- All leaves at same level
- Total nodes: 2^h - 1 (h = height)

**4. Balanced Binary Tree**
- Height difference between left and right subtrees ≤ 1
- Examples: AVL trees, Red-Black trees
- Ensures O(log n) operations

### Binary Search Tree (BST)

A **BST** is a binary tree with ordering property:
- Left subtree contains only nodes with values < parent
- Right subtree contains only nodes with values > parent
- Both subtrees are also BSTs

```
       50
      /  \
    30    70
   / \    / \
  20 40  60 80

Property: 20 < 30 < 40 < 50 < 60 < 70 < 80
```

### BST Operations - Deep Analysis

#### 1. Search
```java
Node search(Node root, int key) {
    if (root == null || root.data == key) {
        return root;
    }
    if (key < root.data) {
        return search(root.left, key);
    }
    return search(root.right, key);
}
```
- **Time**: O(h) where h = height
- **Best Case**: O(log n) - balanced tree
- **Worst Case**: O(n) - skewed tree (like linked list)
- **Why**: Each comparison eliminates half the tree

#### 2. Insertion
```java
Node insert(Node root, int key) {
    if (root == null) {
        return new Node(key);
    }
    if (key < root.data) {
        root.left = insert(root.left, key);
    } else if (key > root.data) {
        root.right = insert(root.right, key);
    }
    return root;
}
```
- **Time**: O(h) - traverse to leaf
- **Space**: O(h) - recursion stack
- **Always inserts at leaf**

#### 3. Deletion (Complex!)

**Three Cases:**

**Case 1: Node has no children (Leaf)**
```
Delete 20:
    50              50
   /  \            /  \
  30   70   →    30   70
 /                \
20                40
```
- Simply remove the node

**Case 2: Node has one child**
```
Delete 30:
    50              50
   /  \            /  \
  30   70   →    40   70
   \
   40
```
- Replace node with its child

**Case 3: Node has two children**
```
Delete 50:
    50              60
   /  \            /  \
  30   70   →    30   70
      / \             \
     60 80            80
```
- Find inorder successor (smallest in right subtree)
- Replace node's value with successor's value
- Delete successor

### Tree Traversals

#### 1. Inorder (Left-Root-Right)
```java
void inorder(Node root) {
    if (root != null) {
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
}
```
- **BST Property**: Prints nodes in sorted order
- **Time**: O(n) - visits each node once
- **Space**: O(h) - recursion stack

**Example:**
```
    4
   / \
  2   6
 / \ / \
1  3 5  7

Inorder: 1 2 3 4 5 6 7 (sorted!)
```

#### 2. Preorder (Root-Left-Right)
```java
void preorder(Node root) {
    if (root != null) {
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }
}
```
- **Use**: Create copy of tree, prefix expressions
- **Example**: 4 2 1 3 6 5 7

#### 3. Postorder (Left-Right-Root)
```java
void postorder(Node root) {
    if (root != null) {
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + " ");
    }
}
```
- **Use**: Delete tree, postfix expressions
- **Example**: 1 3 2 5 7 6 4

#### 4. Level Order (BFS)
```java
void levelOrder(Node root) {
    Queue<Node> queue = new LinkedList<>();
    queue.add(root);
    while (!queue.isEmpty()) {
        Node node = queue.remove();
        System.out.print(node.data + " ");
        if (node.left != null) queue.add(node.left);
        if (node.right != null) queue.add(node.right);
    }
}
```
- **Uses Queue**: FIFO for level-by-level
- **Example**: 4 2 6 1 3 5 7
- **Time**: O(n), **Space**: O(w) where w = max width

### Applications of Trees

1. **File Systems**: Directory structure
2. **DOM**: HTML document structure
3. **Databases**: B-trees for indexing
4. **Compilers**: Syntax trees
5. **Routing**: Decision trees
6. **AI**: Game trees (chess, tic-tac-toe)

---

## Heaps

### Deep Dive into Heaps

A **heap** is a complete binary tree that satisfies the **heap property**. It's typically implemented using an array for efficiency.

### Heap Property

**Min Heap:**
- Parent ≤ both children
- Smallest element at root

```
       10
      /  \
    20    30
   / \    /
  40 50  60

Array: [10, 20, 30, 40, 50, 60]
```

**Max Heap:**
- Parent ≥ both children
- Largest element at root

```
       60
      /  \
    50    30
   / \    /
  40 20  10

Array: [60, 50, 30, 40, 20, 10]
```

### Array Representation

For node at index `i`:
- **Left child**: `2*i + 1`
- **Right child**: `2*i + 2`
- **Parent**: `(i-1) / 2`

```
Index:  0   1   2   3   4   5
Array: [10, 20, 30, 40, 50, 60]

Tree:
       10 (0)
      /      \
   20 (1)    30 (2)
   /   \      /
40(3) 50(4) 60(5)
```

**Why Array?**
- No pointers needed
- Cache friendly
- Easy parent/child calculation
- Space efficient

### Heap Operations - Deep Analysis

#### 1. Insert (Bubble Up)
```java
void insert(int value) {
    // Add at end
    heap[size] = value;
    int current = size;
    size++;
    
    // Bubble up
    while (current > 0) {
        int parent = (current - 1) / 2;
        if (heap[current] < heap[parent]) {
            swap(current, parent);
            current = parent;
        } else {
            break;
        }
    }
}
```
- **Time**: O(log n) - height of tree
- **Process**: Add at end, bubble up to maintain heap property
- **Worst Case**: New element becomes root

**Example (Min Heap):**
```
Insert 5 into [10, 20, 30, 40]:

Step 1: Add at end
[10, 20, 30, 40, 5]
       10
      /  \
    20    30
   / \
  40  5

Step 2: Compare with parent (20)
5 < 20, swap
[10, 5, 30, 40, 20]
       10
      /  \
     5    30
   / \
  40 20

Step 3: Compare with parent (10)
5 < 10, swap
[5, 10, 30, 40, 20]
       5
      /  \
    10    30
   / \
  40 20
```

#### 2. Extract Min/Max (Bubble Down)
```java
int extractMin() {
    int min = heap[0];
    heap[0] = heap[size - 1];
    size--;
    heapify(0);
    return min;
}

void heapify(int i) {
    int smallest = i;
    int left = 2 * i + 1;
    int right = 2 * i + 2;
    
    if (left < size && heap[left] < heap[smallest]) {
        smallest = left;
    }
    if (right < size && heap[right] < heap[smallest]) {
        smallest = right;
    }
    
    if (smallest != i) {
        swap(i, smallest);
        heapify(smallest);
    }
}
```
- **Time**: O(log n)
- **Process**: Remove root, move last to root, bubble down

**Example:**
```
Extract from [5, 10, 30, 40, 20]:

Step 1: Remove root, move last
[20, 10, 30, 40]
       20
      /  \
    10    30
   /
  40

Step 2: Compare with children
Smallest child is 10, swap
[10, 20, 30, 40]
       10
      /  \
    20    30
   /
  40

Step 3: Compare 20 with 40
20 < 40, done!
```

#### 3. Peek
```java
int peek() {
    return heap[0];
}
```
- **Time**: O(1) - just return root
- **Min/Max always at root**

### Heapify - Building a Heap

**Build heap from array:**
```java
void buildHeap(int[] arr) {
    // Start from last non-leaf node
    for (int i = (arr.length / 2) - 1; i >= 0; i--) {
        heapify(arr, i);
    }
}
```
- **Time**: O(n) - surprisingly not O(n log n)!
- **Why**: Most nodes are near bottom, need few swaps

### Applications of Heaps

#### 1. Priority Queue
```java
class PriorityQueue {
    MinHeap heap;
    
    void add(int priority, Object data) {
        heap.insert(priority);
    }
    
    Object poll() {
        return heap.extractMin();
    }
}
```
- **Use**: Task scheduling, Dijkstra's algorithm
- **Time**: O(log n) insert/delete, O(1) peek

#### 2. Heap Sort
```java
void heapSort(int[] arr) {
    // Build max heap
    buildHeap(arr);
    
    // Extract max n times
    for (int i = arr.length - 1; i > 0; i--) {
        swap(arr, 0, i);
        heapify(arr, 0, i);
    }
}
```
- **Time**: O(n log n) - guaranteed
- **Space**: O(1) - in-place
- **Not stable**: Relative order may change

#### 3. K Largest/Smallest Elements
```java
int[] kLargest(int[] arr, int k) {
    MinHeap heap = new MinHeap(k);
    for (int num : arr) {
        if (heap.size() < k) {
            heap.insert(num);
        } else if (num > heap.peek()) {
            heap.extractMin();
            heap.insert(num);
        }
    }
    return heap.toArray();
}
```
- **Time**: O(n log k)
- **Space**: O(k)
- **Better than sorting**: O(n log n)

#### 4. Median in Stream
```java
class MedianFinder {
    MaxHeap smaller;  // Left half
    MinHeap larger;   // Right half
    
    void add(int num) {
        // Add to appropriate heap
        // Balance heaps
    }
    
    double findMedian() {
        // Return middle element(s)
    }
}
```
- **Time**: O(log n) add, O(1) find median
- **Two heaps**: Maintain balance

---

## Graphs

### Deep Dive into Graphs

A **graph** is a non-linear data structure consisting of vertices (nodes) and edges (connections). It's used to represent networks, relationships, and connections.

### Graph Terminology

```
Undirected Graph:
    1 --- 2
    |     |
    3 --- 4

Directed Graph (Digraph):
    1 → 2
    ↓   ↓
    3 → 4
```

**Key Terms:**
- **Vertex (Node)**: Entity in graph
- **Edge**: Connection between vertices
- **Adjacent**: Vertices connected by edge
- **Degree**: Number of edges connected to vertex
  - **Indegree**: Incoming edges (directed)
  - **Outdegree**: Outgoing edges (directed)
- **Path**: Sequence of vertices connected by edges
- **Cycle**: Path that starts and ends at same vertex
- **Connected Graph**: Path exists between any two vertices
- **Weighted Graph**: Edges have weights/costs
- **Sparse Graph**: Few edges (E << V²)
- **Dense Graph**: Many edges (E ≈ V²)

### Graph Representations

#### 1. Adjacency Matrix

```java
int[][] adjMatrix = new int[V][V];
// adjMatrix[i][j] = 1 if edge from i to j
```

**Example:**
```
Graph:     Matrix:
  0---1      0 1 2 3
  |   |    0[0 1 1 0]
  2---3    1[1 0 0 1]
           2[1 0 0 1]
           3[0 1 1 0]
```

**Pros:**
- O(1) edge lookup: `adjMatrix[u][v]`
- Simple implementation
- Good for dense graphs

**Cons:**
- O(V²) space - wasteful for sparse graphs
- O(V) to find all neighbors
- Adding vertex is expensive

#### 2. Adjacency List

```java
List<Integer>[] adjList = new ArrayList[V];
// adjList[i] contains neighbors of vertex i
```

**Example:**
```
Graph:     List:
  0---1    0: [1, 2]
  |   |    1: [0, 3]
  2---3    2: [0, 3]
           3: [1, 2]
```

**Pros:**
- O(V + E) space - efficient for sparse graphs
- O(degree) to find neighbors
- Easy to add vertices

**Cons:**
- O(degree) edge lookup
- Slightly more complex

**When to Use:**
- **Matrix**: Dense graphs, frequent edge queries
- **List**: Sparse graphs (most real-world graphs)

### Graph Traversal Algorithms

#### 1. Depth-First Search (DFS)

**Concept**: Go as deep as possible before backtracking

```java
void dfs(int start) {
    boolean[] visited = new boolean[V];
    dfsUtil(start, visited);
}

void dfsUtil(int v, boolean[] visited) {
    visited[v] = true;
    System.out.print(v + " ");
    
    for (int neighbor : adjList[v]) {
        if (!visited[neighbor]) {
            dfsUtil(neighbor, visited);
        }
    }
}
```

**Visualization:**
```
Graph:
    1---2
    |   |
    3---4

DFS from 1: 1 → 2 → 4 → 3
(Goes deep: 1→2→4, then backtracks to 3)
```

**Properties:**
- **Time**: O(V + E)
- **Space**: O(V) - recursion stack + visited array
- **Uses**: Cycle detection, topological sort, pathfinding
- **Implementation**: Recursion or stack

**Applications:**
1. **Cycle Detection**: If we visit an already visited node (not parent)
2. **Topological Sort**: Reverse of DFS finish times
3. **Connected Components**: Count DFS calls needed
4. **Maze Solving**: Explore all paths

#### 2. Breadth-First Search (BFS)

**Concept**: Explore level by level

```java
void bfs(int start) {
    boolean[] visited = new boolean[V];
    Queue<Integer> queue = new LinkedList<>();
    
    visited[start] = true;
    queue.add(start);
    
    while (!queue.isEmpty()) {
        int v = queue.poll();
        System.out.print(v + " ");
        
        for (int neighbor : adjList[v]) {
            if (!visited[neighbor]) {
                visited[neighbor] = true;
                queue.add(neighbor);
            }
        }
    }
}
```

**Visualization:**
```
Graph:
    1---2
    |   |
    3---4

BFS from 1:
Level 0: 1
Level 1: 2, 3
Level 2: 4

Order: 1 → 2 → 3 → 4
```

**Properties:**
- **Time**: O(V + E)
- **Space**: O(V) - queue + visited array
- **Uses**: Shortest path (unweighted), level-order traversal
- **Implementation**: Queue

**Applications:**
1. **Shortest Path**: In unweighted graphs
2. **Level Order**: Process nodes by distance from source
3. **Web Crawling**: Crawl nearby pages first
4. **Social Networks**: Find friends within k degrees

### Advanced Graph Algorithms

#### Dijkstra's Algorithm (Shortest Path)

**Problem**: Find shortest path from source to all vertices in weighted graph

```java
int[] dijkstra(int source) {
    int[] dist = new int[V];
    Arrays.fill(dist, Integer.MAX_VALUE);
    dist[source] = 0;
    
    PriorityQueue<Node> pq = new PriorityQueue<>();
    pq.add(new Node(source, 0));
    
    while (!pq.isEmpty()) {
        Node current = pq.poll();
        int u = current.vertex;
        
        for (Edge edge : adjList[u]) {
            int v = edge.dest;
            int weight = edge.weight;
            
            if (dist[u] + weight < dist[v]) {
                dist[v] = dist[u] + weight;
                pq.add(new Node(v, dist[v]));
            }
        }
    }
    return dist;
}
```

**How it Works:**
1. Initialize distances to infinity, source to 0
2. Use min-heap to get vertex with minimum distance
3. Relax all edges from current vertex
4. Repeat until all vertices processed

**Example:**
```
Graph:
    1 --2-- 2
    |       |
    4       1
    |       |
    3 --1-- 4

Dijkstra from 1:
dist[1] = 0
dist[2] = 2 (via 1→2)
dist[3] = 4 (via 1→3)
dist[4] = 3 (via 1→2→4)
```

**Complexity:**
- **Time**: O((V + E) log V) with min-heap
- **Space**: O(V)
- **Limitation**: Doesn't work with negative weights

#### Topological Sort

**Problem**: Linear ordering of vertices such that for every edge u→v, u comes before v

**Use Cases:**
- Task scheduling with dependencies
- Build systems (compile order)
- Course prerequisites

```java
void topologicalSort() {
    Stack<Integer> stack = new Stack<>();
    boolean[] visited = new boolean[V];
    
    for (int i = 0; i < V; i++) {
        if (!visited[i]) {
            topologicalSortUtil(i, visited, stack);
        }
    }
    
    while (!stack.isEmpty()) {
        System.out.print(stack.pop() + " ");
    }
}

void topologicalSortUtil(int v, boolean[] visited, Stack<Integer> stack) {
    visited[v] = true;
    
    for (int neighbor : adjList[v]) {
        if (!visited[neighbor]) {
            topologicalSortUtil(neighbor, visited, stack);
        }
    }
    
    stack.push(v);  // Push after visiting all descendants
}
```

**Example:**
```
Graph (DAG):
    5 → 2 → 3
    ↓       ↓
    0 → 1 → 4

Topological Order: 5, 0, 2, 1, 3, 4
(One valid ordering)
```

**Complexity:**
- **Time**: O(V + E)
- **Space**: O(V)
- **Note**: Only works on DAG (Directed Acyclic Graph)

---

## Hash Tables

### Deep Dive into Hash Tables

A **hash table** (hash map) is a data structure that implements an associative array, mapping keys to values using a hash function.

### How Hash Tables Work

```
Key → Hash Function → Index → Value

"apple" → hash("apple") → 5 → "fruit"
```

**Components:**
1. **Hash Function**: Converts key to array index
2. **Array**: Stores key-value pairs
3. **Collision Resolution**: Handles multiple keys mapping to same index

### Hash Functions

**Good Hash Function Properties:**
1. **Deterministic**: Same key always produces same hash
2. **Uniform Distribution**: Spreads keys evenly
3. **Fast**: O(1) computation
4. **Minimize Collisions**: Different keys rarely produce same hash

**Example Hash Functions:**

```java
// Simple hash for integers
int hash(int key) {
    return key % tableSize;
}

// Hash for strings
int hash(String key) {
    int hash = 0;
    for (char c : key.toCharArray()) {
        hash = (hash * 31 + c) % tableSize;
    }
    return hash;
}
```

**Why 31?**
- Prime number reduces collisions
- `31 * i = (i << 5) - i` - fast computation
- Used in Java's String.hashCode()

### Collision Resolution

#### 1. Chaining (Separate Chaining)

**Concept**: Each array slot contains a linked list

```
Index 0: null
Index 1: ["cat", 3] → ["dog", 5]
Index 2: ["bird", 7]
Index 3: null
Index 4: ["fish", 2]
```

**Implementation:**
```java
class HashTable {
    LinkedList<Entry>[] table;
    
    void put(String key, int value) {
        int index = hash(key);
        if (table[index] == null) {
            table[index] = new LinkedList<>();
        }
        
        // Update if key exists
        for (Entry entry : table[index]) {
            if (entry.key.equals(key)) {
                entry.value = value;
                return;
            }
        }
        
        // Add new entry
        table[index].add(new Entry(key, value));
    }
    
    Integer get(String key) {
        int index = hash(key);
        if (table[index] == null) return null;
        
        for (Entry entry : table[index]) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }
        return null;
    }
}
```

**Complexity:**
- **Average**: O(1) for put/get
- **Worst**: O(n) if all keys hash to same index
- **Load Factor**: α = n/m (n = entries, m = table size)
- **Keep α < 0.75** for good performance

**Pros:**
- Simple implementation
- Never fills up (can add unlimited entries)
- Performance degrades gradually

**Cons:**
- Extra memory for pointers
- Cache unfriendly (linked lists)

#### 2. Open Addressing

**Concept**: All entries stored in array, find next available slot on collision

**Linear Probing:**
```java
void put(String key, int value) {
    int index = hash(key);
    
    while (table[index] != null && !table[index].key.equals(key)) {
        index = (index + 1) % tableSize;  // Try next slot
    }
    
    table[index] = new Entry(key, value);
}
```

**Example:**
```
Insert "cat" (hash=1), "dog" (hash=1), "bird" (hash=1):

Index 0: null
Index 1: "cat"
Index 2: "dog"    (collision, probe to next)
Index 3: "bird"   (collision, probe to next)
Index 4: null
```

**Clustering Problem:**
- Consecutive occupied slots form clusters
- Increases probe length
- Degrades performance

**Quadratic Probing:**
```java
index = (hash + i²) % tableSize
// i = 0, 1, 4, 9, 16, ...
```
- Reduces clustering
- Better distribution

**Double Hashing:**
```java
index = (hash1(key) + i * hash2(key)) % tableSize
```
- Two hash functions
- Best open addressing method

**Pros:**
- Better cache performance
- No pointer overhead

**Cons:**
- Can fill up (need resizing)
- Deletion is complex
- Performance degrades sharply when full

### Resizing (Rehashing)

**When to Resize:**
- Load factor exceeds threshold (typically 0.75)
- Double the table size
- Rehash all existing entries

```java
void resize() {
    Entry[] oldTable = table;
    table = new Entry[oldTable.length * 2];
    size = 0;
    
    for (Entry entry : oldTable) {
        if (entry != null) {
            put(entry.key, entry.value);
        }
    }
}
```

**Complexity:**
- **Time**: O(n) to rehash all entries
- **Amortized**: O(1) per operation (infrequent resizing)

### Applications of Hash Tables

1. **Caching**: Store computed results
2. **Database Indexing**: Fast lookups
3. **Symbol Tables**: Compiler/interpreter variable storage
4. **Counting**: Frequency maps
5. **Deduplication**: Remove duplicates
6. **Anagrams**: Group anagrams together

---

## Sorting Algorithms

### Comparison-Based Sorting

All comparison-based sorts have **lower bound of Ω(n log n)** in worst case.

**Proof**: Decision tree has n! leaves (all permutations), height ≥ log(n!) ≈ n log n

### Non-Comparison Sorts

Can beat O(n log n) with special conditions:

#### Counting Sort
```java
void countingSort(int[] arr, int max) {
    int[] count = new int[max + 1];
    
    // Count occurrences
    for (int num : arr) {
        count[num]++;
    }
    
    // Reconstruct array
    int index = 0;
    for (int i = 0; i <= max; i++) {
        while (count[i]-- > 0) {
            arr[index++] = i;
        }
    }
}
```
- **Time**: O(n + k) where k = range
- **Space**: O(k)
- **When**: Small range of integers
- **Stable**: Yes

#### Radix Sort
```java
void radixSort(int[] arr) {
    int max = getMax(arr);
    
    for (int exp = 1; max / exp > 0; exp *= 10) {
        countingSortByDigit(arr, exp);
    }
}
```
- **Time**: O(d × n) where d = digits
- **Space**: O(n + k)
- **When**: Fixed-length keys (numbers, strings)
- **Stable**: Yes

---

## Complexity Analysis

### Time Complexity Classes

```
O(1) < O(log n) < O(n) < O(n log n) < O(n²) < O(2ⁿ) < O(n!)

Constant < Logarithmic < Linear < Linearithmic < Quadratic < Exponential < Factorial
```

### Growth Rates

For n = 1,000,000:

| Complexity | Operations | Example |
|------------|------------|---------|
| O(1) | 1 | Array access |
| O(log n) | ~20 | Binary search |
| O(n) | 1,000,000 | Linear search |
| O(n log n) | ~20,000,000 | Merge sort |
| O(n²) | 1,000,000,000,000 | Bubble sort |
| O(2ⁿ) | Astronomical | Fibonacci (naive) |

### Space Complexity

- **In-place**: O(1) extra space (bubble sort, selection sort)
- **Linear**: O(n) extra space (merge sort)
- **Logarithmic**: O(log n) extra space (quicksort recursion)

### Amortized Analysis

**Example: Dynamic Array**
```
Operations: push(1), push(2), push(3), push(4), push(5)
Costs:      1,       1,       2,       1,       4

Resize when full: copy all elements
Average cost: (1+1+2+1+4)/5 = 1.8 ≈ O(1) amortized
```

---

## Conclusion

This document provides in-depth explanations of fundamental data structures and algorithms. Each concept includes:

- **Theory**: How it works internally
- **Implementation**: Code with detailed comments
- **Complexity**: Time and space analysis
- **Applications**: Real-world use cases
- **Trade-offs**: When to use vs when to avoid

**Key Takeaways:**

1. **Choose the right data structure** for your problem
2. **Understand trade-offs** between time and space
3. **Know complexity** of all operations
4. **Practice implementation** to internalize concepts
5. **Study applications** to see real-world usage

**Next Steps:**

1. Implement each data structure from scratch
2. Solve problems using each algorithm
3. Analyze complexity of your solutions
4. Study advanced topics (AVL trees, B-trees, etc.)
5. Practice on coding platforms (LeetCode, HackerRank)

---

**Author:** Praveen Gaddam  
**Repository:** praveen-gaddam-dsa-java-practice  
**License:** MIT
