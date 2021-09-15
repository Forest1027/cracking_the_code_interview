package com.interview.basic.algorithms.graph_traversal;

import java.util.*;
import java.util.stream.Collectors;

public class CloneGraph {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        Stack<Node> level = new Stack<>();
        Map<Node, Node> map = new HashMap<>();
        level.push(node);
        map.put(node, new Node(node.val));
        while (!level.empty()) {
            Node current = level.pop();
            for (Node neighbor : current.neighbors) {
                if (!map.containsKey(neighbor)) {
                    map.put(neighbor, new Node(neighbor.val));
                    level.push(neighbor);
                }
                map.get(current).neighbors.add(map.get(neighbor));
            }
        }
        return map.get(node);
    }


    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        n1.neighbors.add(n2);
        n1.neighbors.add(n4);
        n2.neighbors.add(n1);
        n2.neighbors.add(n3);
        n3.neighbors.add(n2);
        n3.neighbors.add(n4);
        n4.neighbors.add(n1);
        n4.neighbors.add(n3);

        CloneGraph solution = new CloneGraph();
        Node node = solution.cloneGraph(n1);
        System.out.println(node);
    }
}

class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }

    @Override
    public String toString() {
        return neighbors.stream().map(n -> n.val).collect(Collectors.toList()).toString();
    }
}
