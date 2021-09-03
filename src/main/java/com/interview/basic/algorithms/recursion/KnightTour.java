package com.interview.basic.algorithms.recursion;

import javax.crypto.spec.PSource;

public class KnightTour {
    private static int N = 6;
    private static int[] xMoves = {1, 1, 2, 2, -1, -1, -2, -2};
    private static int[] yMoves = {2, -2, 1, -1, 2, -2, -1, 1};

    private static boolean isSafe(int x, int y, int[][] sol) {
        return x >= 0 && x < N && y >= 0 && y < N && sol[x][y] == -1;
    }

    public static void KT() {
        int[][] sol = new int[N][N];
        // initialization
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sol[i][j] = -1;
            }
        }
        sol[0][0] = 0;
        if (KTUtil(0, 0, 1, sol)) {
            printKT(sol);
        } else {
            System.out.println("Not tour found");
        }
    }

    private static boolean KTUtil(int x, int y, int movei, int[][] sol) {
        if (movei == N * N) {
            return true;
        } else {
            for (int i = 0; i < 8; i++) {
                int next_x = x + xMoves[i];
                int next_y = y + yMoves[i];
                if (isSafe(next_x, next_y, sol)) {
                    sol[next_x][next_y] = movei;
                    if (KTUtil(next_x, next_y, movei + 1, sol)) {
                        return true;
                    } else {
                        sol[next_x][next_y] = -1;
                    }
                }
            }
        }
        return false;
    }

    private static void printKT(int[][] sol) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(sol[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        KT();
    }
}
