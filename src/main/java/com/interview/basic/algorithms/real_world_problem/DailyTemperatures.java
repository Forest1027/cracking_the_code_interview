package com.interview.basic.algorithms.real_world_problem;

import java.util.Stack;

/**
 * 739. Daily Temperatures
 * https://leetcode.com/problems/daily-temperatures/
 */
public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];
        Stack<int[]> stack = new Stack<>();
        for(int i = 0; i < n; i++) {
            int currTemp = temperatures[i];
            while(!stack.isEmpty() && stack.peek()[1] < currTemp) {
                int[] ele = stack.pop();
                res[ele[0]] = i - ele[0];
            }
            stack.push(new int[]{i, currTemp});
        }
        return res;
    }
}
