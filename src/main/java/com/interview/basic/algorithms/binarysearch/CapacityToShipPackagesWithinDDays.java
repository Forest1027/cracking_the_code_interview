package com.interview.basic.algorithms.binarysearch;

/**
 * 1011. Capacity To Ship Packages Within D Days
 * https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/
 */
public class CapacityToShipPackagesWithinDDays {
    public int shipWithinDays(int[] weights, int days) {
        // the range of the capacity is [1, totalWeight]
        // search through the range to find the valid capacity
        int totalWeight = 0;
        for (int weight : weights) {
            totalWeight += weight;
        }
        int low = 1;
        int high = totalWeight;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isValid(mid, days, weights)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private boolean isValid(int capacity, int days, int[] weights) {
        int daysNeed = 0;
        int load = 0;
        for (int weight : weights) {
            if (weight > capacity) {
                return false;
            }
            load += weight;
            if (load > capacity) {
                daysNeed++;
                load = weight;
            }
        }
        if (load > 0) daysNeed++;
        return daysNeed <= days;
    }
}
