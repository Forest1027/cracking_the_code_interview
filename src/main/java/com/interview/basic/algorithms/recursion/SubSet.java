package com.interview.basic.algorithms.recursion;


import java.util.ArrayList;
import java.util.List;

public class SubSet {
    private int[] nums;
    private List<List<Integer>> results = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        this.nums = nums;
        results.add(new ArrayList<>());
        for (int i = 1; i <= nums.length; i++) {
            subsetUtil(i, new ArrayList<>(), 0);
        }
        return results;
    }

    private void subsetUtil(int width, List<Integer> container, int start) {
        if (container.size() == width) {
            results.add(new ArrayList<>(container));
            return;
        } else {
            for (int i = start; i < nums.length; i++) {
                container.add(nums[i]);
                subsetUtil(width, container, i + 1);
                container.remove(container.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        SubSet subSet = new SubSet();
        List<List<Integer>> result = subSet.subsets(nums);
        System.out.println(result);
    }
}
