package com.interview.basic.algorithms.linkedlist;

/**
 * 641. Design Circular Deque
 * https://leetcode.com/problems/design-circular-deque/
 */
public class MyCircularDeque {
    private int capacity;
    private ListNode head;
    private ListNode tail;
    private int size;

    public MyCircularDeque(int k) {
        this.capacity = k;
    }

    public boolean insertFront(int value) {
        if (size >= capacity) return false;
        ListNode newNode = new ListNode(value);
        if (size == 0) {
            head = newNode;
            tail = newNode;
        } else {
            head.prev = newNode;
            newNode.next = head;
            head = newNode;
        }
        size++;
        return true;
    }

    public boolean insertLast(int value) {
        if (size >= capacity) return false;
        ListNode newNode = new ListNode(value);
        if (size == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
        return true;
    }

    public boolean deleteFront() {
        if (size == 0) {
            return false;
        } else if (size == 1) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
        size--;
        return true;
    }

    public boolean deleteLast() {
        if (size == 0) {
            return false;
        } else if (size == 1) {
            head = null;
            tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
        size--;
        return true;
    }

    public int getFront() {
        if (size == 0) return -1;
        return head.val;
    }

    public int getRear() {
        if (size == 0) return -1;
        return tail.val;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    private class ListNode {
        int val;
        ListNode prev, next;

        public ListNode(int val) {
            this.val = val;
            this.prev = null;
            this.next = null;
        }
    }
}
