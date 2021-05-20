package com.interview.basic.data_structures.stacks_queues.queue;

public interface Queue<E> {
    int size();

    boolean isEmpty();

    void enqueue(E e);

    E first();

    E dequeue();
}
