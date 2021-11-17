package com.interview.basic.algorithms.linkedlist;

/**
 * 19. Remove Nth Node From End of List
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 */
public class RemoveNthNodeFromEndList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null) return null;
        ListNode slow = head;
        ListNode fast = head;
        // make fast has n gap with slow
        while (n > 0) {
            fast = fast.next;
            n--;
        }

        // edge case: if fast is null after n jump, it means it's the first element that needs to be removed
        // if we don't want to handle this edge case specifically, we can create a node to be the new head
        // ==> ListNode start = new ListNode(0); start.next = head; ListNode slow = start, fast = start;
        if (fast == null) {
            head = head.next;
            return head;
        }

        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;
        return head;
    }
}
