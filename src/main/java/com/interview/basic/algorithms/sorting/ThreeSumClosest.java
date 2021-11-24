package com.interview.basic.algorithms.sorting;

import java.util.Arrays;

/**
 * 16. 3Sum Closest
 * https://leetcode.com/problems/3sum-closest/
 */
public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        if (n == 3) return nums[0] + nums[1] + nums[2];
        int closest = Integer.MAX_VALUE;
        int result = 0;
        for (int i = 0; i < n - 2; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                int low = i + 1;
                int high = n - 1;
                int sum = target - nums[i];
                while (low < high) {
                    if (Math.abs(nums[low] + nums[high] + nums[i] - target) < closest) {
                        closest = Math.abs(nums[low] + nums[high] + nums[i] - target);
                        result = nums[low] + nums[high] + nums[i];
                    }
                    if (nums[low] + nums[high] == sum) return target;
                    else if (nums[low] + nums[high] < sum) low++;
                    else high--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        /**
         * [0,2,1,-3]
         * 1
         *
         * [1,2,4,8,16,32,64,128]
         * 82
         */
        int[] nums = {1,2,4,8,16,32,64,128};
        ThreeSumClosest sol = new ThreeSumClosest();
        int res = sol.threeSumClosest(nums, 82);
        System.out.println(res);
    }
}
