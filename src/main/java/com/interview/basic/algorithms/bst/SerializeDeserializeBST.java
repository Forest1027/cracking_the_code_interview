package com.interview.basic.algorithms.bst;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 449. Serialize and Deserialize BST
 * https://leetcode.com/problems/serialize-and-deserialize-bst/
 */
public class SerializeDeserializeBST {
    private int index;

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";
        List<Integer> nodes = new LinkedList<>();
        DFS(root, nodes);
        return nodes.stream().map(String::valueOf).collect(Collectors.joining(","));
    }

    private void DFS(TreeNode node, List<Integer> nodes) {
        if (node != null) {
            nodes.add(node.val);
            if (node.left != null) DFS(node.left, nodes);
            if (node.right != null) DFS(node.right, nodes);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("")) return null;
        Integer[] nodes = Arrays.stream(data.split(",")).map(n -> n.equals("null") ? null : Integer.valueOf(n)).toArray(Integer[]::new);
        return dsDFS(nodes, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private TreeNode dsDFS(Integer[] nodes, int min, int max) {
        if (index == nodes.length) {
            return null;
        }
        Integer val = nodes[index];
        if (val == null || val > max || val < min) {
            return null;
        }
        index++;
        TreeNode current = new TreeNode(val);

        current.left = dsDFS(nodes, min, current.val);
        current.right = dsDFS(nodes, current.val, max);
        return current;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        TreeNode left = new TreeNode(1);
        TreeNode right = new TreeNode(3);
        root.left = left;
        root.right = right;
        SerializeDeserializeBST sol = new SerializeDeserializeBST();
        String serialize = sol.serialize(root);
        System.out.println(serialize);
        System.out.println(sol.serialize(sol.deserialize(serialize)));
    }
}
