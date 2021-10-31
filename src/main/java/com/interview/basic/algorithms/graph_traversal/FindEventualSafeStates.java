package com.interview.basic.algorithms.graph_traversal;

import java.util.*;

/**
 * 802. Find Eventual Safe States
 * https://leetcode.com/problems/find-eventual-safe-states/
 */
public class FindEventualSafeStates {
    /**
     * Time complexity: Max(O(V+E), O(NlogN))
     * N is the number of element in result list.
     */
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> result = new LinkedList<>();
        LinkedList<Integer> container = new LinkedList<>();
        // preprocess to get a list of incoming nodes
        int size = graph.length;
        List<Set<Integer>> incomings = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            incomings.add(new HashSet<>());
            if (graph[i].length == 0) {
                container.add(i);
                result.add(i);
            }
        }
        for (int i = 0; i < size; i++) {
            for (int node : graph[i]) {
                incomings.get(node).add(i);
            }
        }
        // topological sort
        while (!container.isEmpty()) {
            int node = container.removeFirst();
            for (int inNode : incomings.get(node)) {
                int[] outGoing = graph[inNode];
                // remove the node
                for (int i = 0; i < outGoing.length; i++) {
                    if (i != outGoing.length - 1) outGoing[i] = outGoing[i + 1];
                }
                graph[inNode] = Arrays.copyOfRange(outGoing, 0, outGoing.length - 1);
                if (graph[inNode].length == 0) {
                    container.add(inNode);
                    result.add(inNode);
                }
            }
        }
        Collections.sort(result);
        return result;
    }

    /**
     * Time complexity: worst O(V(V+E))
     * For each vertex/node traverse the whole graph to see if it has cycle.
     */
    public List<Integer> eventualSafeNodes2(int[][] graph) {
        List<Integer> result = new LinkedList<>();
        for (int i = 0; i < graph.length; i++) {
            int[] nodes = graph[i];
            boolean flag = true;
            for (int neighbor : nodes) {
                boolean[] visited = new boolean[graph.length];
                visited[i] = true;
                flag = DFS(neighbor, graph, visited);
                if (!flag) {
                    break;
                }
            }
            if (flag) result.add(i);
        }
        return result;
    }

    private boolean DFS(int node, int[][] graph, boolean[] visited) {
        if (visited[node]) return false;
        boolean flag = true;
        for (int neighbor : graph[node]) {
            visited[node] = true;
            flag = DFS(neighbor, graph, visited);
            // backtrack
            visited[node] = false;
            if (!flag) break;
        }
        return flag;
    }

    public static void main(String[] args) {
        int[][] graph = new int[][]{{}, {2}, {3, 4}, {4}, {}};
        FindEventualSafeStates sol = new FindEventualSafeStates();
        List<Integer> result = sol.eventualSafeNodes(graph);
        System.out.println(result);
    }
}
