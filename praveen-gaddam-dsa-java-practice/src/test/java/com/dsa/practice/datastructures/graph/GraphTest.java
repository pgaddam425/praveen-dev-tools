package com.dsa.practice.datastructures.graph;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GraphTest {

    private Graph graph;

    @BeforeEach
    void setUp() {
        graph = new Graph(5);
    }

    @Test
    void testAddEdge() {
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        assertEquals(5, graph.getVertices());
    }

    @Test
    void testAddEdgeUndirected() {
        graph.addEdgeUndirected(0, 1);
        graph.addEdgeUndirected(1, 2);
        assertNotNull(graph.getAdjacencyList());
    }

    @Test
    void testHasCycle() {
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        assertTrue(graph.hasCycle());
    }

    @Test
    void testNoCycle() {
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        assertFalse(graph.hasCycle());
    }

    @Test
    void testEmptyGraph() {
        assertFalse(graph.hasCycle());
    }
}
