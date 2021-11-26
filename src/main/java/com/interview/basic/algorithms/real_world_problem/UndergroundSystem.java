package com.interview.basic.algorithms.real_world_problem;

import java.util.HashMap;
import java.util.Map;

/**
 * 1396. Design Underground System
 * https://leetcode.com/problems/design-underground-system/
 */
public class UndergroundSystem {
    // userId : [startStation, time]
    private Map<Integer, Object[]> users;
    // startStation-endStation : [totalTime, count]
    private Map<String, int[]> trips;

    public UndergroundSystem() {
        this.users = new HashMap<>();
        this.trips = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        this.users.put(id, new Object[]{stationName, t});
    }

    public void checkOut(int id, String stationName, int t) {
        Object[] info = this.users.remove(id);
        int[] timeInfo = trips.getOrDefault( info[0] + "-" + stationName, new int[2]);
        timeInfo[0] = timeInfo[0] + t - (int) info[1];
        timeInfo[1] = timeInfo[1] + 1;
        trips.put(info[0] + "-" + stationName, timeInfo);
    }

    public double getAverageTime(String startStation, String endStation) {
        String key = startStation + "-" + endStation;
        int[] timeInfo = trips.get(key);
        return (double) timeInfo[0] / timeInfo[1];
    }
}
