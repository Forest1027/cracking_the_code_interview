package com.interview.basic.algorithms.pointer_manipulation;

import java.util.ArrayDeque;
import java.util.Arrays;

/**
 * 239. Sliding Window Maximum
 * https://leetcode.com/problems/sliding-window-maximum/
 */
public class MaxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int size = nums.length - k + 1;
        int[] result = new int[size];
        int pointer = getIndexOfMax(nums, 0, k - 1);
        for (int i = 0; i < size; i++) {
            if (pointer >= i && pointer <= i + k - 1) {
                pointer = compare(nums, i + k - 1, pointer);
            } else {
                pointer = getIndexOfMax(nums, i, i + k - 1);
            }
            result[i] = nums[pointer];
        }
        return result;
    }

    private int compare(int[] nums, int index1, int index2) {
        return nums[index1] > nums[index2] ? index1 : index2;
    }

    private int getIndexOfMax(int[] nums, int start, int end) {
        int p = start;
        int max = nums[p];
        for (int i = start; i <= end; i++) {
            if (nums[i] > max) {
                p = i;
                max = nums[p];
            }
        }
        return p;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {-7,-8,7,5,7,1,6,0};
        MaxSlidingWindow max = new MaxSlidingWindow();
        int[] result = max.maxSlidingWindow(nums, 4);
        System.out.println(Arrays.toString(result));
    }
}
