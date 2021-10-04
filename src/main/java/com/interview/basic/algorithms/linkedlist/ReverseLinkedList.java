package com.interview.basic.algorithms.linkedlist;

import java.util.Stack;

/**
 * 92. Reverse Linked List II
 * https://leetcode.com/problems/reverse-linked-list-ii/
 */
public class ReverseLinkedList {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode result = new ListNode();
        Stack<Integer> stack = new Stack<>();
        boolean willContinue = true;
        ListNode temp = result;
        int position = 1;
        while (head != null) {
            if (position == left) {
                willContinue = false;
            }
            if (willContinue) {
                temp = temp.next = new ListNode(head.val);
                head = head.next;
            } else {
                int value = head.val;
                stack.push(value);
                head = head.next;
                if (position == right) {
                    break;
                }
            }
            position++;
        }
        while (!stack.isEmpty()) {
            temp.next = new ListNode(stack.pop());
            temp = temp.next;
        }
        while (head != null) {
            temp.next = new ListNode(head.val);
            temp = temp.next;
            head = head.next;
        }

        return result.next;
    }

    public static void main(String[] args) {
      /*  ListNode head = new ListNode(1);
        ListNode n2 = head.next = new ListNode(2);
        ListNode n3 = n2.next = new ListNode(3);
        ListNode n4 = n3.next = new ListNode(4);
        ListNode n5 = n4.next = new ListNode(5);*/
        ListNode head = new ListNode(5);
        ReverseLinkedList solution = new ReverseLinkedList();
        ListNode listNode = solution.reverseBetween(head, 1, 1);
        System.out.println(listNode);
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}
