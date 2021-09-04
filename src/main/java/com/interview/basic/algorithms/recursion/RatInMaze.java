package com.interview.basic.algorithms.recursion;

public class RatInMaze {
    private static final int N = 4;
    private static final int[] xMoves = {1, 0};
    private static final int[] yMoves = {0, 1};

    private static boolean isSafe(int x, int y, int[][] maze) {
        return x >= 0 && x < N && y >= 0 && y < N && maze[x][y] == 1;
    }

    public static void solveMaze(int[][] maze) {
        int[][] sol = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sol[i][j] = 0;
            }
        }
        sol[0][0] = 1;
        if (solveMazeUtil(0, 0, maze, sol)) {
            printMaze(sol);
        } else {
            System.out.println("No route found");
        }
    }

    private static boolean solveMazeUtil(int x, int y, int[][] maze, int[][] sol) {
        if (x == N - 1 && y == N - 1) {
            return true;
        } else {
            for (int i = 0; i < 2; i++) {
                int nextX = x + xMoves[i];
                int nextY = y + yMoves[i];
                if (isSafe(nextX, nextY, maze)) {
                    sol[nextX][nextY] = 1;
                    if (solveMazeUtil(nextX, nextY, maze, sol)) {
                        return true;
                    } else {
                        sol[nextX][nextY] = 0;
                    }
                }
            }
        }
        return false;
    }

    private static void printMaze(int[][] sol) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(sol[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] maze = {
                {1, 0, 0, 0},
                {1, 1, 0, 1},
                {0, 1, 0, 0},
                {1, 1, 1, 1}
        };
        solveMaze(maze);
    }
}
