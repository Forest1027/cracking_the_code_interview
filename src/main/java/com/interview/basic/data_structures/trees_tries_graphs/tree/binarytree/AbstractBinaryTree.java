package com.interview.basic.data_structures.trees_tries_graphs.tree.binarytree;

import com.interview.basic.data_structures.trees_tries_graphs.Position;
import com.interview.basic.data_structures.trees_tries_graphs.tree.AbstractTree;
import com.interview.basic.data_structures.trees_tries_graphs.tree.TraversalMethod;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractBinaryTree<E> extends AbstractTree<E> implements BinaryTree<E> {
    @Override
    public Position<E> sibling(Position<E> p) throws IllegalArgumentException {
        Position<E> parent = parent(p);
        if (parent == null) {
            return null;
        }
        if (p == left(parent)) {
            return right(parent);
        } else {
            return left(parent);
        }
    }

    @Override
    public Iterable<Position<E>> children(Position<E> p) throws IllegalStateException {
        List<Position<E>> children = new ArrayList<>(2);
        if (left(p) != null) {
            children.add(left(p));
        }
        if (right(p) != null) {
            children.add(right(p));
        }
        return children;
    }

    @Override
    public int numChildren(Position<E> p) throws IllegalStateException {
        int count = 0;
        if (left(p) != null) {
            count++;
        }
        if (right(p) != null) {
            count++;
        }
        return count;
    }

    @Override
    public Iterable<Position<E>> positions() {
        Iterable<Position<E>> result = super.positions();
        if (result == null && super.traversalMethod.equals(TraversalMethod.INORDER)) {
            return inorder();
        } else {
            return result;
        }
    }

    // inorder traversal algorithm
    public Iterable<Position<E>> inorder() {
        List<Position<E>> snapshot = new ArrayList<>();
        if (!isEmpty()) {
            inorderSubtree(root(), snapshot);
        }
        return snapshot;
    }

    private void inorderSubtree(Position<E> position, List<Position<E>> snapshot) {
        if (left(position) != null) {
            inorderSubtree(left(position), snapshot);
        }
        snapshot.add(position);
        if (right(position) != null) {
            inorderSubtree(right(position), snapshot);
        }
    }
}
