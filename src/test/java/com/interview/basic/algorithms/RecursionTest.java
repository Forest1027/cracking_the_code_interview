package com.interview.basic.algorithms;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;


class RecursionTest {
    @Test
    public void testFactorial() {
        int result = Recursion.factorial(5);
        int expected = 5 * 4 * 3 * 2;
        assertThat(expected == result);
    }

    @Test
    public void testEnglishRuler() {
        Recursion.drawRuler(2, 4);
    }

}