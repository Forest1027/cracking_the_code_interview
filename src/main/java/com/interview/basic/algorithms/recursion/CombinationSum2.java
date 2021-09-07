package com.interview.basic.algorithms.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {
    private int target;
    private int[] candidates;
    private List<List<Integer>> results = new ArrayList<>();

    public List<List<Integer>> sum(int[] candidates, int target) {
        this.target = target;
        Arrays.sort(candidates);
        this.candidates = candidates;
        csUtil(0, 0, new ArrayList<>());
        return results;
    }

    private void csUtil(int start, int sum, List<Integer> container) {
        if (sum == target) {
            results.add(new ArrayList<>(container));
            return;
        } else if (sum > target) {
            return;
        } else {
            for (int i = start; i < candidates.length; i++) {
                // optimization
                // skip potential duplicate combination
                if (i > start && candidates[i] == candidates[i - 1]) {
                    continue;
                }
                container.add(candidates[i]);
                csUtil(i + 1, sum + candidates[i], container);
                container.remove(container.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] candidates = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        int target = 30;
        CombinationSum2 cs = new CombinationSum2();
        List<List<Integer>> result = cs.sum(candidates, target);
        System.out.println(result);
    }
}
