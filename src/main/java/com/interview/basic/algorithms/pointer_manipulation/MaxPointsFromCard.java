package com.interview.basic.algorithms.pointer_manipulation;

/**
 * 1423. Maximum Points You Can Obtain from Cards
 * https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/
 */
public class MaxPointsFromCard {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int l = k - 1;
        int max = 0;
        for (int i = 0; i < k; i++) {
            max += cardPoints[i];
        }
        int trac = max;
        while (l > -1) {
            int r = n - k + l;
            trac = trac - cardPoints[l] + cardPoints[r];
            max = Math.max(max, trac);
            l--;
        }
        return max;
    }
}
