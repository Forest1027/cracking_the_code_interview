package com.interview.basic.algorithms.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * 242. Valid Anagram
 * https://leetcode.com/problems/valid-anagram/
 */
public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        } else {
            Map<Character, Integer> charCount = new HashMap<>();
            for (char element : s.toCharArray()) {
                int count = charCount.getOrDefault(element, 0);
                charCount.put(element, count + 1);
            }

            for (char element : t.toCharArray()) {
                if (!charCount.containsKey(element)) {
                    return false;
                }
                int count = charCount.get(element);
                if (count == 1) {
                    charCount.remove(element);
                } else {
                    charCount.put(element, count - 1);
                }
            }
            return charCount.size() == 0;
        }
    }

    public static void main(String[] args) {
        ValidAnagram solution = new ValidAnagram();
        boolean result = solution.isAnagram("anagram", "nagaram");
        System.out.println(result);
    }
}
