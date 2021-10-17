package com.interview.basic.algorithms.bst;

import java.util.*;

/**
 * 102. Binary Tree Level Order Traversal
 * https://leetcode.com/problems/binary-tree-level-order-traversal/
 */
public class BinaryTreeLevelTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new LinkedList<>();
        List<List<Integer>> result = new LinkedList<>();
        Map<TreeNode, Integer> levelMap = new HashMap<>();
        Queue<TreeNode> Q = new LinkedList<>();
        Q.add(root);
        List<Integer> list = new LinkedList<>();
        int level = 0;
        levelMap.put(root, level);
        while (!Q.isEmpty()) {
            TreeNode node = Q.remove();
            if (node != null) {
                int currentLevel = levelMap.get(node);
                if (currentLevel != level) {
                    result.add(list);
                    list = new LinkedList<>();
                    level = currentLevel;
                }
                list.add(node.val);
                Q.add(node.left);
                Q.add(node.right);
                levelMap.put(node.left, currentLevel + 1);
                levelMap.put(node.right, currentLevel + 1);
            }
        }
        result.add(list);
        return result;
    }

    public static void main(String[] args) {
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode9 = new TreeNode(9);
        TreeNode treeNode20 = new TreeNode(20);
        TreeNode treeNode15 = new TreeNode(15);
        TreeNode treeNode7 = new TreeNode(7);
        treeNode3.left = treeNode9;
        treeNode3.right = treeNode20;
        treeNode20.left = treeNode15;
        treeNode20.right = treeNode7;
        BinaryTreeLevelTraversal sol = new BinaryTreeLevelTraversal();
        System.out.println(sol.levelOrder(treeNode3));
    }
}
