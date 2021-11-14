package com.interview.basic.algorithms.binarysearch;

/**
 * 668. Kth Smallest Number in Multiplication Table
 * https://leetcode.com/problems/kth-smallest-number-in-multiplication-table/
 */
public class KthSmallestNumberMultiplicationTable {
    public int findKthNumber(int m, int n, int k) {
        // determine the range
        int low = 1;
        int high = m * n;
        // find the smallest kth element in the range. Use binary search to speed up.
        while (low <= high) {
            int mid = low + (high - low) / 2;
            // check if have enough element for it to the kth element
            if (!enough(m, n, k, mid)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    private boolean enough(int m, int n, int k, int ele) {
        int count = 0;
        for (int i = 1; i <= m; i++) {
            // it's a multiplication table, in i th row, the elements are [1*i, 2*i, 3*i,..., n*i]
            // in each row, we want to find the mamximum possible count of the elements that are smaller than ele
            // first row, maximum possible count is ele/1, if the ele is too big, the maximum is n -> Min(ele/1, n)
            // second row, maximum possible count is ele/2 -> Min(ele/2, n)...
            // ith row, maximum possible cound is ele/i -> Min(ele/i, n)
            count += Math.min(ele / i, n);
        }
        return count >= k;
    }
}
