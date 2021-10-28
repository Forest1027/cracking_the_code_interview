package com.interview.basic.algorithms.pointer_manipulation;

import java.util.Arrays;

/**
 * 1838. Frequency of the Most Frequent Element
 * https://leetcode.com/problems/frequency-of-the-most-frequent-element/
 */
public class FrequencyMostFrequentElement {
    /**
     * Sliding window
     * Time: O(n)
     */
    public int maxFrequency(int[] nums, int k) {
        if (nums.length <= 1) return nums.length;
        Arrays.sort(nums);
        int left = 0;
        int right = 0;
        int max = 0;
        int sum = 0;
        while (right < nums.length) {
            sum += nums[right];
            while ((right - left + 1) * nums[right] - sum > k) {
                sum -= nums[left];
                left++;
            }
            max = Math.max(max, right - left + 1);
            right++;
        }
        return max;
    }

    /**
     * Brute force
     * Time complexity: O(n2)
     */
    public int maxFrequency2(int[] nums, int k) {
        if (nums.length <= 1) return nums.length;
        Arrays.sort(nums);
        int max = 1;
        for (int i = nums.length - 1; i > 0; i--) {
            int left = k;
            int target = nums[i];
            int j = i - 1;
            int freq = 1;
            while (left > 0 && j >= 0) {
                left = left - (target - nums[j]);
                if (left >= 0) freq++;
                j--;
            }
            max = Math.max(max, freq);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{9930, 9923, 9983, 9997, 9934, 9952, 9945, 9914, 9985, 9982, 9970, 9932, 9985, 9902, 9975, 9990, 9922, 9990, 9994, 9937, 9996, 9964, 9943, 9963, 9911, 9925, 9935, 9945, 9933, 9916, 9930, 9938, 10000, 9916, 9911, 9959, 9957, 9907, 9913, 9916, 9993, 9930, 9975, 9924, 9988, 9923, 9910, 9925, 9977, 9981, 9927, 9930, 9927, 9925, 9923, 9904, 9928, 9928, 9986, 9903, 9985, 9954, 9938, 9911, 9952, 9974, 9926, 9920, 9972, 9983, 9973, 9917, 9995, 9973, 9977, 9947, 9936, 9975, 9954, 9932, 9964, 9972, 9935, 9946, 9966};
        int k = 3056;
        FrequencyMostFrequentElement sol = new FrequencyMostFrequentElement();
        int result = sol.maxFrequency(nums, k);
        System.out.println(result);
    }
}
