package com.interview.basic.data_structures.stacks_queues.stack;

public interface Stack<E> {
    /**
     * Returns the number of elements in the stack
     * @return the number of elements in the stack
     */
    int size();

    /**
     * Tests whether stack is empty
     * @return if stack is empty
     */
    boolean isEmpty();

    /**
     * Inserts an element at the top of the stack
     * @param e element to be inserted
     */
    void push(E e);

    /**
     * Returns but does not remove the element at the top of the stack
     * @return element at top
     */
    E top();

    /**
     * Removes and returns the top element from the stack
     * @return element that is removed
     */
    E pop();
}
