package com.interview.basic.algorithms;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;


class RecursionTest {
    @Test
    public void testFactorial() {
        int result = Recursion.factorial(5);
        int expected = 5 * 4 * 3 * 2;
        assertThat(expected).isEqualTo(result);
    }

    @Test
    public void testEnglishRuler() {
        Recursion.drawRuler(2, 4);
    }

    @Test
    public void testBinarySearch() {
        int[] data = {0, 1, 2, 3, 4, 5};
        int index = Recursion.binarySearch(data, 0, 5, 0);
        assertThat(index).isEqualTo(0);
    }

}