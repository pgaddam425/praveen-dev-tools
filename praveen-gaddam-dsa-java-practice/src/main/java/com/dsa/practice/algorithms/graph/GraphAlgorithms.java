package com.dsa.practice.algorithms.graph;

import java.util.*;

/**
 * Advanced graph algorithms for weighted and directed graphs.
 * 
 * <p>This class implements fundamental graph algorithms used in routing,
 * scheduling, and network optimization problems.</p>
 * 
 * <p><b>Algorithms Included:</b></p>
 * <ul>
 *   <li>Dijkstra's Algorithm - Shortest path from single source</li>
 *   <li>Topological Sort - Linear ordering of directed acyclic graph</li>
 *   <li>Prim's Algorithm - Minimum Spanning Tree</li>
 *   <li>Bipartite Check - Two-coloring validation</li>
 * </ul>
 * 
 * @author Praveen Gaddam
 * @version 1.0
 */
public class GraphAlgorithms {

    /**
     * Finds shortest paths from source to all vertices using Dijkstra's algorithm.
     * 
     * <p><b>Time Complexity:</b> O(V²) with adjacency matrix</p>
     * <p><b>Space Complexity:</b> O(V)</p>
     * 
     * @param graph adjacency matrix representation (0 means no edge)
     * @param source the starting vertex
     * @return array of shortest distances from source
     */
    public int[] dijkstra(int[][] graph, int source) {
        int vertices = graph.length;
        int[] distance = new int[vertices];
        boolean[] visited = new boolean[vertices];

        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[source] = 0;

        for (int count = 0; count < vertices - 1; count++) {
            int u = minDistance(distance, visited);
            visited[u] = true;

            for (int v = 0; v < vertices; v++) {
                if (!visited[v] && graph[u][v] != 0 && 
                    distance[u] != Integer.MAX_VALUE &&
                    distance[u] + graph[u][v] < distance[v]) {
                    distance[v] = distance[u] + graph[u][v];
                }
            }
        }
        return distance;
    }

    /**
     * Helper method to find vertex with minimum distance.
     * 
     * @param distance array of current distances
     * @param visited array of visited vertices
     * @return index of vertex with minimum distance
     */
    private int minDistance(int[] distance, boolean[] visited) {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;

        for (int v = 0; v < distance.length; v++) {
            if (!visited[v] && distance[v] <= min) {
                min = distance[v];
                minIndex = v;
            }
        }
        return minIndex;
    }

    /**
     * Performs topological sort on a directed acyclic graph (DAG).
     * 
     * <p>Uses Kahn's algorithm with in-degree tracking.</p>
     * 
     * <p><b>Time Complexity:</b> O(V + E)</p>
     * <p><b>Space Complexity:</b> O(V)</p>
     * 
     * @param vertices number of vertices
     * @param adjacencyList graph representation
     * @return topologically sorted list, or empty if cycle exists
     */
    public List<Integer> topologicalSort(int vertices, List<List<Integer>> adjacencyList) {
        int[] inDegree = new int[vertices];
        for (int i = 0; i < vertices; i++) {
            for (int neighbor : adjacencyList.get(i)) {
                inDegree[neighbor]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < vertices; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            result.add(vertex);

            for (int neighbor : adjacencyList.get(vertex)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }

        return result.size() == vertices ? result : new ArrayList<>();
    }

    /**
     * Finds Minimum Spanning Tree weight using Prim's algorithm.
     * 
     * <p><b>Time Complexity:</b> O(V²)</p>
     * <p><b>Space Complexity:</b> O(V)</p>
     * 
     * @param graph adjacency matrix with edge weights
     * @return total weight of MST
     */
    public int primMST(int[][] graph) {
        int vertices = graph.length;
        int[] parent = new int[vertices];
        int[] key = new int[vertices];
        boolean[] mstSet = new boolean[vertices];

        Arrays.fill(key, Integer.MAX_VALUE);
        key[0] = 0;
        parent[0] = -1;

        for (int count = 0; count < vertices - 1; count++) {
            int u = minKey(key, mstSet);
            mstSet[u] = true;

            for (int v = 0; v < vertices; v++) {
                if (graph[u][v] != 0 && !mstSet[v] && graph[u][v] < key[v]) {
                    parent[v] = u;
                    key[v] = graph[u][v];
                }
            }
        }

        int totalWeight = 0;
        for (int i = 1; i < vertices; i++) {
            totalWeight += graph[i][parent[i]];
        }
        return totalWeight;
    }

    /**
     * Helper method to find vertex with minimum key value.
     * 
     * @param key array of key values
     * @param mstSet array tracking vertices in MST
     * @return index of vertex with minimum key
     */
    private int minKey(int[] key, boolean[] mstSet) {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;

        for (int v = 0; v < key.length; v++) {
            if (!mstSet[v] && key[v] < min) {
                min = key[v];
                minIndex = v;
            }
        }
        return minIndex;
    }

    /**
     * Checks if a graph is bipartite (can be colored with 2 colors).
     * 
     * <p><b>Time Complexity:</b> O(V + E)</p>
     * <p><b>Space Complexity:</b> O(V)</p>
     * 
     * @param vertices number of vertices
     * @param adjacencyList graph representation
     * @return true if bipartite, false otherwise
     */
    public boolean isBipartite(int vertices, List<List<Integer>> adjacencyList) {
        int[] color = new int[vertices];
        Arrays.fill(color, -1);

        for (int i = 0; i < vertices; i++) {
            if (color[i] == -1) {
                if (!isBipartiteUtil(i, adjacencyList, color)) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Helper method for bipartite check using BFS and coloring.
     * 
     * @param vertex starting vertex
     * @param adjacencyList graph representation
     * @param color array tracking vertex colors
     * @return true if component is bipartite
     */
    private boolean isBipartiteUtil(int vertex, List<List<Integer>> adjacencyList, int[] color) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(vertex);
        color[vertex] = 0;

        while (!queue.isEmpty()) {
            int u = queue.poll();

            for (int v : adjacencyList.get(u)) {
                if (color[v] == -1) {
                    color[v] = 1 - color[u];
                    queue.add(v);
                } else if (color[v] == color[u]) {
                    return false;
                }
            }
        }
        return true;
    }
}
