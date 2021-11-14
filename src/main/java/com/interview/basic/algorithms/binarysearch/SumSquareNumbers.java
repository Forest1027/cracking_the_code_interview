package com.interview.basic.algorithms.binarysearch;

/**
 * 633. Sum of Square Numbers
 * https://leetcode.com/problems/sum-of-square-numbers/
 */
public class SumSquareNumbers {
    public boolean judgeSquareSum(int c) {
        for (long a = 0; a * a <= c; a++) {
            int num = c - (int)(a * a);
            if (binarySearch(num)) return true;
        }
        return false;
    }

    private boolean binarySearch(long num) {
        long low = 0;
        long high = num;
        while (low <= high) {
            long mid = low + (high - low) / 2;
            if (mid * mid == num) {
                return true;
            }
            if (mid * mid > num) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        SumSquareNumbers sol = new SumSquareNumbers();
        boolean b = sol.judgeSquareSum(2147483646);
        System.out.println(b);
    }
}
