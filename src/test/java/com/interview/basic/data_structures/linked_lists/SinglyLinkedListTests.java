package com.interview.basic.data_structures.linked_lists;


import org.junit.jupiter.api.Test;

import java.util.Random;

public class SinglyLinkedListTests {
    private SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<>();

    @Test
    void testAddFirst() {
        int size, num;
        num = size = 10;
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
        System.out.println(sb);
        System.out.println(singlyLinkedList);
        assert sb.toString().equals(singlyLinkedList.toString());
        System.out.println("size: " + singlyLinkedList.size());
        assert size == singlyLinkedList.size();
    }

}
