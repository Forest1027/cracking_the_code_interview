package com.interview.basic.data_structures.linked_lists;

public class DoublyLinkedList<E> {
    private Node<E> header;
    private Node<E> trailer;
    private int size;

    public DoublyLinkedList() {
        header = new Node<>(null, null, null);
        trailer = new Node<>(null, header, null);
        header.next = trailer;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E first() {
        return header.next.element;
    }

    public E last() {
        return trailer.prev.element;
    }

    public void addFirst(E element) {
        if (element == null) {
            throw new RuntimeException("Value cannot be null.");
        }
        addBetween(element, header, header.next);
    }

    public void addLast(E element) {
        if (element == null) {
            throw new RuntimeException("Value cannot be null.");
        }
        addBetween(element, trailer.prev, trailer);
    }

    public E removeFirst() {
        if (isEmpty()) {
            throw new RuntimeException("List is empty.");
        }
        return remove(header.next);
    }

    public E removeLast() {
        if (isEmpty()) {
            throw new RuntimeException("List is empty.");
        }
        return remove(trailer.prev);
    }

    private void addBetween(E e, Node<E> predecessor, Node<E> successor) {
        Node<E> node = new Node<>(e, predecessor, successor);
        successor.prev = node;
        predecessor.next = node;
        size++;
    }

    private E remove(Node<E> node) {
        Node<E> prev = node.prev;
        Node<E> next = node.next;
        prev.next = next;
        next.prev = prev;
        E result = node.element;
        node = null;
        size--;
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node<E> node = header.next;
        while (node != trailer) {
            sb.append(node.element);
            if (node.next != trailer) {
                sb.append(",");
            }
            node = node.next;
        }
        sb.append("]");
        return sb.toString();
    }

    private class Node<E> {
        private E element;
        private Node<E> next;
        private Node<E> prev;

        public Node(E element, Node<E> prev, Node<E> next) {
            this.element = element;
            this.next = next;
            this.prev = prev;
        }
    }
}
