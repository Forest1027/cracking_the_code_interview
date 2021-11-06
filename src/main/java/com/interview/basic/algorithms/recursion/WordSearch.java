package com.interview.basic.algorithms.recursion;

import java.util.Arrays;

/**
 * 79. Word Search
 * https://leetcode.com/problems/word-search/
 */
public class WordSearch {
    private int[] xMoves = {1, 0, -1, 0};
    private int[] yMoves = {0, -1, 0, 1};

    /**
     * Time complexity: O(mn * 3^k)
     * Space complexity: O(mn + k)
     */
    public boolean exist(char[][] board, String word) {
        char[] chars = word.toCharArray();
        // int array to track result
        int[] tracker = new int[chars.length];
        Arrays.fill(tracker, -1);
        // int array to track visited
        int[][] visited = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == chars[0]) {
                    tracker[0] = chars[0];
                    visited[i][j] = 1;
                    if (findResult(board, 0, tracker, chars, i, j, visited)) {
                        return true;
                    }
                    visited[i][j] = 0;
                }
            }
        }
        return false;
    }

    private boolean findResult(char[][] board, int pointer, int[] tracker, char[] chars, int x, int y, int[][] visited) {
        if (pointer == chars.length - 1) {
            return true;
        }

        for (int i = 0; i < xMoves.length; i++) {
            int newX = x + xMoves[i];
            int newY = y + yMoves[i];
            if (isValid(newX, newY, tracker, pointer + 1, chars, board, visited)) {
                tracker[pointer + 1] = chars[pointer + 1];
                visited[newX][newY] = 1;
                if (findResult(board, pointer + 1, tracker, chars, newX, newY, visited)) {
                    return true;
                }
                tracker[pointer + 1] = -1;
                visited[newX][newY] = 0;
            }
        }
        return false;
    }

    private boolean isValid(int x, int y, int[] tracker, int pointer, char[] chars, char[][] board, int[][] visited) {
        return x >= 0 && y >= 0 && x < board.length && y < board[0].length && tracker[pointer] == -1 && board[x][y] == chars[pointer] && visited[x][y] == 0;
    }

}
