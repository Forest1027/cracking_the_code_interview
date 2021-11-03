package com.interview.basic.algorithms.graph_traversal;

import java.util.*;

/**
 * 886. Possible Bipartition
 * https://leetcode.com/problems/possible-bipartition/
 */
public class PossibleBipartition {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        // preprocess
        List<Set<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new HashSet<>());
        }
        for (int[] dislike : dislikes) {
            graph.get(dislike[0] - 1).add(dislike[1] - 1);
            graph.get(dislike[1] - 1).add(dislike[0] - 1);
        }
        // 1 is blue, -1 is red, 0 is not colored yet
        int[] colors = new int[n];
        for (int i = 0; i < n; i++) {
            if (colors[i] == 0 && !DFS(i, colors, 1, graph)) return false;
        }
        return true;
    }

    public boolean DFS(int node, int[] colors, int color, List<Set<Integer>> graph) {
        colors[node] = color;
        for (int neighbor: graph.get(node)) {
            if (colors[neighbor] == color) return false;
            if (colors[neighbor] == 0 && !DFS(neighbor, colors, -color, graph)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        /**
         * 4
         * [[1,2],[1,3],[2,4]]
         *
         * 5
         * [[1,2],[3,4],[4,5],[1,5]]
         */
        int[][] dislikes = new int[][]{{1, 2}, {3, 4}, {4, 5}, {1, 5}};
        PossibleBipartition sol = new PossibleBipartition();
        boolean b = sol.possibleBipartition(5, dislikes);
        System.out.println(b);
    }
}
