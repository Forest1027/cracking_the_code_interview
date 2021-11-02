package com.interview.basic.algorithms.graph_traversal;

import java.util.*;

/**
 * 787. Cheapest Flights Within K Stops
 * https://leetcode.com/problems/cheapest-flights-within-k-stops/
 */
public class CheapestFlightsWithinKStops {
    /**
     * 1. To use PriorityQueue in java, we can pass a Comparator to constructor
     * 2. Use class instead of key-value pair to represent the node when there are several data needs to be considered(distance, weigh, label)
     */
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        if (src == dst) return 0;
        // Init dists and stop, and build graph.
        int[] dists = new int[n];
        int[] stops = new int[n];
        Arrays.fill(dists, Integer.MAX_VALUE);
        Arrays.fill(stops, Integer.MAX_VALUE);
        dists[src] = 0;
        stops[src] = 0;
        List<Node>[] graph = buildGraph(n, flights);  // node, neighbor, dist
        // Build min heap and start from src node.
        PriorityQueue<Node> heap = new PriorityQueue<>(Comparator.comparingInt(f -> f.dist));
        heap.add(new Node(src, 0, 0));
        while (!heap.isEmpty()) {
            Node node = heap.poll();
            if (node.label == dst) return node.dist;
            if (node.stop > k) continue;
            for (Node neighbor : graph[node.label]) {
                // Add to heap 1) distance is shorter; 2) number of stops are less.
                if (dists[neighbor.label] > node.dist + neighbor.dist) {
                    // if node.dist + neighbor.dist update dists array and explore the neighbor.
                    dists[neighbor.label] = node.dist + neighbor.dist;
                    heap.add(new Node(neighbor.label, dists[neighbor.label], node.stop + 1));
                } else if (node.stop < stops[neighbor.label]) {
                    // if node.stop < stops[neighbor.label], explore the neighbor.
                    heap.add(new Node(neighbor.label, node.dist + neighbor.dist, node.stop + 1));
                }
                stops[neighbor.label] = node.stop;
            }
        }
        return dists[dst] == Integer.MAX_VALUE ? -1 : dists[dst];
    }

    private List<Node>[] buildGraph(int n, int[][] flights) {
        List<Node>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] f : flights) {
            graph[f[0]].add(new Node(f[1], f[2], 0));
        }
        return graph;
    }

    private class Node {
        int label, dist, stop;

        Node(int label, int dist, int stop) {
            this.label = label;
            this.dist = dist;
            this.stop = stop;
        }
    }

    public static void main(String[] args) {
        /**
         * 3
         * [[0,1,100],[1,2,100],[0,2,500]]
         * 0
         * 2
         * 1
         *
         * 4
         * [[0,1,1],[0,2,5],[1,2,1],[2,3,1]]
         * 0
         * 3
         * 1
         *
         * 5
         * [[0,1,5],[1,2,5],[0,3,2],[3,1,2],[1,4,1],[4,2,1]]
         * 0
         * 2
         * 2
         */

        CheapestFlightsWithinKStops sol = new CheapestFlightsWithinKStops();
        int[][] flights = new int[][]{{0, 1, 5}, {1, 2, 5}, {0, 3, 2}, {3, 1, 2}, {1, 4, 1}, {4, 2, 1}};
        int result = sol.findCheapestPrice(5, flights, 0, 2, 2);
        System.out.println(result);
    }
}
