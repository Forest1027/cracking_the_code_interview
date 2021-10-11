package com.interview.basic.algorithms.sorting;


import com.interview.basic.data_structures.vectors_arraylists.List;

/**
 * 148. Sort List
 * https://leetcode.com/problems/sort-list/
 */
public class SortList {
    /*
     * Quick sort
     */
    public ListNode sortListQuickSort(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        int pivot = head.val;
        ListNode L, ltmp;
        L = ltmp = new ListNode();
        ListNode E, etmp;
        E = etmp = new ListNode();
        ListNode R, rtmp;
        R = rtmp = new ListNode();
        while (head != null) {
            if (head.val < pivot) {
                ltmp.next = new ListNode(head.val);
                ltmp = ltmp.next;
            } else if (head.val > pivot) {
                rtmp.next = new ListNode(head.val);
                rtmp = rtmp.next;
            } else {
                etmp.next = new ListNode(head.val);
                etmp = etmp.next;
            }
            head = head.next;
        }
        L = sortListQuickSort(L.next);
        R = sortListQuickSort(R.next);
        E = E.next;
        head = new ListNode();
        ListNode temp = head;
        while (L != null) {
            temp.next = new ListNode(L.val);
            temp = temp.next;
            L = L.next;
        }
        while (E != null) {
            temp.next = new ListNode(E.val);
            temp = temp.next;
            E = E.next;
        }
        while (R != null) {
            temp.next = new ListNode(R.val);
            temp = temp.next;
            R = R.next;
        }
        return head.next;
    }

    /*
     * Merge sort
     */
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode mid = getMid(head);
        ListNode left = sortList(head);
        ListNode right = sortList(mid);
        return merge(left, right);
    }

    private ListNode getMid(ListNode head) {
        ListNode midPrev = null;
        while (head != null && head.next != null) {
            midPrev = (midPrev == null) ? head : midPrev.next;
            head = head.next.next;
        }
        ListNode mid = midPrev.next;
        midPrev.next = null;
        return mid;
    }

    private ListNode merge(ListNode left, ListNode right) {
        ListNode result, temp;
        result = temp = new ListNode();
        while (left != null || right != null) {
            temp.next = new ListNode();
            temp = temp.next;
            if (right == null || (left != null && left.val < right.val)) {
                temp.val = left.val;
                left = left.next;
            } else {
                temp.val = right.val;
                right = right.next;
            }
        }
        return result.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        ListNode n2 = head.next = new ListNode(2);
        ListNode n3 = n2.next = new ListNode(1);
        ListNode n4 = n3.next = new ListNode(3);
        SortList sol = new SortList();
        ListNode listNode = sol.sortList(head);
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
