package com.interview.basic.algorithms.pointer_manipulation;

import java.util.HashSet;
import java.util.Set;

/**
 * 3. Longest Substring Without Repeating Characters
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 */
public class LongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int left = 0;
        int right = 0;
        int max = 0;
        Set<Character> characters = new HashSet<>();
        while (left < s.length() && right < s.length()) {
            System.out.println("loop");
            if (!characters.contains(s.charAt(right))) {
                characters.add(s.charAt(right));
                right++;
                if (max < characters.size()) {
                    max = characters.size();
                }
            } else {
                left++;
                right = left;
                characters = new HashSet<>();
            }
        }
        return max;
    }

    public static void main(String[] args) {
        LongestSubstring longestSubstring = new LongestSubstring();
        int result = longestSubstring.lengthOfLongestSubstring("abcabcbb");
        System.out.println(result);
    }
}
