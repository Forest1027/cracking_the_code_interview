package com.interview.basic.data_structures.trees_tries_graphs.tree;

import com.interview.basic.data_structures.stacks_queues.queue.LinkedQueue;
import com.interview.basic.data_structures.stacks_queues.queue.Queue;
import com.interview.basic.data_structures.trees_tries_graphs.Position;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class AbstractTree<E> implements Tree<E> {
    protected TraversalMethod traversalMethod = TraversalMethod.PREORDER;

    public void setTraversalMethod(TraversalMethod traversalMethod) {
        this.traversalMethod = traversalMethod;
    }

    @Override
    public Iterator<E> iterator() {
        return new ElementIterator();
    }

    @Override
    public Iterable<Position<E>> positions() {
        switch (traversalMethod) {
            case PREORDER:
                return preorder();
            case POSTORDER:
                return postorder();
            case BREADTH_FIRST:
                return breadthfirst();
            default:
                return null;
        }
    }

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

    // traversal algorithm implementations for child class to call
    // preorder traversal
    public Iterable<Position<E>> preorder() {
        List<Position<E>> snapshot = new ArrayList<>();
        if (!isEmpty()) {
            preorderSubtree(root(), snapshot);
        }
        return snapshot;
    }

    private void preorderSubtree(Position<E> p, List<Position<E>> snapshot) {
        snapshot.add(p);
        for (Position<E> child : children(p)) {
            preorderSubtree(child, snapshot);
        }
    }

    // postorder traversal
    public Iterable<Position<E>> postorder() {
        List<Position<E>> snapshot = new ArrayList<>();
        if (!isEmpty()) {
            postorderSubtree(root(), snapshot);
        }
        return snapshot;
    }

    private void postorderSubtree(Position<E> p, List<Position<E>> snapshot) {
        for (Position<E> child : children(p)) {
            postorderSubtree(child, snapshot);
        }
        snapshot.add(p);
    }

    public Iterable<Position<E>> breadthfirst() {
        List<Position<E>> snapshot = new ArrayList<>();
        if (!isEmpty()) {
            Queue<Position<E>> queue = new LinkedQueue<>();
            queue.enqueue(root());
            while (!queue.isEmpty()) {
                Position<E> position = queue.dequeue();
                snapshot.add(position);
                for (Position<E> child : children(position)) {
                    queue.enqueue(child);
                }
            }
        }
        return snapshot;
    }

    // nested ElementIterator class
    private class ElementIterator implements Iterator<E> {
        Iterator<Position<E>> positionIterator = positions().iterator();

        @Override
        public boolean hasNext() {
            return positionIterator.hasNext();
        }

        @Override
        public E next() {
            return positionIterator.next().getElement();
        }

        @Override
        public void remove() {
            positionIterator.remove();
        }
    }
}
