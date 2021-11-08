package com.interview.basic.algorithms.bst;

import java.util.LinkedList;
import java.util.List;

/**
 * 113. Path Sum II
 * https://leetcode.com/problems/path-sum-ii/
 */
public class PathSum2 {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root == null) return new LinkedList<>();
        List<List<Integer>> result = new LinkedList<>();
        LinkedList<Integer> nodes = new LinkedList<>();
        int sum = root.val;
        nodes.add(root.val);
        DFS(root, result, nodes, sum, targetSum);
        return result;
    }

    private void DFS(TreeNode node, List<List<Integer>> result, LinkedList<Integer> nodes, int sum,int targetSum) {
        if(node.left == null && node.right == null && sum == targetSum) {
            result.add(new LinkedList<>(nodes));
            return;
        }

        if(node.left != null) {
            nodes.add(node.left.val);
            DFS(node.left, result, nodes, sum + node.left.val, targetSum);
            nodes.removeLast();
        }

        if(node.right != null) {
            nodes.add(node.right.val);
            DFS(node.right, result, nodes, sum + node.right.val, targetSum);
            nodes.removeLast();
        }
    }
}
