package com.interview.basic.data_structures.trees_tries_graphs.tree;

import com.interview.basic.data_structures.trees_tries_graphs.Position;

public abstract class AbstractTree<E> implements Tree<E> {
    @Override
    public boolean isInternal(Position<E> p) throws IllegalStateException {
        return numChildren(p) > 0;
    }

    @Override
    public boolean isExternal(Position<E> p) throws IllegalStateException {
        return numChildren(p) == 0;
    }

    @Override
    public boolean isRoot(Position<E> p) throws IllegalStateException {
        return p == root();
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public int height(Position<E> p) {
        int height = 0;
        for (Position<E> c : children(p)) {
            height = Math.max(height, 1 + height(c));
        }
        return height;
    }

    @Override
    public int depth(Position<E> p) {
        if (isRoot(p)) {
            return 0;
        } else {
            return depth(parent(p)) + 1;
        }
    }
}
