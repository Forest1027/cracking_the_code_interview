package com.interview.basic.algorithms.data_structures;

import java.util.Arrays;
import java.util.TreeSet;

/**
 * 778. Swim in Rising Water
 * https://leetcode.com/problems/swim-in-rising-water/
 * explanation:
 * https://leetcode.com/problems/swim-in-rising-water/discuss/965631/Java-3-clean-codes%3A-Dijkstra's-algo-PriorityQueue-and-Binary-search
 */
public class SwimRisingWater {
    private int[][] moves = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    /**
     * Binary Search
     * TC: O(log(n^2))
     * The time is between grid[0][0] and n^2 - 1. The result T can get us to grid[n-1][n-1].
     * The goal is to find the minimum T.
     */
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int left = grid[0][0];
        int right = n * n - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (valid(grid, mid, 0, 0, new boolean[n][n])) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean valid(int[][] grid, int time, int i, int j, boolean[][] visited) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid.length || visited[i][j] || grid[i][j] > time) {
            return false;
        }
        visited[i][j] = true;
        if (i == grid.length - 1 && j == grid.length - 1) return true;
        return valid(grid, time, i - 1, j, visited) || valid(grid, time, i + 1, j, visited) || valid(grid, time, i, j - 1, visited) || valid(grid, time, i, j + 1, visited);
    }

    /**
     * Dijkstra's algorithm
     * TC: O(n^2)
     */
    public int swimInWater1(int[][] grid) {
        int n = grid.length;
        int[][] dist = new int[n][n];
        for (int i = 0; i < n; i++) Arrays.fill(dist[i], n * n);
        dist[0][0] = grid[0][0];
        TreeSet<int[]> set = new TreeSet<>((a, b) -> a[2] == b[2] ? (a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]) : a[2] - b[2]);
        set.add(new int[]{0, 0, grid[0][0]});
        while (!set.isEmpty()) {
            int[] current = set.pollFirst();
            int i = current[0];
            int j = current[1];
            int time = current[2];
            if (i == n - 1 && j == n - 1) break;
            for (int[] move : moves) {
                int x = i + move[0];
                int y = j + move[1];
                if (x < 0 || x >= n || y < 0 || y >= n) continue;
                int newTime = time + Math.max(0, grid[x][y] - time);
                // relaxation
                if (newTime < dist[x][y]) {
                    int[] key = {x, y, dist[x][y]};
                    set.remove(key);
                    key[2] = dist[x][y] = newTime;
                    set.add(key);
                }
            }
        }
        return dist[n - 1][n - 1];
    }

    public static void main(String[] args) {
        // [[0,2],[1,3]]
        // [[0,1,2,3,4],[24,23,22,21,5],[12,13,14,15,16],[11,17,18,19,20],[10,9,8,7,6]]
        int[][] grid = new int[][]{{0, 1, 2, 3, 4}, {24, 23, 22, 21, 5}, {12, 13, 14, 15, 16}, {11, 17, 18, 19, 20}, {10, 9, 8, 7, 6}};
        SwimRisingWater sol = new SwimRisingWater();
        int result = sol.swimInWater(grid);
        System.out.println(result);
    }
}
