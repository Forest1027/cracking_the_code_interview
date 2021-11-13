package com.interview.basic.algorithms.binarysearch;

/**
 * 153. Find Minimum in Rotated Sorted Array
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
 */
public class FindMinimumRotatedSortedArray {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        int min = Integer.MAX_VALUE;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] < nums[low]) {
                // right is sorted
                if (nums[mid] < min) min = nums[mid];
                high = mid - 1;
            } else if (nums[mid] > nums[high]) {
                // left is sorted
                if (nums[high] < min) min = nums[high];
                low = mid + 1;
            } else {
                // all sorted
                if (nums[low] < min) min = nums[low];
                high = mid - 1;
            }
        }
        return min;
    }
}
