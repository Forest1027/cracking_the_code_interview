package com.interview.basic.algorithms.binarysearch;

/**
 * 74. Search a 2D Matrix
 * https://leetcode.com/problems/search-a-2d-matrix/
 */
public class Search2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        int start = 0;
        int end = row * col - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int midVal = matrix[mid / col][mid % col];
            if (midVal == target) return true;
            else if (midVal < target) start++;
            else end--;
        }
        return false;
    }
}
