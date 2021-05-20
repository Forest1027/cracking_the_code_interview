package com.interview.basic.data_structures.stacks_queues.queue;

import com.interview.basic.data_structures.linked_lists.SinglyLinkedList;

public class LinkedQueue<E> implements Queue<E>{
    private SinglyLinkedList<E> linkedList;

    public LinkedQueue() {
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
    public void enqueue(E e) {
        linkedList.addLast(e);
    }

    @Override
    public E first() {
        return linkedList.first();
    }

    @Override
    public E dequeue() {
        return linkedList.removeFirst();
    }

    @Override
    public String toString() {
        return linkedList.toString();
    }
}
