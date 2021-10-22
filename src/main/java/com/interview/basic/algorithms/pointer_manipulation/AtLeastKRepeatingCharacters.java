package com.interview.basic.algorithms.pointer_manipulation;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 395. Longest Substring with At Least K Repeating Characters
 * https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/
 */
public class AtLeastKRepeatingCharacters {
    public int longestSubstring(String s, int k) {
        int maxUnique = getMaxUnique(s);
        int max = 0;
        for (int currUnique = 1; currUnique <= maxUnique; currUnique++) {
            int start = 0;
            int end = 0;
            Map<Character, Integer> map = new HashMap<>();
            int countOfValid = 0;
            while (end < s.length()) {
                if (map.size() <= currUnique) {
                    // expand
                    int count = map.getOrDefault(s.charAt(end), 0);
                    map.put(s.charAt(end), count + 1);
                    if (map.get(s.charAt(end)) == k) countOfValid++;
                    end++;
                } else {
                    // shrink
                    int count = map.get(s.charAt(start));
                    if (count - 1 == 0) map.remove(s.charAt(start));
                    else map.put(s.charAt(start), count - 1);
                    start++;
                    if (count == k) countOfValid--;
                }
                if (countOfValid == currUnique && countOfValid == map.size()) {
                    max = Math.max(max, end - start);
                }
            }
        }
        return max;
    }

    private int getMaxUnique(String s) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char character = s.charAt(i);
            set.add(character);
        }
        return set.size();
    }

    public static void main(String[] args) {
        String s= "aaaaaaaaabbbcccccddddd";
        int k = 5;
        AtLeastKRepeatingCharacters sol = new AtLeastKRepeatingCharacters();
        int i = sol.longestSubstring(s, k);
        System.out.println(i);
    }
}
