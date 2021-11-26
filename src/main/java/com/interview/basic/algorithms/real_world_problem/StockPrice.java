package com.interview.basic.algorithms.real_world_problem;

import java.util.HashMap;
import java.util.Objects;
import java.util.TreeSet;

/**
 * 2034. Stock Price Fluctuation
 * https://leetcode.com/problems/stock-price-fluctuation/
 */
public class StockPrice {
    private TreeSet<Record> records;
    // time: price
    private HashMap<Integer, Integer> timeRecords;
    private int currentTime;

    public StockPrice() {
        // it's important to compare timestamp if the price is the same
        // if this is missing, different records with same price won't be able to be added
        this.records = new TreeSet<>((a, b) -> a.price == b.price ? a.time - b.time : a.price - b.price);
        this.timeRecords = new HashMap<>();
    }

    public void update(int timestamp, int price) {
        Record record = new Record(timestamp, price);
        // if the timestamp exist in the map, it's the update condition. Or else, it's create condition
        if(timeRecords.containsKey(timestamp)) {
            records.remove(new Record(timestamp, timeRecords.get(timestamp)));
        }
        records.add(record);
        timeRecords.put(timestamp, price);
        if(timestamp > this.currentTime) this.currentTime = timestamp;
    }

    public int current() {
        return timeRecords.get(this.currentTime);
    }

    public int maximum() {
        return records.last().price;
    }

    public int minimum() {
        return records.first().price;
    }

    public static class Record {
        int time;
        int price;

        public Record(int time, int price) {
            this.time = time;
            this.price = price;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Record record = (Record) o;
            return time == record.time && price == record.price;
        }

        @Override
        public int hashCode() {
            return Objects.hash(time, price);
        }
    }

    public static void main(String[] args) {
        /**
         * ["StockPrice","update","maximum","current","minimum","maximum","maximum","maximum","minimum","minimum","maximum","update","maximum","minimum","update","maximum","minimum","current","maximum","update","minimum","maximum","update","maximum","maximum","current","update","current","minimum","update","update","minimum","minimum","update","current","update","maximum","update","minimum"]
         * [[],[38,2308],[],[],[],[],[],[],[],[],[],[47,7876],[],[],[58,1866],[],[],[],[],[43,121],[],[],[40,5339],[],[],[],[32,5339],[],[],[43,6414],[49,9369],[],[],[36,3192],[],[48,1006],[],[53,8013],[]]
         */
        StockPrice sol = new StockPrice();
        sol.update(38,2308);
        System.out.println(sol.maximum());
        System.out.println(sol.current());
        System.out.println(sol.minimum());
        System.out.println(sol.maximum());
        System.out.println(sol.maximum());
        System.out.println(sol.maximum());
        System.out.println(sol.minimum());
        System.out.println(sol.minimum());
        System.out.println(sol.maximum());
        sol.update(47,7876);
        System.out.println(sol.maximum());
        System.out.println(sol.minimum());
        sol.update(58,1866);
        System.out.println(sol.maximum());
        System.out.println(sol.minimum());
        System.out.println(sol.current());
        System.out.println(sol.maximum());
        sol.update(43,121);
        System.out.println(sol.minimum());
        System.out.println(sol.maximum());
        sol.update(40,5339);
        System.out.println(sol.maximum());
        System.out.println(sol.maximum());
        System.out.println(sol.current());
        sol.update(32,5339);
        System.out.println(sol.current());
        System.out.println(sol.minimum());
        sol.update(43,6414);
        sol.update(49,9369);
        System.out.println(sol.minimum());
        System.out.println(sol.minimum());
        sol.update(36,3192);
        System.out.println(sol.current());
        sol.update(48,4006);
        System.out.println(sol.maximum());
        sol.update(53,8013);
        System.out.println(sol.minimum());
    }

}
