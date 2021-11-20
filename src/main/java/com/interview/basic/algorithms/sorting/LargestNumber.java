package com.interview.basic.algorithms.sorting;

import java.util.PriorityQueue;

/**
 * 179. Largest Number
 * https://leetcode.com/problems/largest-number/
 */
public class LargestNumber {
    public String largestNumber(int[] nums) {
        PriorityQueue<String> queue = new PriorityQueue<>((a, b) -> compare(a, b));
        for (int num : nums) {
            queue.add("" + num);
        }
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            String ele = queue.remove();
            sb.append(ele);
        }
        if (sb.charAt(0) == '0') {
            return "0";
        }
        return Integer.valueOf(sb.toString()).toString();
    }

    private int compare(String a, String b) {
        String order1 = a + b;
        String order2 = b + a;
        return order2.compareTo(order1);
    }

    public static void main(String[] args) {
        // [3,30,34,5,9]
        // [34323,3432]
        int[] nums = new int[]{34323, 3432};
        LargestNumber sol = new LargestNumber();
        System.out.println(sol.largestNumber(nums));
    }
}
