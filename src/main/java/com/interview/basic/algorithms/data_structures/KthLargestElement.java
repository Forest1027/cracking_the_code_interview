package com.interview.basic.algorithms.data_structures;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * 215. Kth Largest Element in an Array
 * https://leetcode.com/problems/kth-largest-element-in-an-array/
 */
public class KthLargestElement {
    /**
     * Priority queue
     */
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int num : nums
        ) {
            pq.add(num);
        }
        int result = Integer.MIN_VALUE;
        while (k > 0) {
            result = pq.poll();
            k--;
        }
        return result;
    }

    public int findKthLargestMergeSort(int[] nums, int k) {
        mergeSort(nums);
        return nums[k - 1];
    }

    private void mergeSort(int[] nums) {
        int size = nums.length;
        if (size < 2) return;
        int mid = size / 2;
        int[] K1 = Arrays.copyOfRange(nums, 0, mid);
        int[] K2 = Arrays.copyOfRange(nums, mid, size);
        mergeSort(K1);
        mergeSort(K2);
        mergeUtil(nums, K1, K2);
    }

    private void mergeUtil(int[] nums, int[] k1, int[] k2) {
        int i = 0;
        int j = 0;
        while (i + j < nums.length) {
            if (j == k2.length || (i < k1.length && k1[i] > k2[j])) {
                nums[i + j] = k1[i];
                i++;
            } else {
                nums[i + j] = k2[j];
                j++;
            }
        }
    }
}
