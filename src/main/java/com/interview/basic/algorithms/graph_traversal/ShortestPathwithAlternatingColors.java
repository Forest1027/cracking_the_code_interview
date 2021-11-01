package com.interview.basic.algorithms.graph_traversal;

import java.util.*;

/**
 * 1129. Shortest Path with Alternating Colors
 * https://leetcode.com/problems/shortest-path-with-alternating-colors/
 */
public class ShortestPathwithAlternatingColors {
    /**
     * Time: O(V+E)
     * Space: O(V+E)
     */
    public int[] shortestAlternatingPaths(int n, int[][] red_edges, int[][] blue_edges) {
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = -1;
        }
        result[0] = 0;
        if (n == 1) return result;
        // preprocess to have adjacency list representation
        List<List<Pair<Integer, String>>> nodes = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            nodes.add(new LinkedList<>());
        }
        for (int[] neighbors : red_edges) {
            nodes.get(neighbors[0]).add(new Pair<>(neighbors[1], "red"));
        }
        for (int[] neighbors : blue_edges) {
            nodes.get(neighbors[0]).add(new Pair<>(neighbors[1], "blue"));
        }
        // track the node and the color of the edge traversed for reaching this node
        Queue<Pair<Integer, String>> Q = new LinkedList<>();
        // each path can only be traversed once
        Set<Pair<Integer, String>> visited = new HashSet<>();
        Q.add(new Pair<>(0, ""));
        int level = 0;
        while (!Q.isEmpty()) {
            Queue<Pair<Integer, String>> nextLevel = new LinkedList<>();
            level++;
            for (Pair<Integer, String> pair : Q) {
                int current = pair.getKey();
                String color = pair.getValue();
                List<Pair<Integer, String>> outgoings = nodes.get(current);
                for (Pair<Integer, String> neighbor : outgoings) {
                    if (!neighbor.getValue().equals(color) && !visited.contains(neighbor)) {
                        result[neighbor.getKey()] = result[neighbor.getKey()] == -1 ? level : Math.min(level, result[neighbor.getKey()]);
                        nextLevel.add(neighbor);
                        visited.add(neighbor);
                    }
                }
            }
            Q = nextLevel;
        }
        return result;
    }

    private class Pair<K, V> implements Map.Entry<K, V> {
        private K key;
        private V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public K getKey() {
            return this.key;
        }

        @Override
        public V getValue() {
            return this.value;
        }

        @Override
        public V setValue(V value) {
            this.value = value;
            return this.value;
        }
    }

    public static void main(String[] args) {
        /*
         5
         [[0,1],[1,2],[2,3],[3,4]]
         [[1,2],[2,3],[3,1]]

         3
         [[0,1],[0,2]]
         [[1,0]]

         5
         [[1,4],[0,3]]
         [[3,1],[3,4]]
         */
        int[][] red = new int[][]{{1, 4}, {0, 3}};
        int[][] blue = new int[][]{{3, 1}, {3, 4}};
        ShortestPathwithAlternatingColors sol = new ShortestPathwithAlternatingColors();
        int[] result = sol.shortestAlternatingPaths(5, red, blue);
        System.out.println(Arrays.toString(result));
    }
}
