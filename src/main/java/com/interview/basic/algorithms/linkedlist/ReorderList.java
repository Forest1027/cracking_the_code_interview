package com.interview.basic.algorithms.linkedlist;

/**
 * 143. Reorder List
 * https://leetcode.com/problems/reorder-list/
 */
public class ReorderList {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {return;}
        ListNode l1 = head;
        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        ListNode l2 = reverse(slow);
        merge(l1, l2);
    }

    private ListNode reverse(ListNode head) {
        ListNode current = head;
        ListNode prev = null;
        while (current != null) {
            ListNode temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }
        return prev;
    }

    private void merge(ListNode l1, ListNode l2) {
        while (l1 != null) {
            ListNode temp1 = l1.next;
            l1.next = l2;
            ListNode temp2 = l2.next;
            if (temp1 == null) {
                break;
            }
            l2.next = temp1;
            l1 = temp1;
            l2 = temp2;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode n2 = head.next = new ListNode(2);
        ListNode n3 = n2.next = new ListNode(3);
        ListNode n4 = n3.next = new ListNode(4);
        ListNode n5 = n4.next = new ListNode(5);
        ReorderList sol = new ReorderList();
        sol.reorderList(head);
        System.out.println(head);
    }
}
