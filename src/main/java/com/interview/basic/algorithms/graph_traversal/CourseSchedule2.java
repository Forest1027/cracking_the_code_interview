package com.interview.basic.algorithms.graph_traversal;

import java.util.*;

public class CourseSchedule2 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        int[] result = new int[numCourses];
        Map<Integer, List<Integer>> vertexMap = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        // preprocess
        for (int i = 0; i < prerequisites.length; i++) {
            int v = prerequisites[i][0];
            int vPrep = prerequisites[i][1];
            inDegree[v] = inDegree[v] + 1;
            List<Integer> adjacent = vertexMap.getOrDefault(vPrep, new LinkedList<>());
            adjacent.add(v);
            vertexMap.put(vPrep, adjacent);
        }
        //find out the ones without prerequisite
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                stack.push(i);
            }
        }

        int index = 0;
        while (!stack.isEmpty()) {
            int current = stack.pop();
            result[index] = current;
            for (Integer v : vertexMap.getOrDefault(current, new ArrayList<>())) {
                inDegree[v] = inDegree[v] - 1;
                if (inDegree[v] == 0) {
                    stack.push(v);
                }
            }
            index++;
        }

        if (index != numCourses) {
            return new int[]{};
        } else {
            return result;
        }
    }

    public static void main(String[] args) {
        CourseSchedule2 solution = new CourseSchedule2();
        int numCourses = 4;
        int[][] prerequisites = new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        int[] order = solution.findOrder(numCourses, prerequisites);
        for (int i = 0; i < order.length; i++) {
            System.out.println(i);
        }
    }
}
