package com.interview.basic.data_structures.trees_tries_graphs.tree.binarytree;

import com.interview.basic.data_structures.trees_tries_graphs.Position;
import com.interview.basic.data_structures.trees_tries_graphs.tree.Tree;

public interface BinaryTree<E> extends Tree<E> {
    Position<E> left(Position<E> p) throws IllegalArgumentException;

    Position<E> right(Position<E> p) throws  IllegalArgumentException;

    Position<E> sibling(Position<E> p) throws IllegalArgumentException;
}
