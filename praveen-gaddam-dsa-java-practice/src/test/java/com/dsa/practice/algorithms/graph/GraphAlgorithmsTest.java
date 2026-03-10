package com.dsa.practice.algorithms.graph;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

class GraphAlgorithmsTest {

    private GraphAlgorithms graphAlgorithms;

    @BeforeEach
    void setUp() {
        graphAlgorithms = new GraphAlgorithms();
    }

    @Test
    void testDijkstra() {
        int[][] graph = {
            {0, 4, 0, 0, 0, 0, 0, 8, 0},
            {4, 0, 8, 0, 0, 0, 0, 11, 0},
            {0, 8, 0, 7, 0, 4, 0, 0, 2},
            {0, 0, 7, 0, 9, 14, 0, 0, 0},
            {0, 0, 0, 9, 0, 10, 0, 0, 0},
            {0, 0, 4, 14, 10, 0, 2, 0, 0},
            {0, 0, 0, 0, 0, 2, 0, 1, 6},
            {8, 11, 0, 0, 0, 0, 1, 0, 7},
            {0, 0, 2, 0, 0, 0, 6, 7, 0}
        };
        int[] distances = graphAlgorithms.dijkstra(graph, 0);
        assertEquals(0, distances[0]);
        assertEquals(4, distances[1]);
        assertEquals(12, distances[2]);
    }

    @Test
    void testTopologicalSort() {
        List<List<Integer>> adjacencyList = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        adjacencyList.get(5).add(2);
        adjacencyList.get(5).add(0);
        adjacencyList.get(4).add(0);
        adjacencyList.get(4).add(1);
        adjacencyList.get(2).add(3);
        adjacencyList.get(3).add(1);

        List<Integer> result = graphAlgorithms.topologicalSort(6, adjacencyList);
        assertEquals(6, result.size());
    }

    @Test
    void testPrimMST() {
        int[][] graph = {
            {0, 2, 0, 6, 0},
            {2, 0, 3, 8, 5},
            {0, 3, 0, 0, 7},
            {6, 8, 0, 0, 9},
            {0, 5, 7, 9, 0}
        };
        int mstWeight = graphAlgorithms.primMST(graph);
        assertEquals(16, mstWeight);
    }

    @Test
    void testIsBipartite() {
        List<List<Integer>> adjacencyList = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        adjacencyList.get(0).add(1);
        adjacencyList.get(0).add(3);
        adjacencyList.get(1).add(0);
        adjacencyList.get(1).add(2);
        adjacencyList.get(2).add(1);
        adjacencyList.get(2).add(3);
        adjacencyList.get(3).add(0);
        adjacencyList.get(3).add(2);

        assertTrue(graphAlgorithms.isBipartite(4, adjacencyList));
    }

    @Test
    void testIsNotBipartite() {
        List<List<Integer>> adjacencyList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        adjacencyList.get(0).add(1);
        adjacencyList.get(1).add(0);
        adjacencyList.get(1).add(2);
        adjacencyList.get(2).add(1);
        adjacencyList.get(2).add(0);
        adjacencyList.get(0).add(2);

        assertFalse(graphAlgorithms.isBipartite(3, adjacencyList));
    }
}
