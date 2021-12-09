package com.interview.basic.algorithms.bst;

/**
 * 1306. Jump Game III
 * https://leetcode.com/problems/jump-game-iii/
 */
public class JumpGame3 {
    /**
     * TC: O(n)
     * SC: O(n)
     */
    public boolean canReach(int[] arr, int start) {
        boolean[] visited = new boolean[arr.length];
        return jump(arr, start, visited);
    }

    private boolean jump(int[] arr, int index, boolean[] visited) {
        if(!(index >= 0 && index < arr.length) || visited[index]) return false;
        if(arr[index] == 0) return true;
        visited[index] = true;
        return jump(arr, index - arr[index], visited) || jump(arr, index + arr[index], visited);
    }


    public static void main(String[] args) {
        /**
         * [4,2,3,0,3,1,2]
         * 5
         */

        JumpGame3 sol = new JumpGame3();
        int[] arr = {4, 2, 3, 0, 3, 1, 2};
        int start = 5;
        boolean res = sol.canReach(arr, start);
        System.out.println(res);
    }
}
