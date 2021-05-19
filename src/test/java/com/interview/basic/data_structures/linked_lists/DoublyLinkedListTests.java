package com.interview.basic.data_structures.linked_lists;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

public class DoublyLinkedListTests {

    private DoublyLinkedList<Integer> linkedList = new DoublyLinkedList<>();
    private int size = 10;

    @Test
    void testAddFirst() {
        String expectedResult = buildLinkedList();
        System.out.println(expectedResult);
        System.out.println(linkedList);
        assert expectedResult.equals(linkedList.toString());
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
            linkedList.addFirst(element);
            num--;
        }
        sb.insert(0, "[");
        return sb.toString();
    }

    @Test
    void testSize() {
        buildLinkedList();
        System.out.println("size: " + linkedList.size());
        assert size == linkedList.size();
    }

    @Test
    void testRemoveFirst() {
        int num = size;
        String expectedResult = buildLinkedList();
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        while (num > 0) {
            if (num == 1) {
                sb.append(linkedList.removeFirst());
            } else {
                sb.append(linkedList.removeFirst() + ",");
            }
            num--;
        }
        sb.append("]");
        System.out.println("Expected result:" + expectedResult);
        System.out.println("Generated result: " + linkedList);
        assert expectedResult.contentEquals(sb);
    }

    @Test
    void testRemoveLast() {
        int num = size;
        String expectedResult = buildLinkedList();
        StringBuilder sb = new StringBuilder();
        sb.append("]");
        while (num > 0) {
            if (num == 1) {
                sb.insert(0, linkedList.removeLast());
            } else {
                sb.insert(0, "," + linkedList.removeLast());
            }
            num--;
        }
        sb.insert(0, "[");
        assert expectedResult.contentEquals(sb);
    }

    @Test
    void testEmpty() {
        assert linkedList.isEmpty();
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
            linkedList.addLast(element);
            num--;
        }
        sb.append("]");
        System.out.println(sb);
        System.out.println(linkedList);
        assert sb.toString().equals(linkedList.toString());
    }
}
