package com.interview.basic.algorithms.binarysearch;

/**
 * 81. Search in Rotated Sorted Array II
 * https://leetcode.com/problems/search-in-rotated-sorted-array-ii/
 */
public class SearchRotatedSortedArray {
    public boolean search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (target == nums[mid]) return true;
            if (nums[mid] < nums[low]) {
                // right is sorted
                if (target > nums[mid] && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            } else if (nums[mid] > nums[low]) {
                // left is sorted
                if (target < nums[mid] && target >= nums[low]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                low++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // [1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1]
        // [1,1,1,1,1,1,1,1,1,13,1,1,1,1,1,1,1,1,1,1,1,1]
        // 13
        int[] nums = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 13, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        SearchRotatedSortedArray sol = new SearchRotatedSortedArray();
        System.out.println(sol.search(nums, 13));
    }
}
