package com.interview.basic.algorithms.sorting;

import java.util.HashMap;
import java.util.Map;

/**
 * 1. Two Sum
 * https://leetcode.com/problems/two-sum/
 */
public class TwoSum {
    /**
     * Hash Table
     * TC: O(n)
     * SC: O(n)
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int index = map.get(nums[i]);
                return new int[]{index, i};
            } else {
                map.put(target - nums[i], i);
            }
        }
        return new int[2];
    }
}
