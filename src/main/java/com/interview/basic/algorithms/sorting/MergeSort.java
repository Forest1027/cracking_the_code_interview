package com.interview.basic.algorithms.sorting;

import java.util.Arrays;

public class MergeSort {
    public static void sort(int[] K) {
        int length = K.length;
        if (length < 2) {
            return;
        }
        // divide
        int mid = length / 2;
        int[] K1 = Arrays.copyOfRange(K, 0, mid);
        int[] K2 = Arrays.copyOfRange(K, mid, length);
        // conquer
        sort(K1);
        sort(K2);
        // merge
        merge(K, K1, K2);
    }

    private static void merge(int[] K, int[] K1, int[] K2) {
        int i = 0;
        int j = 0;
        while (i + j < K.length) {
            if (j == K2.length || (i < K1.length && K1[i] < K2[j])) {
                K[i + j] = K1[i++];
            } else {
                K[i + j] = K2[j++];
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5, 1, 2, 9, 56, 3, 4};
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
