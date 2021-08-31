package com.interview.basic.algorithms;

public class Recursion {
    public static int factorial(int num) {
        if (num < 0) {
            throw new IllegalArgumentException();
        }else if (num == 0) {
            return 1;
        }else {
            return factorial(num - 1) * num;
        }
    }


}
