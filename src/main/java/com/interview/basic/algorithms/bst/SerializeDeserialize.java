package com.interview.basic.algorithms.bst;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class SerializeDeserialize {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        LinkedList<Integer> result = new LinkedList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        while(!queue.isEmpty()) {
            TreeNode current = queue.removeFirst();
            if(current == null) {
                result.add(null);
            } else {
                result.add(current.val);
            }
            if(current != null) {
                queue.addLast(current.left);
                queue.addLast(current.right);
            }
        }
        return result.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        List<String> dataList= Arrays.stream(data.replaceAll("\\[", "").replaceAll("]", "").split(",")).map(s -> s.trim()).collect(Collectors.toList());
        LinkedList<TreeNode> Q = new LinkedList<>();
        if(dataList.get(0).equals("null")) {
            return null;
        } else {
            TreeNode root = new TreeNode(Integer.valueOf(dataList.get(0)));
            int index = 1;
            Q.addLast(root);
            while(!Q.isEmpty()) {
                TreeNode current = Q.removeFirst();
                TreeNode left = !dataList.get(index).equals("null")? new TreeNode(Integer.valueOf(dataList.get(index))) : null;
                TreeNode right = !dataList.get(index + 1).equals("null")? new TreeNode(Integer.valueOf(dataList.get(index + 1))) : null;
                current.left = left;
                current.right = right;
                if(left != null) Q.addLast(left);
                if(right != null) Q.addLast(right);
                index += 2;
            }
            return root;
        }

    }

    public static void main(String[] args) {
        TreeNode treeNode3 = new TreeNode(3);
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
        SerializeDeserialize solution = new SerializeDeserialize();
        String serialize = solution.serialize(treeNode3);
        System.out.println(serialize);
        TreeNode deserialize = solution.deserialize(serialize);
        System.out.println(deserialize.val);
    }
}