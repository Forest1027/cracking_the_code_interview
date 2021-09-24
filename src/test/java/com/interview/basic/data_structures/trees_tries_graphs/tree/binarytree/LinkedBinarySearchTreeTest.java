package com.interview.basic.data_structures.trees_tries_graphs.tree.binarytree;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LinkedBinarySearchTreeTest {
    @Test
    public void test() {
        LinkedBinarySearchTree tree = new LinkedBinarySearchTree();
        tree.treeInsert(5);
        tree.treeInsert(10);
        tree.treeInsert(1);
        tree.treeInsert(2);
        tree.treeInsert(8);
        tree.treeInsert(12);
        tree.treeInsert(15);
        tree.treeInsert(6);
        List<Integer> result = tree.inorderTraversal();
        System.out.println(result);
        System.out.println(tree.preOrderTraversal());
        System.out.println(tree.postOrderTraversal());
        tree.BFS();
    }

}