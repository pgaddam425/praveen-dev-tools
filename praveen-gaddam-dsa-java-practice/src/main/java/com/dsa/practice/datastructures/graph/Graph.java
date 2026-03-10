package com.dsa.practice.datastructures.graph;

import java.util.*;

/**
 * Graph implementation using adjacency list representation.
 * 
 * <p>A graph is a non-linear data structure consisting of vertices (nodes)
 * and edges that connect pairs of vertices. This implementation uses an
 * adjacency list for efficient storage and traversal.</p>
 * 
 * <p><b>Graph Representation:</b></p>
 * <pre>
 * Adjacency List for graph with 4 vertices:
 * 0 → [1, 2]
 * 1 → [2]
 * 2 → [0, 3]
 * 3 → [3]
 * 
 * Visual:
 *   0 → 1
 *   ↓   ↓
 *   2 → 3 ⟲
 * </pre>
 * 
 * <p><b>Key Operations:</b></p>
 * <ul>
 *   <li>Add Edge: O(1)</li>
 *   <li>BFS: O(V + E) where V=vertices, E=edges</li>
 *   <li>DFS: O(V + E)</li>
 *   <li>Cycle Detection: O(V + E)</li>
 * </ul>
 * 
 * <p><b>Applications:</b></p>
 * <ul>
 *   <li>Social networks (friends, followers)</li>
 *   <li>Maps and navigation (cities, roads)</li>
 *   <li>Web page linking</li>
 *   <li>Dependency resolution</li>
 *   <li>Network routing</li>
 * </ul>
 * 
 * @author Praveen Gaddam
 * @version 1.0
 */
public class Graph {

    private int vertices;
    private LinkedList<Integer>[] adjacencyList;

    /**
     * Constructs a graph with the specified number of vertices.
     * 
     * @param vertices the number of vertices in the graph
     */
    @SuppressWarnings("unchecked")
    public Graph(int vertices) {
        this.vertices = vertices;                    // Store vertex count
        adjacencyList = new LinkedList[vertices];    // Create array of lists
        for (int i = 0; i < vertices; i++) {
            adjacencyList[i] = new LinkedList<>();   // Initialize each list
        }
    }

    /**
     * Adds a directed edge from source to destination.
     * 
     * <p>Creates a one-way connection: source → destination</p>
     * 
     * <p><b>Time Complexity:</b> O(1)</p>
     * 
     * @param source the starting vertex
     * @param destination the ending vertex
     */
    public void addEdge(int source, int destination) {
        adjacencyList[source].add(destination);  // Add destination to source's list
    }

    /**
     * Adds an undirected edge between source and destination.
     * 
     * <p>Creates a two-way connection: source ↔ destination</p>
     * 
     * <p><b>Time Complexity:</b> O(1)</p>
     * 
     * @param source the first vertex
     * @param destination the second vertex
     */
    public void addEdgeUndirected(int source, int destination) {
        adjacencyList[source].add(destination);      // Add edge source → destination
        adjacencyList[destination].add(source);      // Add edge destination → source
    }

    /**
     * Performs Breadth-First Search (BFS) traversal starting from given vertex.
     * 
     * <p>BFS explores the graph level by level, visiting all neighbors before
     * moving to the next level. Uses a queue for traversal.</p>
     * 
     * <p><b>Algorithm:</b></p>
     * <ol>
     *   <li>Mark start vertex as visited and enqueue it</li>
     *   <li>While queue is not empty:
     *     <ul>
     *       <li>Dequeue a vertex and process it</li>
     *       <li>For each unvisited neighbor:
     *         <ul>
     *           <li>Mark as visited</li>
     *           <li>Enqueue it</li>
     *         </ul>
     *       </li>
     *     </ul>
     *   </li>
     * </ol>
     * 
     * <p><b>Applications:</b></p>
     * <ul>
     *   <li>Shortest path in unweighted graph</li>
     *   <li>Level-order traversal</li>
     *   <li>Finding connected components</li>
     *   <li>Web crawling</li>
     * </ul>
     * 
     * <p><b>Time Complexity:</b> O(V + E)</p>
     * <p><b>Space Complexity:</b> O(V) - queue and visited array</p>
     * 
     * @param startVertex the vertex to start traversal from
     */
    public void bfs(int startVertex) {
        boolean[] visited = new boolean[vertices];   // Track visited vertices
        Queue<Integer> queue = new LinkedList<>();   // Queue for BFS

        visited[startVertex] = true;                 // Mark start as visited
        queue.add(startVertex);                      // Enqueue start vertex

        while (!queue.isEmpty()) {
            int vertex = queue.poll();               // Dequeue vertex
            System.out.print(vertex + " ");          // Process vertex

            // Visit all unvisited neighbors
            for (int neighbor : adjacencyList[vertex]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;        // Mark as visited
                    queue.add(neighbor);             // Enqueue neighbor
                }
            }
        }
        System.out.println();
    }

    /**
     * Performs Depth-First Search (DFS) traversal starting from given vertex.
     * 
     * <p>DFS explores as far as possible along each branch before backtracking.
     * Uses recursion (implicit stack) for traversal.</p>
     * 
     * <p><b>Applications:</b></p>
     * <ul>
     *   <li>Topological sorting</li>
     *   <li>Cycle detection</li>
     *   <li>Path finding</li>
     *   <li>Maze solving</li>
     * </ul>
     * 
     * <p><b>Time Complexity:</b> O(V + E)</p>
     * <p><b>Space Complexity:</b> O(V) - recursion stack</p>
     * 
     * @param startVertex the vertex to start traversal from
     */
    public void dfs(int startVertex) {
        boolean[] visited = new boolean[vertices];   // Track visited vertices
        dfsUtil(startVertex, visited);               // Start recursive DFS
        System.out.println();
    }

    /**
     * Recursive helper method for DFS traversal.
     * 
     * <p><b>Algorithm:</b></p>
     * <ol>
     *   <li>Mark current vertex as visited</li>
     *   <li>Process current vertex</li>
     *   <li>For each unvisited neighbor, recursively call DFS</li>
     * </ol>
     * 
     * @param vertex the current vertex being visited
     * @param visited array tracking visited vertices
     */
    private void dfsUtil(int vertex, boolean[] visited) {
        visited[vertex] = true;                      // Mark as visited
        System.out.print(vertex + " ");              // Process vertex

        // Recursively visit all unvisited neighbors
        for (int neighbor : adjacencyList[vertex]) {
            if (!visited[neighbor]) {
                dfsUtil(neighbor, visited);          // Recursive DFS call
            }
        }
    }

    /**
     * Detects if the directed graph contains a cycle.
     * 
     * <p>Uses DFS with a recursion stack to detect back edges, which
     * indicate cycles in directed graphs.</p>
     * 
     * <p><b>Algorithm:</b></p>
     * <ol>
     *   <li>Maintain two arrays: visited and recursion stack</li>
     *   <li>For each unvisited vertex, run DFS</li>
     *   <li>If we encounter a vertex in recursion stack, cycle exists</li>
     * </ol>
     * 
     * <p><b>Example with Cycle:</b></p>
     * <pre>
     * 0 → 1 → 2
     *     ↑   ↓
     *     └───3
     * 
     * Path: 0 → 1 → 2 → 3 → 1 (cycle detected!)
     * </pre>
     * 
     * <p><b>Time Complexity:</b> O(V + E)</p>
     * <p><b>Space Complexity:</b> O(V)</p>
     * 
     * @return true if cycle exists, false otherwise
     */
    public boolean hasCycle() {
        boolean[] visited = new boolean[vertices];    // Track visited vertices
        boolean[] recStack = new boolean[vertices];   // Track recursion stack

        // Check each vertex
        for (int i = 0; i < vertices; i++) {
            if (hasCycleUtil(i, visited, recStack)) {
                return true;                          // Cycle found
            }
        }
        return false;                                 // No cycle
    }

    /**
     * Recursive helper for cycle detection.
     * 
     * <p><b>Key Insight:</b> A cycle exists if we reach a vertex that's
     * currently in the recursion stack (back edge).</p>
     * 
     * @param vertex the current vertex
     * @param visited tracks all visited vertices
     * @param recStack tracks vertices in current recursion path
     * @return true if cycle detected, false otherwise
     */
    private boolean hasCycleUtil(int vertex, boolean[] visited, boolean[] recStack) {
        // If vertex is in recursion stack, we found a back edge (cycle)
        if (recStack[vertex]) {
            return true;
        }
        
        // If already visited and not in recursion stack, no cycle from here
        if (visited[vertex]) {
            return false;
        }

        visited[vertex] = true;                       // Mark as visited
        recStack[vertex] = true;                      // Add to recursion stack

        // Check all neighbors
        for (int neighbor : adjacencyList[vertex]) {
            if (hasCycleUtil(neighbor, visited, recStack)) {
                return true;                          // Cycle found in neighbor
            }
        }

        recStack[vertex] = false;                     // Remove from recursion stack
        return false;                                 // No cycle from this vertex
    }

    /**
     * Returns the number of vertices in the graph.
     * 
     * @return the vertex count
     */
    public int getVertices() {
        return vertices;
    }

    /**
     * Returns the adjacency list representation of the graph.
     * 
     * @return array of linked lists representing the graph
     */
    public LinkedList<Integer>[] getAdjacencyList() {
        return adjacencyList;
    }
}
