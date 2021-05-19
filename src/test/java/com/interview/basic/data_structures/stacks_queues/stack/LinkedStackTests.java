package com.interview.basic.data_structures.stacks_queues.stack;

import org.junit.jupiter.api.Test;

import java.util.Random;

public class LinkedStackTests {
    private Stack<Integer> stack = new LinkedStack<>();
    private int size = 10;

    @Test
    public void testPush() {
        String expectedResult = buildStack();
        System.out.println("Expected result:" + expectedResult);
        System.out.println("Generated result: " + stack);
        assert expectedResult.equals(stack.toString());
    }

    private String buildStack() {
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
            stack.push(element);
            num--;
        }
        sb.insert(0, "[");
        return sb.toString();
    }

    @Test
    public void pop() {
        int num = size;
        String expectedResult = buildStack();
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        while (num > 0) {
            if (num == 1) {
                sb.append(stack.pop());
            } else {
                sb.append(stack.pop() + ",");
            }
            num--;
        }
        sb.append("]");
        System.out.println("Expected result:" + expectedResult);
        System.out.println("Generated result: " + stack);
        assert expectedResult.contentEquals(sb);
    }
}
