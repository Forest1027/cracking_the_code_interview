package com.interview.basic.algorithms.sorting;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 1834. Single-Threaded CPU
 * https://leetcode.com/problems/single-threaded-cpu/
 */
public class SingleThreadedCPU {
    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;
        int[] answer = new int[n];
        Task[] wrapTasks = new Task[n];
        for (int i = 0; i < n; i++) {
            wrapTasks[i] = new Task(i, tasks[i][0], tasks[i][1]);
        }
        // sort by task's start time
        Arrays.sort(wrapTasks, Comparator.comparingInt(task -> task.startTime));

        PriorityQueue<Task> queue = new PriorityQueue<>(this::compare);
        // the index of the result
        int resIdx = 0;
        // the index to track Task array
        int taskIdx = 0;
        int currentTime = 0;

        while (resIdx < n) {
            // add all the tasks that are available at the current time into the queue
            while (taskIdx < n && wrapTasks[taskIdx].startTime <= currentTime) {
                queue.add(wrapTasks[taskIdx++]);
            }
            // if the queue is empty, it means no available tasks now.
            // add the next available task(closest start time)
            if (queue.size() == 0) {
                currentTime = wrapTasks[taskIdx].startTime;
                continue;
            }
            // get the next task to execute, track its index and calculate the time after finishing this task
            Task currTask = queue.remove();
            answer[resIdx++] = currTask.index;
            currentTime += currTask.processTime;
        }
        return answer;
    }

    // compare the process time first, then compare index
    private int compare(Task task1, Task task2) {
        if (task1.processTime != task2.processTime) {
            return task1.processTime - task2.processTime;
        } else {
            return task1.index - task2.index;
        }
    }

    private class Task {
        int index;
        int startTime;
        int processTime;

        public Task(int index, int startTime, int processTime) {
            this.index = index;
            this.startTime = startTime;
            this.processTime = processTime;
        }
    }

    public static void main(String[] args) {
        // [[19,13],[16,9],[21,10],[32,25],[37,4],[49,24],[2,15],[38,41],[37,34],[33,6],[45,4],[18,18],[46,39],[12,24]]
        SingleThreadedCPU sol = new SingleThreadedCPU();
        int[][] tasks = new int[][]{{19, 13}, {16, 9}, {21, 10}, {32, 25}, {37, 4}, {49, 24}, {2, 15}, {38, 41}, {37, 34}, {33, 6}, {45, 4}, {18, 18}, {46, 39}, {12, 24}};
        int[] order = sol.getOrder(tasks);
        System.out.println(Arrays.toString(order));
    }
}
