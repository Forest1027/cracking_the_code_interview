package com.interview.basic.algorithms.graph_traversal;

import com.interview.basic.data_structures.trees_tries_graphs.graph.AdjacencyMapGraph;
import com.interview.basic.data_structures.trees_tries_graphs.graph.Vertex;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class GraphTraversalTest {

    @Test
    public void testTopologicalSort() {
        AdjacencyMapGraph<Integer, String> graph = new AdjacencyMapGraph<>(true);
        Vertex<Integer> v0 = graph.insertVertex(0);
        Vertex<Integer> v1 = graph.insertVertex(1);
        Vertex<Integer> v2 = graph.insertVertex(2);
        Vertex<Integer> v3 = graph.insertVertex(3);
        Vertex<Integer> v4 = graph.insertVertex(4);
        Vertex<Integer> v5 = graph.insertVertex(5);
        graph.insertEdge(v5, v0, "");
        graph.insertEdge(v5, v2, "");
        graph.insertEdge(v4, v0, "");
        graph.insertEdge(v4, v1, "");
        graph.insertEdge(v2, v3, "");
        graph.insertEdge(v3, v1, "");
        LinkedList<Vertex<Integer>> result = GraphTraversal.topologicalSort(graph);
        System.out.println(result);
    }
}