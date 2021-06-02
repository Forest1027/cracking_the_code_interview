package com.interview.basic.data_structures.heaps;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class HeapTests {

    private HeapPriorityQueue<Integer, String> heap = new HeapPriorityQueue<>();
    private int size = 10;
    private Random random = new Random();

    @Test
    public void testInsertRandom() {
        int num = size;
        ArrayList<Integer> temp = new ArrayList<>();
        while (num > 0) {
            Integer key = random.nextInt(100);
            temp.add(key);
            String value = "Test - " + key;
            heap.insert(key, value);
            System.out.println("Generated number: " + key);
            System.out.println(heap);
            assert Collections.min(temp).equals(heap.min().getKey());
            num--;
        }
    }

    @Test
    public void testRemove() {
        int num = size;
        ArrayList<Integer> temp = new ArrayList<>();
        while (num > 0) {
            Integer key = random.nextInt(100);
            temp.add(key);
            String value = "Test - " + key;
            heap.insert(key, value);
            num--;
        }

        while (!heap.isEmpty()) {
            System.out.println(heap);
            System.out.println(temp);
            Entry<Integer, String> minEntry = heap.removeMin();
            assert Collections.min(temp).equals(minEntry.getKey());
            temp.remove(minEntry.getKey());
        }
    }


}
