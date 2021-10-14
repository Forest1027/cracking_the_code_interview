package com.interview.basic.algorithms.data_structures;


/**
 * 23. Merge k Sorted Lists
 * https://leetcode.com/problems/merge-k-sorted-lists/
 */
public class MergeKSortedList {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        if (lists.length == 1) return lists[0];
        ListNode head = new ListNode();
        ListNode tmp = head;
        int size = 0;
        ListNode tail = null;
        for (ListNode ele : lists) {
            if (ele != null) {
                if (tail != null) {
                    tail.next = ele;
                }
                while (ele != null) {
                    tmp.next = new ListNode(ele.val);
                    tmp = tmp.next;
                    ele = ele.next;
                    size++;
                }
                tail = tmp;
            }
        }
        if (size < 2) return head.next;
        return mergeSort(head.next);
    }

    private ListNode mergeSort(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode mid = getMid(head);
        ListNode left = mergeSort(head);
        ListNode right = mergeSort(mid);
        return merge(left, right);
    }

    private ListNode merge(ListNode left, ListNode right) {
        ListNode result, tmp;
        result = tmp = new ListNode();
        while (left != null || right != null) {
            tmp.next = new ListNode();
            tmp = tmp.next;
            if (right == null || (left != null && left.val < right.val)) {
                tmp.val = left.val;
                left = left.next;
            } else {
                tmp.val = right.val;
                right = right.next;
            }
        }
        return result.next;
    }

    private ListNode getMid(ListNode head) {
        ListNode tmp = null;
        while (head != null && head.next != null) {
            tmp = tmp == null ? head : tmp.next;
            head = head.next.next;
        }

        ListNode mid = tmp.next;
        tmp.next = null;
        return mid;
    }

    public static void main(String[] args) {
        //[[1,4,5],[1,3,4],[2,6]]
        ListNode h1 = new ListNode(1);
        ListNode h2 = new ListNode(4);
        ListNode h3 = new ListNode(5);
        h1.next = h2;
        h2.next = h3;

        ListNode t1 = new ListNode(1);
        ListNode t2 = new ListNode(3);
        ListNode t3 = new ListNode(4);
        t1.next = t2;
        t2.next = t3;

        ListNode m1 = new ListNode(2);
        ListNode m2 = new ListNode(6);
        m1.next = m2;
        ListNode[] listNodes = {h1, t1, m1};
//        ListNode[] listNodes = {null, new ListNode(1)};
        MergeKSortedList sol = new MergeKSortedList();
        ListNode listNode = sol.mergeKLists(listNodes);
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

