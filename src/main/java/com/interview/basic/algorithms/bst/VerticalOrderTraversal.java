package com.interview.basic.algorithms.bst;

import java.util.*;

/**
 * 987. Vertical Order Traversal of a Binary Tree
 * https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/
 * takeaway:
 * 1. create a class to wrap information together when necessary (oop)
 * 2. understand PriorityQueue and TreeMap
 */
public class VerticalOrderTraversal {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        // make sure on each level, the node is sorted by value
        PriorityQueue<VerticalNode> queue = new PriorityQueue<>();
        // key is col
        Map<Integer, List<Integer>> map = new TreeMap<>();
        // BFS - set row and col
        queue.add(new VerticalNode(root, 0, 0));
        while(!queue.isEmpty()) {
            VerticalNode current = queue.poll();
            List<Integer> list = map.getOrDefault(current.col, new LinkedList<>());
            list.add(current.node.val);
            map.put(current.col, list);
            if(current.node.left != null) {
                queue.add(new VerticalNode(current.node.left, current.col  - 1, current.row + 1));
            }
            if(current.node.right != null) {
                queue.add(new VerticalNode(current.node.right, current.col + 1, current.row + 1));
            }
        }

        // iterate over map to get result
        List<List<Integer>> result = new LinkedList<>();
        for(List<Integer> item: map.values()) {
            result.add(item);
        }
        return result;
    }

    public static void main(String[] args) {
        //[3,9,20,null,null,15,7]
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(20);
        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(7);
        root.left = node1;
        root.right = node2;
        node2.left = node3;
        node2.right = node4;
        VerticalOrderTraversal sol = new VerticalOrderTraversal();
        List<List<Integer>> lists = sol.verticalTraversal(root);
        System.out.println(lists);
    }
}

class VerticalNode implements Comparable<VerticalNode>{
    TreeNode node;
    int col;
    int row;

    public VerticalNode(TreeNode node, int col, int row) {
        this.node = node;
        this.col = col;
        this.row = row;
    }

    @Override
    public int compareTo(VerticalNode vNode) {
        if(vNode.row == this.row) {
            return this.node.val - vNode.node.val;
        }else {
            return this.row - vNode.row;
        }
    }
}
