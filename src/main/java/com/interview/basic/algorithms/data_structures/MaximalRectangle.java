package com.interview.basic.algorithms.data_structures;

import java.util.Stack;

/**
 * 85. Maximal Rectangle
 * https://leetcode.com/problems/maximal-rectangle/
 * Explanation: https://leetcode.com/problems/maximal-rectangle/discuss/29055/My-java-solution-based-on-Maximum-Rectangle-in-Histogram-with-explanation
 */
public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;

        int[] height = new int[matrix[0].length];
        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[0][i] == '1') height[i] = 1;
        }
        int result = largestInLine(height);
        for (int i = 1; i < matrix.length; i++) {
            resetHeight(matrix, height, i);
            result = Math.max(result, largestInLine(height));
        }

        return result;
    }

    private void resetHeight(char[][] matrix, int[] height, int idx) {
        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[idx][i] == '1') height[i] += 1;
            else height[i] = 0;
        }
    }

    public int largestInLine(int[] height) {
        if (height == null || height.length == 0) return 0;
        int len = height.length;
        Stack<Integer> s = new Stack<>();
        int maxArea = 0;
        for (int i = 0; i <= len; i++) {
            int h = (i == len ? 0 : height[i]);
            if (s.isEmpty() || h >= height[s.peek()]) {
                s.push(i);
            } else {
                int tp = s.pop();
                maxArea = Math.max(maxArea, height[tp] * (s.isEmpty() ? i : i - 1 - s.peek()));
                i--;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        // [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
        char[][] input = new char[][]{{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        MaximalRectangle sol = new MaximalRectangle();
        int i = sol.maximalRectangle(input);
        System.out.println(i);
    }
}
