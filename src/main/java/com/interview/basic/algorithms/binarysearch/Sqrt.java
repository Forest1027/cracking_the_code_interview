package com.interview.basic.algorithms.binarysearch;

/**
 * 69. Sqrt(x)
 * https://leetcode.com/problems/sqrtx/
 */
public class Sqrt {
    public int mySqrt(int x) {
        if (x < 2) return x;
        int start = 1;
        int end = x;
        int result = 0;
        while (start <= end) {
            int mid = start + (end - start)/2;
            if (mid == x/mid) {
                return mid;
            }else if (mid< x/mid) {
                start = mid + 1;
                result = mid;
            }else {
                end = mid - 1;
            }
        }
        return result;
    }


    public static void main(String[] args) {
        Sqrt sol = new Sqrt();
        System.out.println(sol.mySqrt(3));
    }
}
