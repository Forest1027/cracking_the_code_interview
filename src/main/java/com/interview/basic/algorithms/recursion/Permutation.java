package com.interview.basic.algorithms.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * 46. Permutations
 * https://leetcode.com/problems/permutations/
 */
public class Permutation {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        permutation(result, nums, visited, new ArrayList<>());
        return result;
    }

    private void permutation(List<List<Integer>> result, int[] nums, boolean[] visited, List<Integer> list) {
        if (list.size() == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                list.add(nums[i]);
                permutation(result, nums, visited, list);
                visited[i] = false;
                list.remove(list.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5};
        Permutation sol = new Permutation();
        sol.permute(nums).forEach(System.out::println);
    }

}
