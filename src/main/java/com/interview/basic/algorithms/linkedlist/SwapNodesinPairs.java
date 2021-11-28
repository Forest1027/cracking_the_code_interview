package com.interview.basic.algorithms.linkedlist;

/**
 * 24. Swap Nodes in Pairs
 * https://leetcode.com/problems/swap-nodes-in-pairs/
 */
public class SwapNodesinPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode current = new ListNode(-1, head);
        ListNode track = current;
        while (current != null && current.next != null && current.next.next != null) {
            ListNode n1 = current.next;
            ListNode n2 = n1.next;
            n1.next = n2.next;
            n2.next = n1;
            current.next = n2;
            current = current.next.next;
        }
        return track.next;
    }
}
