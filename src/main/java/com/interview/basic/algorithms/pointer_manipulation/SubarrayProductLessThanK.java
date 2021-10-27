package com.interview.basic.algorithms.pointer_manipulation;

/**
 * 713. Subarray Product Less Than K
 * https://leetcode.com/problems/subarray-product-less-than-k/
 */
public class SubarrayProductLessThanK {
    /**
     * Time complexity: O(n)
     */
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0;
        int prod = 1, result = 0, left = 0;
        for (int right = 0; right < nums.length; right++) {
            prod *= nums[right];
            while (prod >= k) prod /= nums[left++];
            result += right - left + 1;
        }
        return result;
    }

    /**
     * Time complexity: O(n2)
     */
    public int numSubarrayProductLessThanK_2(int[] nums, int k) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            int product = nums[i];
            if (product < k) {
                result++;
                for (int j = i + 1; j < nums.length; j++) {
                    product *= nums[j];
                    if (product < k) result++;
                    else break;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{10, 5, 2, 6};
        SubarrayProductLessThanK sol = new SubarrayProductLessThanK();
        int result = sol.numSubarrayProductLessThanK(nums, 100);
        System.out.println(result);
    }
}
