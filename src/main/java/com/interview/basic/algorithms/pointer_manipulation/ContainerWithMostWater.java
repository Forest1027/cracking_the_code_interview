package com.interview.basic.algorithms.pointer_manipulation;

/**
 * 11. Container With Most Water
 * https://leetcode.com/problems/container-with-most-water/
 */
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int area = 0;
        while(left < right) {
            int validH = Math.min(height[left], height[right]);
            area = Math.max((right - left) * validH, area);
            if(height[left] < height[right]) {
                left++;
            }else {
                right--;
            }
        }
        return area;
    }
}
