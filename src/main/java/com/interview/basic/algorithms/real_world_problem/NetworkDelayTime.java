package com.interview.basic.algorithms.real_world_problem;

import java.util.*;

/**
 * 743. Network Delay Time
 * https://leetcode.com/problems/network-delay-time/
 */
public class NetworkDelayTime {
    public int networkDelayTime(int[][] times, int n, int k) {
        // build graph
        List<Map<Integer, Integer>> graph = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            graph.add(new HashMap<>());
        }
        for (int[] edge : times) {
            Map<Integer, Integer> map = graph.get(edge[0] - 1);
            map.put(edge[1] - 1, edge[2]);
        }
        // Dijkstra's algorithm
        boolean[] visited = new boolean[n];
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(k - 1);
        dist[k - 1] = 0;
        visited[k - 1] = true;
        while (!queue.isEmpty()) {
            int current = queue.removeLast();
            Map<Integer, Integer> outEdges = graph.get(current);
            for (int key : outEdges.keySet()) {
                if (dist[current] + outEdges.get(key) < dist[key] || !visited[key]) {
                    queue.add(key);
                    visited[key] = true;
                    if (dist[current] + outEdges.get(key) < dist[key]) {
                        dist[key] = dist[current] + outEdges.get(key);
                    }
                }
            }
        }
        Arrays.sort(dist);
        if (dist[n - 1] == Integer.MAX_VALUE) return -1;
        else return dist[n - 1];
    }

    public static void main(String[] args) {
        /**
         * [[2,1,1],[2,3,1],[3,4,1]]
         * 4
         * 2
         */
        NetworkDelayTime sol = new NetworkDelayTime();
        int[][] times = new int[][]{{2, 1, 1}, {2, 3, 1}, {3, 4, 1}};
        System.out.println(sol.networkDelayTime(times, 4, 2));
    }
}
