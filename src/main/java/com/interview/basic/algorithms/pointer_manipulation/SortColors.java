package com.interview.basic.algorithms.pointer_manipulation;

import java.util.Arrays;

/**
 * 75. Sort Colors
 * https://leetcode.com/problems/sort-colors/
 */
public class SortColors {
    /**
     * TC: O(n)
     * SC: O(1)
     */
    public void sortColors(int[] nums) {
        int zeroIdx = 0;
        int twoIdx = nums.length - 1;
        int i = 0;
        while (i <= twoIdx) {
            if (nums[i] == 0) {
                // swap
                nums[i] = nums[zeroIdx];
                nums[zeroIdx] = 0;
                i++;
                zeroIdx++;
            } else if (nums[i] == 2) {
                // swap
                nums[i] = nums[twoIdx];
                nums[twoIdx] = 2;
                twoIdx--;
            } else {
                i++;
            }
        }
    }

    /**
     * TC: O(nlogn)
     * SC: O(n)
     */
    public void sortColors2(int[] nums) {
        mergeSort(nums);
    }

    private void mergeSort(int[] nums) {
        int size = nums.length;
        if (size < 2) return;
        // divide
        int mid = size / 2;
        int[] arr1 = Arrays.copyOfRange(nums, 0, mid);
        int[] arr2 = Arrays.copyOfRange(nums, mid, size);
        // conquer
        mergeSort(arr1);
        mergeSort(arr2);
        // merge
        mergeUtil(nums, arr1, arr2);
    }

    private void mergeUtil(int[] nums, int[] arr1, int[] arr2) {
        int i = 0;
        int j = 0;
        while (i + j < nums.length) {
            if (j == arr2.length || (i < arr1.length && arr1[i] <= arr2[j])) {
                nums[i + j] = arr1[i];
                i++;
            } else {
                nums[i + j] = arr2[j];
                j++;
            }
        }
    }
}
