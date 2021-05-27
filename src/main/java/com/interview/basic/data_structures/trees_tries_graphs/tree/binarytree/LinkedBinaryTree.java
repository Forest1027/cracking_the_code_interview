package com.interview.basic.data_structures.trees_tries_graphs.tree.binarytree;

import com.interview.basic.data_structures.trees_tries_graphs.Position;

import java.util.Iterator;

public class LinkedBinaryTree<E> extends AbstractBinaryTree<E> {
    private Node<E> root = null;
    private int size = 0;

    @Override
    public Position<E> root() {
        return this.root;
    }

    @Override
    public Position<E> parent(Position<E> p) throws IllegalStateException {
        Node<E> node = validate(p);
        return node.parent;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public Iterable<Position<E>> positions() {
        return null;
    }

    @Override
    public Position<E> left(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return node.left;
    }

    @Override
    public Position<E> right(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return node.right;
    }

    // helper methods
    protected Node<E> createNode(Node<E> parent, Node<E> left, Node<E> right, E element) {
        return new Node<E>(parent, left, right, element);
    }

    protected Node<E> validate(Position<E> p) throws IllegalArgumentException {
        if (!(p instanceof Node)) {
            throw new IllegalArgumentException("Not valid position type");
        }
        Node<E> node = (Node<E>) p;
        if (node.parent == node) {
            throw new IllegalArgumentException("p is no longer a tree");
        }
        return node;
    }

    private Node<E> addRoot(E e) {
        if (!isEmpty()) {
            throw new IllegalArgumentException("Tree is not empty");
        }
        return createNode(null, null, null, e);
    }

    private Node<E> addLeft(Position<E> p, E e) {
        Node<E> node = validate(p);
        if (node.left != null) {
            throw new IllegalArgumentException("p already has left child");
        }
        Node<E> left = createNode(node, null, null, e);
        node.left = left;
        size++;
        return left;
    }

    private Node<E> addRight(Position<E> p, E e) {
        Node<E> node = validate(p);
        if (node.right != null) {
            throw new IllegalArgumentException("p already has right child");
        }
        Node<E> right = createNode(node, null, null, e);
        node.right = right;
        size++;
        return right;
    }

    private E set(Position<E> p, E e) {
        Node<E> node = validate(p);
        E oldElement = p.getElement();
        node.element = e;
        return oldElement;
    }

    private void attach(Position<E> p, LinkedBinaryTree<E> tree1, LinkedBinaryTree<E> tree2) {
        Node<E> node = validate(p);
        if (isInternal(p)) {
            throw new IllegalArgumentException("p numst be a leaf");
        }
        size += tree1.size += tree2.size;
        if (!tree1.isEmpty()) {
            tree1.root.parent = node;
            node.left = tree1.root;
            tree1.root = null;
            tree1.size = 0;
        }
        if (!tree2.isEmpty()) {
            tree2.root.parent = node;
            node.right = tree2.root;
            tree2.root = null;
            tree2.size = 0;
        }
    }

    /**
     * remove node at position p and replace it with its child
     *
     * @param p
     * @return
     */
    private E remove(Position<E> p) {
        Node<E> node = validate(p);
        if (numChildren(p) == 2) {
            throw new IllegalArgumentException("p has 2 children");
        }
        Node<E> child = node.left != null ? node.left : node.right;
        if (child != null) {
            child.parent = node.parent;
        }

        if (node == root) {
            root = child;
        } else {
            Node<E> parent = node.parent;
            if (node == parent.left) {
                parent.left = child;
            } else {
                parent.right = child;
            }
        }
        size--;
        E e = node.element;
        node.element = null;
        node.left = null;
        node.right = null;
        node.parent = node;
        return e;
    }

    // nested Node class
    protected static class Node<E> implements Position<E> {
        private Node<E> parent;
        private Node<E> left;
        private Node<E> right;
        private E element;

        public Node(Node<E> parent, Node<E> left, Node<E> right, E element) {
            this.parent = parent;
            this.left = left;
            this.right = right;
            this.element = element;
        }

        @Override
        public E getElement() throws IllegalStateException {
            return element;
        }
    }

}
