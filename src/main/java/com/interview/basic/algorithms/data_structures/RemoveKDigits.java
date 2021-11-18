package com.interview.basic.algorithms.data_structures;

import java.util.LinkedList;

/**
 * 402. Remove K Digits
 * https://leetcode.com/problems/remove-k-digits/
 */
public class RemoveKDigits {
    public String removeKdigits(String num, int k) {
        LinkedList<Character> queue = new LinkedList<>();
        for (char ele : num.toCharArray()) {
            while (!queue.isEmpty() && k > 0 && queue.getLast() > ele) {
                queue.removeLast();
                k--;
            }
            queue.addLast(ele);
        }
        // handle edge case
        while (k > 0) {
            queue.removeLast();
            k--;
        }


        // remove leading 0
        while (!queue.isEmpty() && queue.getFirst().equals('0')) {
            queue.removeFirst();
        }
        if (queue.isEmpty()) return "0";

        // assemble
        StringBuilder sb = new StringBuilder();
        for (char ele : queue) {
            sb.append(ele);
        }

        return sb.toString();
    }
}
