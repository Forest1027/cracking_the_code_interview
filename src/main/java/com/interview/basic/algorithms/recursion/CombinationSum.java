package com.interview.basic.algorithms.recursion;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    private int[] candidates;
    private int target;
    private List<List<Integer>> results = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.candidates = candidates;
        this.target = target;
        csUtil(0, 0, new ArrayList<>());
        return results;
    }

    private void csUtil(int index, int sum, List<Integer> res) {
        if (sum == target) {
            results.add(new ArrayList<>(res));
            return;
        } else if (sum > target) {
            return;
        } else {
            for (int i = index; i < candidates.length; i++) {
                res.add(candidates[i]);
                csUtil(i, sum + candidates[i], res);
                res.remove(res.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        CombinationSum sum = new CombinationSum();
        int[] candidates = new int[]{2, 3, 6, 7};
        List<List<Integer>> result = sum.combinationSum(candidates, 7);
        System.out.println(result);
    }
}
