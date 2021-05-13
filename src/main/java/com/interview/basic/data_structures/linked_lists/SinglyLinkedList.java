package com.interview.basic.data_structures.linked_lists;

public class SinglyLinkedList<E> {
    private Node<E> head;
    private Node<E> tail;
    private int size;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public Node<E> first() {
        return head;
    }

    public Node<E> last() {
        return tail;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node<E> element = head;
        while (element != null) {
            if (element == tail) {
                sb.append(element.value);
            } else {
                sb.append(element.value + ",");
            }
            element = element.next;
        }
        sb.append("]");
        return sb.toString();
    }

    public void addFirst(E value) {
        if (value == null) {
            throw new RuntimeException("Value cannot be null.");
        }
        Node<E> node = new Node<>(null, value);
        if (isEmpty()) {
            head = tail = node;
        } else {
            Node<E> oldHead = head;
            head = node;
            head.next = oldHead;
        }
        size++;
    }

    public void addLast(E value) {
        if (value == null) {
            throw new RuntimeException("Value cannot be null.");
        }
        Node<E> node = new Node<>(null, value);
        if (isEmpty()) {
            head = tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
        size++;
    }

    public Node<E> removeFirst() {
        if (isEmpty()) {
            throw new RuntimeException("List is empty.");
        }
        Node<E> result = head;
        head = head.next;
        size--;
        return result;
    }

    private class Node<E> {
        Node<E> next;
        E value;

        public Node(Node<E> next, E value) {
            this.next = next;
            this.value = value;
        }
    }
}
