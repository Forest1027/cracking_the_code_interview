package com.interview.basic.algorithms.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 658. Find K Closest Elements
 * https://leetcode.com/problems/find-k-closest-elements/
 */
public class FindKClosestElements {
    /**
     * TC: O(n + klogk)
     * SC: O(k)
     */
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n = arr.length;
        List<Integer> res = new LinkedList<>();
        // find the position of x in the array
        int index = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] < x) {
                index++;
            }
        }
        int left = index - 1;
        int right = index;
        while (k > 0) {
            if (left < 0) {
                res.add(arr[right++]);
            } else if (right >= n) {
                res.add(arr[left--]);
            } else {
                int diffL = x - arr[left];
                int diffR = arr[right] - x;
                if (Math.min(diffL, diffR) == diffL) res.add(arr[left--]);
                else res.add(arr[right++]);
            }
            k--;
        }
        Collections.sort(res);
        return res;
    }

    /**
     * TC: O(n)
     * SC: O(k)
     */
    public List<Integer> findClosestElements2(int[] arr, int k, int x) {
        List<Integer> list = new ArrayList<>();  // A list to store the resultant subarray
        int low = 0;                                    // A var to point at the left half of the array
        int high = arr.length - 1;                      // A var to point at the right half of the array

        while (high - low >= k) {                         // Traverse till the difference between 'high' and 'low' is not less than 'k'
            int distLow = Math.abs(arr[low] - x);       // Get the difference between 'x' and the element at index 'low' in 'distLow'
            int distHigh = Math.abs(arr[high] - x);     // Get the difference between 'x' and the element at index 'high' in 'distHigh'

            if (distLow <= distHigh)                     // Now, check if 'distLow' less than or equal 'distHigh' or not
                high--;                                 // If Yes, then move the right pointer i.e., decrease the value of 'high'
            else                                        // Else,
                low++;                                  // Move the left pointer i.e., increase the value of 'low'
        }
        while (low <= high)                              // After traversing the array, traverse another loop to get the resultant values
            list.add(arr[low++]);                       // And, keep adding those values to the resultant list

        return list;                                    // Finally, return the resultant list
    }

    public static void main(String[] args) {
        /**
         * [3,5,8,10]
         * 2
         * 15
         */
        int[] nums = new int[]{3, 5, 8, 10};
        FindKClosestElements sol = new FindKClosestElements();
        System.out.println(sol.findClosestElements(nums, 2, 15));
    }
}
