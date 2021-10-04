package com.interview.basic.algorithms.linkedlist;

/**
 * 237. Delete Node in a Linked List
 * https://leetcode.com/problems/delete-node-in-a-linked-list/
 */
public class DeleteNode {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        ListNode n2 = head.next = new ListNode(5);
        ListNode n3 = n2.next = new ListNode(1);
        ListNode n4 = n3.next = new ListNode(9);
        System.out.println(head);
        DeleteNode sol = new DeleteNode();
        sol.deleteNode(n2);
        System.out.println(head);
    }
}
