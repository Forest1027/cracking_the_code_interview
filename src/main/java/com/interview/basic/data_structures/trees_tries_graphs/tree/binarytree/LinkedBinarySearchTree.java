package com.interview.basic.data_structures.trees_tries_graphs.tree.binarytree;

import java.util.*;

public class LinkedBinarySearchTree {
    private BSTNode root;
    private int size;

    public BSTNode getRoot() {
        return root;
    }

    public void setRoot(BSTNode root) {
        this.root = root;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public BSTNode treeSearch(BSTNode position, int target) {
        if (this.isExternal(position)) {
            return position;
        } else if (position.getElement() == target) {
            return position;
        } else if (position.getElement() > target) {
            return treeSearch(position.getLeft(), target);
        } else {
            return treeSearch(position.getRight(), target);
        }
    }

    public BSTNode treeInsert(int target) {
        if (this.size == 0) {
            this.root = new BSTNode(null, null, null, target);
            this.size++;
            return this.root;
        } else {
            BSTNode bstNode = treeSearch(this.root, target);
            if (bstNode.getElement() != target) {
                this.size++;
                return this.expandExternal(bstNode, target);
            } else {
                return bstNode;
            }
        }

    }

    public void treeDelete(int target) {
        BSTNode bstNode = treeSearch(this.root, target);
        if (bstNode.getElement() != target) {
            throw new IllegalArgumentException("No such element.");
        } else {
            if (!(bstNode.getRight() != null && bstNode.getLeft() != null)) {
                // has at most one child
                var parent = bstNode.getParent();
                if (bstNode.getLeft() != null) {
                    bstNode = bstNode.getLeft();
                } else {
                    bstNode = bstNode.getRight();
                }
            } else {
                // find max position on the left tree
                BSTNode leftMax = treeMax(bstNode.getLeft());
                // exchange leftMax and position
                bstNode.setElement(leftMax.getElement());
                leftMax.setElement(bstNode.getElement());
                // remove original position of leftMax
                leftMax = null;
            }
            this.size--;
        }
    }

    // traversal methods
    public List<Integer> inorderTraversal() {
        List<Integer> result = new ArrayList<>();
        inorderUtil(this.root, result);
        return result;
    }

    private void inorderUtil(BSTNode position, List<Integer> elements) {
        if (position.getLeft() != null) {
            inorderUtil(position.getLeft(), elements);
        }
        elements.add(position.getElement());
        if (position.getRight() != null) {
            inorderUtil(position.getRight(), elements);
        }
    }

    public List<Integer> preOrderTraversal() {
        List<Integer> result = new ArrayList<>();
        preOrderUtil(this.root, result);
        return result;
    }

    private void preOrderUtil(BSTNode position, List<Integer> elements) {
        elements.add(position.getElement());
        if (position.getLeft() != null) {
            preOrderUtil(position.getLeft(), elements);
        }
        if (position.getRight() != null) {
            preOrderUtil(position.getRight(), elements);
        }
    }

    public List<Integer> postOrderTraversal() {
        List<Integer> result = new ArrayList<>();
        postOrderUtil(this.root, result);
        return result;
    }

    private void postOrderUtil(BSTNode position, List<Integer> elements) {
        if (position.getLeft() != null) {
            postOrderUtil(position.getLeft(), elements);
        }
        if (position.getRight() != null) {
            postOrderUtil(position.getRight(), elements);
        }
        elements.add(position.getElement());
    }

    public void BFS() {
        Queue<BSTNode> queue = new LinkedList<>();
        queue.add(this.root);
        while (!queue.isEmpty()) {
            BSTNode current = queue.remove();
            System.out.print(current.getElement() + "\t");
            if (current.getLeft() != null) {
                queue.add(current.getLeft());
            }
            if (current.getRight() != null) {
                queue.add(current.getRight());
            }
        }
    }

    private BSTNode treeMax(BSTNode position) {
        BSTNode walk = position;
        while (walk.getRight() != null) {
            walk = walk.getRight();
        }
        return walk;
    }

    private BSTNode expandExternal(BSTNode position, int target) {
        if (position.getElement() == target) {
            return position;
        }
        BSTNode tNode = new BSTNode(position, null, null, target);
        if (target < position.getElement()) {
            position.setLeft(tNode);
        } else {
            position.setRight(tNode);
        }
        return tNode;
    }

    private boolean isExternal(BSTNode position) {
        return position.getLeft() == null || position.getRight() == null;
    }

}

class BSTNode {
    private BSTNode parent;
    private BSTNode left;
    private BSTNode right;
    private int element;

    public BSTNode(BSTNode parent, BSTNode left, BSTNode right, int element) {
        this.parent = parent;
        this.left = left;
        this.right = right;
        this.element = element;
    }

    public BSTNode getParent() {
        return parent;
    }

    public void setParent(BSTNode parent) {
        this.parent = parent;
    }

    public BSTNode getLeft() {
        return left;
    }

    public void setLeft(BSTNode left) {
        this.left = left;
    }

    public BSTNode getRight() {
        return right;
    }

    public void setRight(BSTNode right) {
        this.right = right;
    }

    public int getElement() {
        return element;
    }

    public void setElement(int element) {
        this.element = element;
    }
}
