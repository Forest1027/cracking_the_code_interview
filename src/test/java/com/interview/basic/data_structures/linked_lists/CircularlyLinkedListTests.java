package com.interview.basic.data_structures.linked_lists;

import org.junit.jupiter.api.Test;

import java.util.Random;

public class CircularlyLinkedListTests {
    private CircularlyLinkedList<Integer> circularlyLinkedList = new CircularlyLinkedList<>();
    private int size = 10;

    @Test
    void testAddFirst() {
        String expectedResult = buildLinkedList();
        System.out.println(expectedResult);
        System.out.println(circularlyLinkedList);
        assert expectedResult.equals(circularlyLinkedList.toString());
    }

    private String buildLinkedList() {
        int num = size;
        StringBuilder sb = new StringBuilder();
        sb.append("]");
        Random random = new Random();
        while (num > 0) {
            int element = random.nextInt(100);
            System.out.println("generated number is: " + element);
            if (num == 1) {
                sb.insert(0, element);
            } else {
                sb.insert(0, "," + element);
            }
            circularlyLinkedList.addFirst(element);
            num--;
        }
        sb.insert(0, "[");
        return sb.toString();
    }

    @Test
    void testSize() {
        buildLinkedList();
        System.out.println("size: " + circularlyLinkedList.size());
        assert size == circularlyLinkedList.size();
    }

    @Test
    void testRemoveFirst() {
        int num = size;
        String expectedResult = buildLinkedList();
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        while (num > 0) {
            if (num == 1) {
                sb.append(circularlyLinkedList.removeFirst());
            } else {
                sb.append(circularlyLinkedList.removeFirst() + ",");
            }
            num--;
        }
        sb.append("]");
        System.out.println(expectedResult);
        System.out.println(circularlyLinkedList);
        assert expectedResult.contentEquals(sb);
    }

    @Test
    void testEmpty() {
        assert circularlyLinkedList.isEmpty();
    }

    @Test
    void testAddLast() {
        int num = size;
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Random random = new Random();
        while (num > 0) {
            int element = random.nextInt(100);
            System.out.println("generated number is: " + element);
            if (num == 1) {
                sb.append(element);
            } else {
                sb.append(element + ",");
            }
            circularlyLinkedList.addLast(element);
            num--;
        }
        sb.append("]");
        System.out.println(sb);
        System.out.println(circularlyLinkedList);
        assert sb.toString().equals(circularlyLinkedList.toString());
    }
}
