package com.interview.basic.algorithms.binarysearch;

/**
 * 162. Find Peak Element
 * https://leetcode.com/problems/find-peak-element/
 */
public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        return peakFinder(nums, 0, nums.length - 1);
    }

    private int peakFinder(int[] nums, int start, int end) {
        if (start == end) {
            return start;
        }
        int mid = (start + end) / 2;
        if (nums[mid + 1] < nums[mid]) {
            return peakFinder(nums, start, mid);
        } else {
            return peakFinder(nums, mid + 1, end);
        }
    }

    public static void main(String[] args) {
        var nums = new int[]{-1, 2, 3, 1};
        FindPeakElement sol = new FindPeakElement();
        int result = sol.findPeakElement(nums);
        System.out.println(result);
    }
}
