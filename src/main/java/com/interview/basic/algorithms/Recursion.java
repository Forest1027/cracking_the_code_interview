package com.interview.basic.algorithms;

public class Recursion {
    public static int factorial(int num) {
        if (num < 0) {
            throw new IllegalArgumentException();
        } else if (num == 0) {
            return 1;
        } else {
            return factorial(num - 1) * num;
        }
    }

    public static void drawRuler(int inch, int maxTickLength) {
        drawLine(maxTickLength, 0);
        for (int i = 1; i <= inch; i++) {
            drawInterval(maxTickLength - 1);
            drawLine(maxTickLength, i);
        }
    }

    private static void drawLine(int length, int label) {
        for (int i = 0; i < length; i++) {
            System.out.print("-");
        }

        if (label >= 0) {
            System.out.print(" " + label);
        }
        System.out.println();
    }

    private static void drawInterval(int length) {
        if (length == 0) {
            System.out.println();
        } else {
            drawInterval(length - 1);
            drawLine(length, -1);
            drawInterval(length - 1);
        }
    }

    public static int binarySearch(int[] data, int low, int high, int target) {
        if (low > high) {
            return -1;
        }
        int medium = (low + high) / 2;
        if (data[medium] == target) {
            return medium;
        } else if (data[medium] < target) {
            return binarySearch(data, medium + 1, high, target);
        } else {
            return binarySearch(data, low, medium - 1, target);
        }
    }

}
