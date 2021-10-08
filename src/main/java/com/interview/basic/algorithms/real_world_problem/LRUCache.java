package com.interview.basic.algorithms.real_world_problem;

import java.util.HashMap;

/**
 * 146. LRU Cache
 * https://leetcode.com/problems/lru-cache/
 */
public class LRUCache {
    private HashMap<Integer, Node> map;
    private int size;
    private Node head;
    private Node tail;
    private int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        tail.prev = head;
        head.next = tail;
    }

    private void moveToHead(Node node) {
        if (node != head.next) {
            Node prev = node.prev;
            Node next = node.next;
            Node newNext = head.next;
            prev.next = next;
            next.prev = prev;
            head.next = node;
            node.prev = head;
            node.next = newNext;
            newNext.prev = node;
        }
    }

    private Node createNewNode(int key, int val) {
        Node node = new Node(key, val);
        Node next = head.next;
        head.next = node;
        node.prev = head;
        next.prev = node;
        node.next = next;
        return node;
    }

    private void removeTail() {
        Node prev = tail.prev;
        tail.prev = prev.prev;
        prev.prev.next = tail;
        map.remove(prev.key);
        prev = null;
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node == null) {
            return -1;
        } else {
            moveToHead(node);
            return node.val;
        }
    }

    public void put(int key, int value) {
        Node node;
        if (!map.containsKey(key)) {
            node = createNewNode(key, value);
            size++;
        }else {
            node = map.get(key);
            node.val = value;
            moveToHead(node);
        }
        if (size > capacity) {
            removeTail();
            size--;
        }

        map.put(key, node);
    }

    private class Node {
        int val;
        int key;
        Node prev;
        Node next;

        public Node(int key, int val) {
            this.val = val;
            this.key = key;
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        System.out.println(cache.get(2));
        cache.put(2, 6);
        System.out.println("null");
        System.out.println(cache.get(1));
        cache.put(1, 5);
        System.out.println("null");
        cache.put(1, 2);
        System.out.println("null");
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));
    }
}
