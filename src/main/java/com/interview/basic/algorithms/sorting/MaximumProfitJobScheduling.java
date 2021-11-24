package com.interview.basic.algorithms.sorting;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeMap;

/**
 * 1235. Maximum Profit in Job Scheduling
 * https://leetcode.com/problems/maximum-profit-in-job-scheduling/
 */
public class MaximumProfitJobScheduling {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        int[][] jobs = new int[n][3];
        for (int i = 0; i < n; i++) {
            jobs[i] = new int[]{startTime[i], endTime[i], profit[i]};
        }
        Arrays.sort(jobs, Comparator.comparingInt(a -> a[1]));
        // time - max profit within the time
        TreeMap<Integer, Integer> tracker = new TreeMap<>();
        tracker.put(0, 0);
        for (int[] job : jobs) {
            int current = tracker.floorEntry(job[0]).getValue() + job[2];
            if (current > tracker.lastEntry().getValue()) {
                tracker.put(job[1], current);
            }
        }
        return tracker.lastEntry().getValue();
    }
}
