package com.interview.basic.algorithms.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 51. N-Queens
 * https://leetcode.com/problems/n-queens/
 */
public class NQueens {
    /**
     * Once a position is occupied by a Queen, there are four directions that can't be occupied by another queen anymore:
     * 1. vertical -> use colVisited to track whether the column is visited
     * 2. horizontal -> only visit each row once so no need to track
     * 3. diagonal \ -> the value of col-row+n is in the range [1, 2n-1], so it can be tracked by an array with length 2n
     * 4. diagonal / -> the value of col+row is in the rage [0, 2n-2], so it can be tracked by an array with length 2n
     */
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new LinkedList<>();
        boolean[] colVisited = new boolean[n];
        boolean[] d1 = new boolean[2*n];
        boolean[] d2 = new boolean[2*n];
        findSolution(result, colVisited, d1, d2, n, 0, new ArrayList<>(n));
        return result;

    }

    private void findSolution(List<List<String>> result, boolean[] colVisited, boolean[] d1, boolean[] d2, int n, int row, List<String> current) {
        if(row == n) {
            result.add(new ArrayList<>(current));
            return;
        }

        for(int col = 0; col < n; col++) {
            int id1 = col - row + n;
            int id2 = col + row;
            if(!colVisited[col] && !d1[id1] && !d2[id2]) {
                char[] curRow = new char[n];
                colVisited[col] = true;
                d1[id1] = true;
                d2[id2] = true;
                Arrays.fill(curRow, '.');
                curRow[col] = 'Q';
                current.add(new String(curRow));
                findSolution(result, colVisited, d1, d2, n, row + 1, current);
                colVisited[col] = false;
                d1[id1] = false;
                d2[id2] = false;
                current.remove(current.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        NQueens sol = new NQueens();
        System.out.println(sol.solveNQueens(4));
    }
}
