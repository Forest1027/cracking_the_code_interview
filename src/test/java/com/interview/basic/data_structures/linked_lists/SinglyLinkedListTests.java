package com.interview.basic.data_structures.linked_lists;


import org.junit.jupiter.api.Test;

import java.util.Random;

public class SinglyLinkedListTests {
    private SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<>();
    private int size = 10;

    @Test
    void testAddFirst() {
        String expectedResult = buildLinkedList();
        System.out.println(expectedResult);
        System.out.println(singlyLinkedList);
        assert expectedResult.equals(singlyLinkedList.toString());
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
            singlyLinkedList.addFirst(element);
            num--;
        }
        sb.insert(0, "[");
        return sb.toString();
    }

    @Test
    void testSize() {
        buildLinkedList();
        System.out.println("size: " + singlyLinkedList.size());
        assert size == singlyLinkedList.size();
    }

    @Test
    void testRemoveFirst() {
        int num = size;
        String expectedResult = buildLinkedList();
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        while (num > 0) {
            if (num == 1) {
                sb.append(singlyLinkedList.removeFirst());
            } else {
                sb.append(singlyLinkedList.removeFirst() + ",");
            }
            num--;
        }
        sb.append("]");
        System.out.println("Expected result:" + sb);
        System.out.println("Generated result: " + singlyLinkedList);
        assert expectedResult.contentEquals(sb);
    }

    @Test
    void testEmpty() {
        assert singlyLinkedList.isEmpty();
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
            singlyLinkedList.addLast(element);
            num--;
        }
        sb.append("]");
        System.out.println(sb);
        System.out.println(singlyLinkedList);
        assert sb.toString().equals(singlyLinkedList.toString());
    }


}
