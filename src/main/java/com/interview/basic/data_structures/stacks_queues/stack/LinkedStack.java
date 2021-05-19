package com.interview.basic.data_structures.stacks_queues.stack;

import com.interview.basic.data_structures.linked_lists.SinglyLinkedList;

public class LinkedStack<E> implements Stack<E>{
    private SinglyLinkedList<E> linkedList;

    public LinkedStack() {
        linkedList = new SinglyLinkedList<>();
    }

    @Override
    public int size() {
        return linkedList.size();
    }

    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    @Override
    public void push(E e) {
        linkedList.addFirst(e);
    }

    @Override
    public E top() {
        return linkedList.first();
    }

    @Override
    public E pop() {
        return linkedList.removeFirst();
    }

    @Override
    public String toString() {
        return linkedList.toString();
    }
}
