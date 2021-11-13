package com.interview.basic.algorithms.binarysearch;

/**
 * 154. Find Minimum in Rotated Sorted Array II
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/
 */
public class FindMinimumRotatedSortedArray2 {
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
            } else if (nums[mid] < nums[high] && nums[mid] > nums[low]) {
                if (nums[low] < min) min = nums[low];
                high = mid - 1;
            } else {
                // nums[mid] can be equal to nums[low] and nums[high]
                // have to compare one by one in this case
                if (nums[low] < min) min = nums[low];
                low++;
            }
        }
        return min;
    }
}
