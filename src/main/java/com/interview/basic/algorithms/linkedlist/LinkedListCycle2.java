package com.interview.basic.algorithms.linkedlist;

import java.util.HashSet;
import java.util.Set;

/**
 * 142. Linked List Cycle II
 * https://leetcode.com/problems/linked-list-cycle-ii/
 */
public class LinkedListCycle2 {
    /**
     * Time complexity: O(n)
     * Space complexity: O(1)
     * Floyd’s Cycle Detection Algorithm
     */
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) {
                // cycle detected
                while(slow != head) {
                    slow = slow.next;
                    head = head.next;
                }
                return  head;
            }
        }
        return null;
    }


    /**
     * Time complexity: O(n)
     * Space complexity: O(n)
     */
    public ListNode detectCycle2(ListNode head) {
        Set<ListNode> visited = new HashSet<>();
        while(head != null) {
            if(!visited.contains(head)) {
                visited.add(head);
                head = head.next;
            }else {
                return head;
            }
        }
        return null;
    }
}
