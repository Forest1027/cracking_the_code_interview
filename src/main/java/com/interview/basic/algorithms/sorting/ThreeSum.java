package com.interview.basic.algorithms.sorting;

import java.util.*;

/**
 * 15. 3Sum
 * https://leetcode.com/problems/3sum/
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<>();
        if (nums.length < 3) return res;
        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || (nums[i] != nums[i - 1])) {
                int lo = i + 1, hi = nums.length - 1, sum = -nums[i];
                while (lo < hi) {
                    if (nums[lo] + nums[hi] == sum) {
                        res.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                        while (lo < hi && nums[lo] == nums[lo + 1]) lo++;
                        while (lo < hi && nums[hi] == nums[hi - 1]) hi--;
                        lo++;
                        hi--;
                    } else if (nums[lo] + nums[hi] < sum) lo++;
                    else hi--;
                }
            }
        }
        return res;
    }

    public List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        if (nums.length < 3) return res;
        Arrays.sort(nums);
        Set<Integer> tracker = new HashSet<>();
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int sum = nums[i] + nums[j];
                if (tracker.contains(-sum)) {
                    List<Integer> triplets = Arrays.asList(nums[i], nums[j], -sum);
                    if (!res.contains(triplets)) res.add(triplets);
                }
            }
            tracker.add(nums[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 0, 0, 0};
        ThreeSum sol = new ThreeSum();
        System.out.println(sol.threeSum(nums));
    }
}
