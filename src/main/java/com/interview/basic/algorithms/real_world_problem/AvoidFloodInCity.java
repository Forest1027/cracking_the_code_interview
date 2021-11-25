package com.interview.basic.algorithms.real_world_problem;

import java.util.*;

/**
 * 1488. Avoid Flood in The City
 * https://leetcode.com/problems/avoid-flood-in-the-city/
 */
public class AvoidFloodInCity {
    private LinkedList<Integer> dryDays;

    public int[] avoidFlood(int[] rains) {
        int n = rains.length;
        int[] res = new int[n];
        Arrays.fill(res, 1);
        // keep track of days that lake can be dried
        dryDays = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (rains[i] == 0) dryDays.add(i);
            else res[i] = -1;
        }
        // keep track of the last day that i lake gets rained over
        Map<Integer, Integer> tracker = new HashMap<>();
        // when iterating, if a lake has been rained over but can't get dried before the day -> impossible
        for (int i = 0; i < n; i++) {
            if (rains[i] == 0) continue;
            if (tracker.containsKey(rains[i])) {
                int dryDay = findDryDay(tracker.get(rains[i]), i);
                if (dryDay == -1) {
                    return new int[0];
                }
                // dry the lake
                res[dryDay] = rains[i];
            }
            tracker.put(rains[i], i);
        }
        return res;
    }

    private int findDryDay(int prev, int current) {
        Iterator<Integer> iterator = dryDays.iterator();
        while (iterator.hasNext()) {
            int day = iterator.next();
            if (day < current && day > prev) {
                iterator.remove();
                return day;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        AvoidFloodInCity sol = new AvoidFloodInCity();
        // [1,2,0,0,2,1]
        // [1,1,0,0]
        // [1,0,2,0,2,1]
        int[] rains = {1, 0, 2, 0, 2, 1};
        int[] res = sol.avoidFlood(rains);
        System.out.println(Arrays.toString(res));
    }
}
