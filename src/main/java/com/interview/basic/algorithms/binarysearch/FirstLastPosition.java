package com.interview.basic.algorithms.binarysearch;

import java.util.Arrays;

/**
 * 34. Find First and Last Position of Element in Sorted Array
 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 */
public class FirstLastPosition {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{Integer.MAX_VALUE, -1};
        searchUtil(nums, target, 0, nums.length - 1, result);
        if (result[0] == Integer.MAX_VALUE) {
            result[0] = -1;
        }
        return result;
    }

    private void searchUtil(int[] nums, int target, int low, int high, int[] result) {
        if (low > high) {
            return;
        }
        int mid = (low + high) / 2;
        int value = nums[mid];
        if (value < target) {
            searchUtil(nums, target, mid + 1, high, result);
        } else if (value > target) {
            searchUtil(nums, target, low, mid - 1, result);
        } else {
            if (result[0] > mid) result[0] = mid;
            if (result[1] < mid) result[1] = mid;
            searchUtil(nums, target, mid + 1, high, result);
            searchUtil(nums, target, low, mid - 1, result);
        }
    }

    public static void main(String[] args) {
//        int[] nums = new int[]{5, 7, 7, 8, 8, 10};
        int[] nums = new int[0];
        FirstLastPosition solution = new FirstLastPosition();
        int[] result = solution.searchRange(nums, 8);
        System.out.println(result[0] + ", " + result[1]);
    }
}
