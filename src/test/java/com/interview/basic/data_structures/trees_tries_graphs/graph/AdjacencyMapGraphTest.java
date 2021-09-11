package com.interview.basic.data_structures.trees_tries_graphs.graph;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class AdjacencyMapGraphTest {

    @Test
    public void test() {
        AdjacencyMapGraph<String, String> graph = new AdjacencyMapGraph<>(false);
        Vertex<String> u = graph.insertVertex("u");
        Vertex<String> v = graph.insertVertex("v");
        Vertex<String> w = graph.insertVertex("w");
        Vertex<String> z = graph.insertVertex("z");
        Edge<String> e = graph.insertEdge(u, v, "e");
        Edge<String> g = graph.insertEdge(u, w, "g");
        Edge<String> f = graph.insertEdge(v, w, "f");
        Edge<String> h = graph.insertEdge(w, z, "h");
        System.out.println(graph.vertices());
        System.out.println(graph.edges());

        Vertex<String> oppositeU = graph.opposite(u, e);
        assertThat(oppositeU).isEqualTo(v);
        Edge<String> edge = graph.getEdge(v, w);
        assertThat(edge).isEqualTo(f);
        Edge<String> edge1 = graph.getEdge(u, z);
        assertThat(edge1).isEqualTo(null);
    }

}