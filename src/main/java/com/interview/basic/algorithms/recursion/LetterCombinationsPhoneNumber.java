package com.interview.basic.algorithms.recursion;

import java.util.LinkedList;
import java.util.List;

/**
 * 17. Letter Combinations of a Phone Number
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 */
public class LetterCombinationsPhoneNumber {
    /**
     * Time complexity: O(4^N)
     * Space complexity: O(N*4^N) (need to consider the space used for appending the string)
     */
    public List<String> letterCombinations(String digits) {
        List<String> result = new LinkedList<>();
        if (digits.length() == 0) return result;
        // load data
        String[] dict = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        findSolution(result, dict, digits.toCharArray(), "");
        return result;
    }

    private void findSolution(List<String> result, String[] dict, char[] digits, String current) {
        if (current.length() == digits.length) {
            result.add(current);
            return;
        }
        int index = current.length();
        int digit = digits[index] - '0';
        for (char letter : dict[digit].toCharArray()) {
            findSolution(result, dict, digits, current + letter);
        }
    }
}
