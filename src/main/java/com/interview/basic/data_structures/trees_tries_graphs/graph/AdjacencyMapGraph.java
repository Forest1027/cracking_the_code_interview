package com.interview.basic.data_structures.trees_tries_graphs.graph;

import java.util.*;

public class AdjacencyMapGraph<V, E> implements Graph<V, E> {
    private boolean isDirected;
    private List<Vertex<V>> vertices = new LinkedList<>();
    private List<Edge<E>> edges = new LinkedList<>();

    public AdjacencyMapGraph(boolean isDirected) {
        this.isDirected = isDirected;
    }

    @Override
    public int numVertices() {
        return vertices.size();
    }

    @Override
    public Iterable<Vertex<V>> vertices() {
        return vertices;
    }

    @Override
    public int numEdges() {
        return edges.size();
    }

    @Override
    public Iterable<Edge<E>> edges() {
        return edges;
    }

    @Override
    public Edge<E> getEdge(Vertex<V> u, Vertex<V> v) {
        InnerVertex<V> origin = validate(u);
        return origin.getOutgoing().get(v);
    }

    @Override
    public Vertex<V>[] endVertices(Edge<E> e) {
        InnerEdge<E> edge = validate(e);
        return edge.endpoints;
    }

    @Override
    public Vertex<V> opposite(Vertex<V> v, Edge<E> e) {
        InnerEdge<E> edge = validate(e);
        Vertex<V>[] endpoints = edge.endpoints;
        if (endpoints[0].equals(v)) {
            return endpoints[1];
        } else if (endpoints[1].equals(v)) {
            return endpoints[0];
        } else {
            throw new IllegalArgumentException("v is not incident to this edge");
        }
    }

    @Override
    public int outDegree(Vertex<V> v) {
        InnerVertex<V> vertex = validate(v);
        return vertex.outgoing.size();
    }

    @Override
    public int inDegree(Vertex<V> v) {
        InnerVertex<V> vertex = validate(v);
        return vertex.incoming.size();
    }

    @Override
    public Iterable<Edge<E>> outgoingEdges(Vertex<V> v) {
        InnerVertex<V> vertex = validate(v);
        return vertex.outgoing.values();
    }

    @Override
    public Iterable<Edge<E>> incomingEdges(Vertex<V> v) {
        InnerVertex<V> vertex = validate(v);
        return vertex.incoming.values();
    }

    @Override
    public Vertex<V> insertVertex(V element) {
        InnerVertex<V> vertex = new InnerVertex<>(element, isDirected);
        vertices.add(vertex);
        return vertex;
    }

    @Override
    public Edge<E> insertEdge(Vertex<V> u, Vertex<V> v, E element) {
        if (getEdge(u, v) == null) {
            InnerEdge<E> edge = new InnerEdge<>(u, v, element);
            edges.add(edge);
            InnerVertex<V> origin = validate(u);
            InnerVertex<V> dest = validate(v);
            origin.outgoing.put(v, edge);
            dest.incoming.put(u, edge);
            return edge;
        } else {
            throw new IllegalArgumentException("Edge from u to v exists");
        }
    }

    @Override
    public void removeVertex(Vertex<V> v) {
        InnerVertex<V> vertex = validate(v);
        for (Edge<E> e : vertex.outgoing.values()) {
            removeEdge(e);
        }

        for (Edge<E> e : vertex.incoming.values()) {
            removeEdge(e);
        }

        vertices.remove(vertex);
        vertex = null;
    }

    @Override
    public void removeEdge(Edge<E> e) {
        InnerEdge<E> edge = validate(e);
        InnerVertex<V>[] endpoints = (InnerVertex<V>[]) edge.endpoints;
        endpoints[0].outgoing.remove(endpoints[1]);
        endpoints[1].incoming.remove(endpoints[0]);
        edges.remove(edge);
        edge = null;
    }

    private InnerVertex<V> validate(Vertex<V> v) {
        if (!(v instanceof InnerVertex)) throw new IllegalArgumentException("Invalid vertex");
        InnerVertex<V> vert = (InnerVertex<V>) v;     // safe cast
        if (!vert.validate(this)) throw new IllegalArgumentException("Invalid vertex");
        return vert;
    }

    private InnerEdge<E> validate(Edge<E> e) {
        if (!(e instanceof InnerEdge)) throw new IllegalArgumentException("Invalid edge");
        InnerEdge<E> edge = (InnerEdge<E>) e;     // safe cast
        if (!edge.validate(this)) throw new IllegalArgumentException("Invalid edge");
        return edge;
    }

    // InnerVertex
    private class InnerVertex<V> implements Vertex<V> {
        private V element;
        private Map<Vertex<V>, Edge<E>> outgoing, incoming;

        public InnerVertex(V element, boolean graphIsDirected) {
            this.element = element;
            outgoing = new HashMap<>();
            if (graphIsDirected) {
                incoming = new HashMap<>();
            } else {
                incoming = outgoing;
            }
        }

        @Override
        public V getElement() {
            return element;
        }

        public Map<Vertex<V>, Edge<E>> getOutgoing() {
            return outgoing;
        }

        public Map<Vertex<V>, Edge<E>> getIncoming() {
            return incoming;
        }

        public boolean validate(Graph<V, E> graph) {
            return AdjacencyMapGraph.this == graph;
        }

        @Override
        public String toString() {
            return "InnerVertex{" +
                    "element=" + element +
                    '}';
        }
    }

    // InnerEdge
    private class InnerEdge<E> implements Edge<E> {
        private E element;
        private Vertex<V>[] endpoints;

        public InnerEdge(Vertex<V> u, Vertex<V> v, E element) {
            this.element = element;
            endpoints = (Vertex<V>[]) new Vertex[]{u, v};
        }

        @Override
        public E getElement() {
            return null;
        }


        public Vertex<V>[] getEndpoints() {
            return endpoints;
        }

        public boolean validate(Graph<V, E> graph) {
            return AdjacencyMapGraph.this == graph;
        }

        @Override
        public String toString() {
            return "InnerEdge{" +
                    "element=" + element +
                    '}';
        }
    }
}
