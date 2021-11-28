package com.interview.basic.algorithms.real_world_problem;

/**
 * 134. Gas Station
 * https://leetcode.com/problems/gas-station/
 * Explanation: https://leetcode.com/problems/gas-station/discuss/42568/Share-some-of-my-ideas./180595
 */
public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // check if there is a solution
        int total = 0;
        for (int i = 0; i < gas.length; i++) {
            total += gas[i] - cost[i];
        }
        if (total < 0) {
            return -1;
        }

        // find out the starting point
        int start = 0;
        total = 0;
        for (int i = 0; i < gas.length; i++) {
            total += gas[i] - cost[i];
            if (total < 0) {
                // the trip from i to i+1 fail, so the starting point must not be anything before i
                start = i + 1;
                total = 0;
            }
        }
        return start;
    }
}
