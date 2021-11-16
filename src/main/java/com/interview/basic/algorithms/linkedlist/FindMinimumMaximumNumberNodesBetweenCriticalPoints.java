package com.interview.basic.algorithms.linkedlist;

import java.util.Arrays;

/**
 * 2058. Find the Minimum and Maximum Number of Nodes Between Critical Points
 * https://leetcode.com/problems/find-the-minimum-and-maximum-number-of-nodes-between-critical-points/
 */
public class FindMinimumMaximumNumberNodesBetweenCriticalPoints {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) return new int[]{-1, -1};
        ListNode prev = head;
        ListNode current = head.next;
        ListNode next = current.next;
        int index = 0;
        int minIdx = Integer.MAX_VALUE;
        int lastIdx = -1;
        int currIdx = -1;
        int min = Integer.MAX_VALUE;
        while (next != null) {
            index++;
            if ((prev.val > current.val && current.val < next.val) ||
                    (prev.val < current.val && current.val > next.val)) {
                if (index < minIdx) minIdx = index;
                lastIdx = currIdx;
                currIdx = index;
                if (lastIdx != -1 && currIdx - lastIdx < min) min = currIdx - lastIdx;
            }


            prev = prev.next;
            current = current.next;
            next = next.next;
        }
        if (lastIdx == -1) return new int[]{-1, -1};
        return new int[]{min, currIdx - minIdx};
    }

    public static void main(String[] args) {
        // [1,3,2,2,3,2,2,2,7]
        // [2,2,1,3]
        // [5,3,1,2,5,1,2]
        ListNode n1 = new ListNode(5);
        ListNode n2 = new ListNode(3);
        ListNode n3 = new ListNode(1);
        ListNode n4 = new ListNode(2);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(1);
        ListNode n7 = new ListNode(2);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        FindMinimumMaximumNumberNodesBetweenCriticalPoints sol = new FindMinimumMaximumNumberNodesBetweenCriticalPoints();
        int[] ints = sol.nodesBetweenCriticalPoints(n1);
        System.out.println(Arrays.toString(ints));
    }
}
