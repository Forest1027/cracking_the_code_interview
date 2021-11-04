package com.interview.basic.algorithms.graph_traversal;

import java.util.*;

/**
 * 1192. Critical Connections in a Network
 * https://leetcode.com/problems/critical-connections-in-a-network/
 */
public class CriticalConnectionsNetwork {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> result = new LinkedList<>();
        // low-link value array
        // low-link value of a node is the smallest node id reachable from this node
        // nodes with the same low-link value can be considered in one connected subgraph
        int[] low = new int[n];
        // build graph
        List<Set<Integer>> graph = new ArrayList<>(n);
        for (int i = 0; i < n;i++) {
            graph.add(new HashSet<>());
            low[i] = -1;
        }
        for (List<Integer> connection: connections) {
            graph.get(connection.get(0)).add(connection.get(1));
            graph.get(connection.get(1)).add(connection.get(0));
        }

        // tarjan's algorithm
        DFS(0, 0, graph, 0, result, low);
        return result;

    }

    private int DFS(int node, int parent, List<Set<Integer>> graph, int level, List<List<Integer>> result, int[] low) {
        low[node] = level;
        for(int child: graph.get(node)) {
            if (child == parent) continue;
            if (low[child] == -1) {
                // explore ahead
                // if a child node is not visited yet, call DFS to explore it
                low[node] = Math.min(DFS(child, node, graph, level + 1, result, low), low[node]);
            } else {
                // travel back
                // if a child node has been visited, the low-link value needs to be adjusted to the lowest value
                low[node] = Math.min(low[node], low[child]);
            }
        }
        // when the node is not 0
        // and its low-link value is not modified after comparing with its child, this node and its child must belong to two connected subgraph
        if(node != 0 && low[node] == level) {
            result.add(Arrays.asList(node, parent));
        }
        return low[node];
    }
}
