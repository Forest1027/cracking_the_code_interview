package com.interview.basic.algorithms.data_structures;

import java.util.HashMap;
import java.util.Map;

/**
 * 560. Subarray Sum Equals K
 * https://leetcode.com/problems/subarray-sum-equals-k/
 */
public class SubarraySumEqualsK {
    /**
     * TC: O(n)
     * SC: O(n)
     */
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int count = 0;
        int sum = 0;
        for (int ele : nums) {
            sum += ele;
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    /**
     * TC: O(n^2)
     * SC: O(n)
     */
    public int subarraySum2(int[] nums, int k) {
        int[] sums = new int[nums.length + 1];
        sums[0] = 0;
        for (int i = 1; i <= nums.length; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }
        int count = 0;

        for (int i = 0; i < sums.length; i++) {
            for (int j = i + 1; j < sums.length; j++) {
                if (sums[j] - sums[i] == k) count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        // nums = [1,1,1], k = 2
        // [1] 0
        // [-1,-1,1] 0
        int[] nums = new int[]{1, 1, 1};
        SubarraySumEqualsK sol = new SubarraySumEqualsK();
        System.out.println(sol.subarraySum(nums, 2));
    }
}
