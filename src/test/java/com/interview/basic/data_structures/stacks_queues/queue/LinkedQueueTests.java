package com.interview.basic.data_structures.stacks_queues.queue;

import org.junit.jupiter.api.Test;

import java.util.Random;

public class LinkedQueueTests {
    private Queue<Integer> queue = new LinkedQueue<>();
    private int size = 10;

    @Test
    public void testEnqueue() {
        String expectedResult = buildQueue();
        System.out.println("Expected result:" + expectedResult);
        System.out.println("Generated result: " + queue);
        assert expectedResult.equals(queue.toString());
    }

    private String buildQueue() {
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
                sb.append(element).append(",");
            }
            queue.enqueue(element);
            num--;
        }
        sb.append("]");
        return sb.toString();
    }

    @Test
    public void testDequeue() {
        int num = size;
        String expectedResult = buildQueue();
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        while (num > 0) {
            if (num == 1) {
                sb.append(queue.dequeue());
            } else {
                sb.append( queue.dequeue()).append(",");
            }
            num--;
        }
        sb.append("]");
        System.out.println("Expected result:" + expectedResult);
        System.out.println("Generated result: " + sb);
        assert expectedResult.contentEquals(sb);
    }
}
