package com.interview.basic.data_structures.trees_tries_graphs.tree.binarytree;

import com.interview.basic.data_structures.trees_tries_graphs.Position;
import com.interview.basic.data_structures.trees_tries_graphs.tree.AbstractTree;

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
        children.add(left(p));
        children.add(right(p));
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
}
