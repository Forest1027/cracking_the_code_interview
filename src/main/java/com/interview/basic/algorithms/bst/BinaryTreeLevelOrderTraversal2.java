package com.interview.basic.algorithms.bst;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 107. Binary Tree Level Order Traversal II
 * https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
 */
public class BinaryTreeLevelOrderTraversal2 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if(root == null) return new LinkedList<>();
        // BFS
        Queue<TreeNode> level = new LinkedList<>();
        List<List<Integer>> result = new LinkedList<>();
        level.add(root);
        List<Integer> list = new LinkedList<>();
        list.add(root.val);
        result.add(list);
        while(!level.isEmpty()) {
            Queue<TreeNode> nextLevel = new LinkedList<>();
            List<Integer> nextLevelInt = new LinkedList<>();
            while(!level.isEmpty()) {
                TreeNode current = level.remove();
                if(current.left != null) {
                    nextLevel.add(current.left);
                    nextLevelInt.add(current.left.val);
                }
                if(current.right != null) {
                    nextLevel.add(current.right);
                    nextLevelInt.add(current.right.val);
                }
            }
            // add to top
            if(!nextLevelInt.isEmpty()) result.add(0, nextLevelInt);
            level = nextLevel;
        }

        return result;
    }
}
