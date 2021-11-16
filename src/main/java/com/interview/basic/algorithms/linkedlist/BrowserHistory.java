package com.interview.basic.algorithms.linkedlist;

/**
 * 1472. Design Browser History
 * https://leetcode.com/problems/design-browser-history/
 */
public class BrowserHistory {
    private ListNode current;

    public BrowserHistory(String homepage) {
        this.current = new ListNode(homepage, null, null);
    }

    public void visit(String url) {
        ListNode newNode = new ListNode(url, current, null);
        current.next = newNode;
        current = newNode;
    }

    public String back(int steps) {
        while (this.current.prev != null && steps > 0) {
            current = current.prev;
            steps--;
        }
        return current.val;
    }

    public String forward(int steps) {
        while (this.current.next != null && steps > 0) {
            current = current.next;
            steps--;
        }
        return current.val;
    }

    private class ListNode {
        String val;
        ListNode next;
        ListNode prev;

        public ListNode(String val, ListNode prev, ListNode next) {
            this.val = val;
            this.next = next;
            this.prev = prev;
        }
    }

    public static void main(String[] args) {
        BrowserHistory history = new BrowserHistory("leetcode.com");
        history.visit("google.com");
        history.visit("facebook.com");
        history.visit("youtube.com");
        System.out.println(history.back(1));
        System.out.println(history.back(1));
        System.out.println(history.forward(1));
        history.visit("linkedin.com");
        System.out.println(history.forward(2));
        System.out.println(history.back(2));
        System.out.println(history.back(7));
    }
}
