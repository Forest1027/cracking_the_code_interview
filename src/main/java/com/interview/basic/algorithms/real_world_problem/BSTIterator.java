package com.interview.basic.algorithms.real_world_problem;

import java.util.Stack;

/**
 * 173. Binary Search Tree Iterator
 * https://leetcode.com/problems/binary-search-tree-iterator/
 */
public class BSTIterator {
    private Stack<TreeNode> stack = new Stack<>();

    public BSTIterator(TreeNode root) {
        pushAll(root);
    }

    public int next() {
        TreeNode node = stack.pop();
        pushAll(node.right);
        return node.val;
    }

    public boolean hasNext() {
        return !(stack.isEmpty());
    }

    // smallest always on the top of the stack
    private void pushAll(TreeNode node) {
        TreeNode temp = node;
        while (temp != null) {
            this.stack.push(temp);
            temp = temp.left;
        }
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
