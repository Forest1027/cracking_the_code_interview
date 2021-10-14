package com.interview.basic.algorithms.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 47. Permutations II
 * https://leetcode.com/problems/permutations-ii/
 */
public class Permutation2 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        List<List<Integer>> result = new ArrayList<>();
        permutation(result, visited, nums, new ArrayList<>());
        return result;
    }

    private void permutation(List<List<Integer>> result, boolean[] visited, int[] nums, ArrayList<Integer> list) {
        if (list.size() == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    list.add(nums[i]);
                    permutation(result, visited, nums, list);
                    visited[i] = false;
                    list.remove(list.size() - 1);
                    while (i + 1 < nums.length && (nums[i] == nums[i + 1])) {
                        i++;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 3};
        Permutation2 sol = new Permutation2();
        sol.permuteUnique(nums).forEach(System.out::println);
    }
}
