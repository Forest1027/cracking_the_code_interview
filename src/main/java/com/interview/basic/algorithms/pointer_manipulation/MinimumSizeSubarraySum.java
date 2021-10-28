package com.interview.basic.algorithms.pointer_manipulation;

/**
 * 209. Minimum Size Subarray Sum
 * https://leetcode.com/problems/minimum-size-subarray-sum/
 */
public class MinimumSizeSubarraySum {
    /**
     * Neater solution with while loop
     * Time complexity: O(n)
     */
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int ans = Integer.MAX_VALUE;
        int left = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            while (sum >= target) {
                ans = Math.min(ans, i + 1 - left);
                sum -= nums[left++];
            }
        }
        return (ans != Integer.MAX_VALUE) ? ans : 0;
    }

    /**
     * Time complexity: O(n)
     */
    public int minSubArrayLen2(int target, int[] nums) {
        int left = 0;
        int sum = 0;
        int right = 0;
        int result = 0;
        while (right < nums.length && left < nums.length) {
            if (sum < target) {
                sum += nums[right];
            } else{
                result = result == 0 ? (right - left + 1) : Math.min(result, right - left + 1);
                sum -= nums[left];
                left++;
            }
            if (sum < target) right++;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1, 1, 1, 1, 1, 1};
        MinimumSizeSubarraySum sol = new MinimumSizeSubarraySum();
        int result = sol.minSubArrayLen(11, nums);
        System.out.println(result);
    }
}
