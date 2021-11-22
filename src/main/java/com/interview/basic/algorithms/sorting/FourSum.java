package com.interview.basic.algorithms.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 18. 4Sum
 * https://leetcode.com/problems/4sum/
 */
public class FourSum {
    /**
     * TC: O(n^3)
     * SC: O(n)
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return kSum(nums, target, 0, 4);
    }

    private List<List<Integer>> kSum(int[] nums, int target, int start, int k) {
        List<List<Integer>> res = new LinkedList<>();
        if (start == nums.length) {
            return res;
        }
        int avgVal = target / k;
        if (nums[start] > avgVal || nums[nums.length - 1] < avgVal) {
            return res;
        }

        if (k == 2) {
            return twoSum(nums, target, start);
        }

        for (int i = start; i < nums.length; i++) {
            if (i == start || nums[i - 1] != nums[i]) {
                for (List<Integer> subset : kSum(nums, target - nums[i], i + 1, k - 1)) {
                    res.add(new ArrayList<>(Arrays.asList(nums[i])));
                    res.get(res.size() - 1).addAll(subset);
                }
            }
        }
        return res;
    }

    private List<List<Integer>> twoSum(int[] nums, int target, int start) {
        List<List<Integer>> res = new LinkedList<>();
        int low = start;
        int high = nums.length - 1;
        while (low < high) {
            int curSum = nums[low] + nums[high];
            if (curSum > target || (high < nums.length - 1 && nums[high] == nums[high + 1])) {
                high--;
            } else if (curSum < target || (low > start && nums[low] == nums[low - 1])) {
                low++;
            } else {
                res.add(Arrays.asList(nums[low++], nums[high--]));
            }
        }
        return res;
    }
}
