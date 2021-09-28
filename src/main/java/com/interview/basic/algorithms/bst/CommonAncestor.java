package com.interview.basic.algorithms.bst;

import java.util.LinkedList;

public class CommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        LinkedList<TreeNode> ancestors = new LinkedList<>();
        queue.addFirst(root);
        while (!queue.isEmpty()) {
            TreeNode current = queue.removeLast();
            if (isDescendant(current, p) && isDescendant(current, q)) {
                if (current.left != null) {
                    queue.addFirst(current.left);
                }
                if (current.right != null) {
                    queue.addFirst(current.right);
                }
                ancestors.addFirst(current);
            }
        }
        return ancestors.getFirst();
    }

    private boolean isDescendant(TreeNode node, TreeNode child) {
        if (node.val == child.val) {
            return true;
        }
        return (node.left != null && isDescendant(node.left, child)) ||
                (node.right != null && isDescendant(node.right, child));
    }

    public static void main(String[] args) {
        /*TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode0 = new TreeNode(0);
        TreeNode treeNode8 = new TreeNode(8);
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode4 = new TreeNode(4);
        treeNode3.left = treeNode5;
        treeNode3.right = treeNode1;
        treeNode5.left = treeNode6;
        treeNode5.right = treeNode2;
        treeNode2.left = treeNode7;
        treeNode2.right = treeNode4;
        treeNode1.left = treeNode0;
        treeNode1.right = treeNode8;
        CommonAncestor solution = new CommonAncestor();
        TreeNode treeNode = solution.lowestCommonAncestor(treeNode3, treeNode5, treeNode4);*/

        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        treeNode1.left = treeNode2;
        CommonAncestor solution = new CommonAncestor();
        TreeNode treeNode = solution.lowestCommonAncestor(treeNode1, treeNode1, treeNode2);
        System.out.println(treeNode.val);
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}