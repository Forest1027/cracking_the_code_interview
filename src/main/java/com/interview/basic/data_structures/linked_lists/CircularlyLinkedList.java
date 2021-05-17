package com.interview.basic.data_structures.linked_lists;

public class CircularlyLinkedList<E> {

    private Node<E> tail;
    private int size;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void rotate() {
        tail = tail.next;
    }

    public Node<E> first() {
        return tail.next;
    }

    public Node<E> last() {
        return tail;
    }

    public void addFirst(E value) {
        if (value == null) {
            throw new RuntimeException("Value cannot be null.");
        }
        if (tail == null) {
            tail = new Node<>(null, value);
        } else if (size == 1) {
            tail.next = new Node<>(tail, value);
        } else {
            tail.next = new Node<>(tail.next, value);
        }
        size++;
    }

    public void addLast(E value) {
        if (value == null) {
            throw new RuntimeException("Value cannot be null.");
        }
        if (tail == null) {
            tail = new Node<>(null, value);
        } else if (size == 1) {
            Node<E> last = new Node<>(tail, value);
            tail.next = last;
            tail = last;
        } else {
            Node<E> last = new Node<>(tail.next, value);
            tail.next = last;
            tail = last;
        }
        size++;
    }

    public E removeFirst() {
        if (isEmpty()) {
            throw new RuntimeException("List is empty.");
        }
        Node<E> first = tail.next;
        tail.next = first.next;
        size--;
        return first.value;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        if (tail != null) {
            Node<E> element = tail.next;
            while (element != tail) {
                sb.append(element.value);
                sb.append(",");
                element = element.next;
            }
            sb.append(tail.value);
        }
        sb.append("]");
        return sb.toString();
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
