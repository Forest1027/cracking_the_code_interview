package com.interview.basic.algorithms.binarysearch;

/**
 * 240. Search a 2D Matrix II
 * https://leetcode.com/problems/search-a-2d-matrix-ii/
 * Explanation: https://leetcode.com/problems/search-a-2d-matrix-ii/discuss/66140/My-concise-O(m%2Bn)-Java-solution
 */
public class Search2DMatrix2 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = 0;
        int col = matrix[0].length - 1;
        while(row < matrix.length && col >= 0) {
            if(matrix[row][col] == target) return true;
            else if(matrix[row][col] < target) row++;
            else col--;
        }
        return false;
    }
}
