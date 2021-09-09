package com.interview.basic.algorithms.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubSet2 {
    private int[] nums;
    private List<List<Integer>> results = new ArrayList<>();

    private void subsetUtil(int width, List<Integer> container, int start) {
        if (width == container.size()) {
            results.add(new ArrayList<>(container));
            return;
        } else {
            for (int i = start; i < nums.length; i++) {
                if (i > start && nums[i] == nums[i - 1]) {
                    continue;
                }
                container.add(nums[i]);
                subsetUtil(width, container, i + 1);
                container.remove(container.size() - 1);
            }
        }
    }

    public List<List<Integer>> subsetWithDup(int[] nums) {
        this.nums = nums;
        Arrays.sort(nums);
        for (int i = 0; i <= nums.length; i++) {
            subsetUtil(i, new ArrayList<>(), 0);
        }
        return results;
    }

    public static void main(String[] args) {
        SubSet2 subSet2 = new SubSet2();
        int[] nums = new int[]{1, 2, 2};
        List<List<Integer>> result = subSet2.subsetWithDup(nums);
        System.out.println(result);
    }
}
