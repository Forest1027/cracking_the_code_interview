package com.interview.basic.algorithms.sorting;

import java.util.Arrays;

/**
 * 1921. Eliminate Maximum Number of Monsters
 * https://leetcode.com/problems/eliminate-maximum-number-of-monsters/
 */
public class EliminateMaximumNumberMonsters {
    public int eliminateMaximum(int[] dist, int[] speed) {
        int total = dist.length;
        // time for monsters to arrive
        int[] time = new int[total];
        for(int i = 0; i < total; i++) {
            time[i] = (int)Math.ceil(dist[i]*1.0/speed[i]);
        }
        // kill monsters base on their arrival time
        Arrays.sort(time);
        for(int i = 0; i < total; i++) {
            // i represent the time that weapon is ready
            if(i >= time[i]) return i;
        }
        return total;
    }
}
