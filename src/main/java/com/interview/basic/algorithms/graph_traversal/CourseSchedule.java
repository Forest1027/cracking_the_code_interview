package com.interview.basic.algorithms.graph_traversal;

import java.util.*;

/**
 * 207. Course Schedule
 * https://leetcode.com/problems/course-schedule/
 */
public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // preprocess - build adjacency list and calculate incoming degree for each vertex
        List<Set<Integer>> graph = new ArrayList<>(numCourses);
        List<Integer> inDegrees = new ArrayList<>(numCourses);
        for (int i = 0; i < numCourses; i++) {
            graph.add(new HashSet<>());
            inDegrees.add(0);
        }
        for (int[] prerequisite : prerequisites) {
            graph.get(prerequisite[1]).add(prerequisite[0]);
            inDegrees.set(prerequisite[0], inDegrees.get(prerequisite[0]) + 1);
        }
        // topological sort
        LinkedList<Integer> list = new LinkedList<>();
        LinkedList<Integer> tracker = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegrees.get(i) == 0) {
                list.add(i);
            }
        }
        while (!list.isEmpty()) {
            int ele = list.removeFirst();
            Set<Integer> neighbors = graph.get(ele);
            tracker.add(ele);
            for (int neighbor : neighbors) {
                inDegrees.set(neighbor, inDegrees.get(neighbor) - 1);
                if (inDegrees.get(neighbor) == 0) {
                    list.add(neighbor);
                }
            }
        }
        return tracker.size() == numCourses;
    }

    public static void main(String[] args) {
        int[][] nums = new int[][]{{0, 1}};
        CourseSchedule sol = new CourseSchedule();
        boolean b = sol.canFinish(2, nums);
        System.out.println(b);
    }
}
