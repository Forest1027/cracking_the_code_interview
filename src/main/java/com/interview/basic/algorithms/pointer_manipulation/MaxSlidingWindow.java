package com.interview.basic.algorithms.pointer_manipulation;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 239. Sliding Window Maximum
 * https://leetcode.com/problems/sliding-window-maximum/
 */
public class MaxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k <= 0) {
            throw new IllegalArgumentException("Input is invalid");
        }
        int len = nums.length;
        if (len == 0 || k == 1) {
            return Arrays.copyOf(nums, len);
        }
        if (len <= k) {
            return new int[] { getMaxVal(nums) };
        }

        Deque<Integer> deque = new ArrayDeque<>();
        int[] result = new int[len - k + 1];

        for (int i = 0; i < len; i++) {
            if (!deque.isEmpty() && deque.peekFirst() == i - k) {
                deque.pollFirst();
            }
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }
            deque.offerLast(i);

            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peekFirst()];
            }
        }

        return result;
    }

    private int getMaxVal(int[] nums) {
        int max = nums[0];
        for (int n : nums) {
            max = Math.max(max, n);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {-1,3,-1,-3,5,3,6,7};
        MaxSlidingWindow max = new MaxSlidingWindow();
        int[] result = max.maxSlidingWindow(nums, 3);
        System.out.println(Arrays.toString(result));
    }
}
