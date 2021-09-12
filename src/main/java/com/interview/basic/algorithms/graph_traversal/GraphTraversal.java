package com.interview.basic.algorithms.graph_traversal;

import com.interview.basic.data_structures.trees_tries_graphs.graph.AdjacencyMapGraph;
import com.interview.basic.data_structures.trees_tries_graphs.graph.Edge;
import com.interview.basic.data_structures.trees_tries_graphs.graph.Graph;
import com.interview.basic.data_structures.trees_tries_graphs.graph.Vertex;

import java.util.*;

public class GraphTraversal {
    // depth first search
    public static <V, E> void DFS(Graph<V, E> g, Vertex<V> u, Set<Vertex<V>> known, Map<Vertex<V>, Edge<E>> forest) {
        known.add(u);
        for (Edge<E> e : g.outgoingEdges(u)) {
            Vertex<V> v = g.opposite(u, e);
            if (!known.contains(v)) {
                forest.put(v, e);
                DFS(g, v, known, forest);
            }
        }
    }

    /**
     * construct path - staring from the end of the path
     *
     * @param g      graph
     * @param u      vertex u
     * @param v      vertex v
     * @param forest explored edges
     * @param <V>
     * @param <E>
     * @return an ordered list of edges comprising the directed path from u to v
     */
    public static <V, E> LinkedList<Edge<E>> constructPath(Graph<V, E> g, Vertex<V> u, Vertex<V> v, Map<Vertex<V>, Edge<E>> forest) {
        LinkedList<Edge<E>> path = new LinkedList<>();
        if (forest.get(v) != null) {
            Vertex<V> walk = v;
            while (walk != u) {
                Edge<E> edge = forest.get(walk);
                path.addFirst(edge);
                walk = g.opposite(walk, edge);
            }
        }
        return path;
    }

    // breadth first search
    public static <V, E> void BFS(Graph<V, E> g, Vertex<V> u, Set<Vertex<V>> known, Map<Vertex<V>, Edge<E>> forest) {
        LinkedList<Vertex<V>> level = new LinkedList<>();
        known.add(u);
        level.addLast(u);
        while (!level.isEmpty()) {
            LinkedList<Vertex<V>> nextLevel = new LinkedList<>();
            for (Vertex<V> v : level) {
                Iterable<Edge<E>> iterable = g.outgoingEdges(v);
                for (Edge<E> e : iterable) {
                    Vertex<V> opposite = g.opposite(v, e);
                    if (!known.contains(opposite)) {
                        known.add(opposite);
                        forest.put(opposite, e);
                        nextLevel.addLast(opposite);
                    }
                }
            }
            level = nextLevel;
        }
    }

    public static void main(String[] args) {
        AdjacencyMapGraph<String, String> graph = new AdjacencyMapGraph<>(false);
        Vertex<String> u = graph.insertVertex("u");
        Vertex<String> v = graph.insertVertex("v");
        Vertex<String> w = graph.insertVertex("w");
        Vertex<String> z = graph.insertVertex("z");
        Edge<String> e = graph.insertEdge(u, v, "e");
        Edge<String> g = graph.insertEdge(u, w, "g");
        Edge<String> f = graph.insertEdge(v, w, "f");
        Edge<String> h = graph.insertEdge(w, z, "h");

        System.out.println("Depth first search");
        Set<Vertex<String>> known = new HashSet<>();
        Map<Vertex<String>, Edge<String>> forest = new HashMap<>();
        DFS(graph, u, known, forest);
        System.out.println(forest);
        LinkedList<Edge<String>> path = constructPath(graph, u, z, forest);
        System.out.println(path);
        System.out.println();

        System.out.println("Breadth first search");
        Set<Vertex<String>> known2 = new HashSet<>();
        Map<Vertex<String>, Edge<String>> forest2 = new HashMap<>();
        BFS(graph, u, known2, forest2);
        System.out.println(forest2);
        LinkedList<Edge<String>> path2 = constructPath(graph, u, z, forest2);
        System.out.println(path2);
    }
}
