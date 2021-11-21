package com.interview.basic.algorithms.sorting;

/**
 * 167. Two Sum II - Input Array Is Sorted
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
 */
public class TwoSum2 {
    /**
     * two pointers
     * TC: O(n)
     * SC: O(1)
     */
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while(numbers[left] + numbers[right] != target){
            if(numbers[left] + numbers[right] > target) right--;
            else left++;
            if(left >= right) return new int[2];
        }
        return new int[]{left+1, right+1};
    }

    /**
     * TC: O(n^2)
     * SC: O(1)
     */
    public int[] twoSum2(int[] numbers, int target) {
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                int current = numbers[i] + numbers[j];
                if (current > target) break;
                if (current == target) {
                    return new int[]{i + 1, j + 1};
                }
            }
        }
        return null;
    }
}
