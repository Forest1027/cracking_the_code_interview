package com.interview.basic.algorithms.sorting;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class QuickSort {
    public static void sort(Queue<Integer> S) {
        int size = S.size();
        if (size < 2) return;
        int pivot = S.peek();
        Queue<Integer> L = new LinkedList<>();
        Queue<Integer> E = new LinkedList<>();
        Queue<Integer> R = new LinkedList<>();
        while (!S.isEmpty()) {
            int element = S.poll();
            if (element < pivot) {
                L.add(element);
            } else if (element > pivot) {
                R.add(element);
            } else {
                E.add(element);
            }
        }
        sort(L);
        sort(R);
        while (!L.isEmpty()) {
            S.add(L.poll());
        }
        while (!E.isEmpty()) {
            S.add(E.poll());
        }
        while (!R.isEmpty()) {
            S.add(R.poll());
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{8, 1, 7, 9, 56, 3, 2};
        Queue<Integer> Q = new LinkedList<>();
        Arrays.stream(nums).forEach(Q::add);
        sort(Q);
        System.out.println(Q);
    }
}
