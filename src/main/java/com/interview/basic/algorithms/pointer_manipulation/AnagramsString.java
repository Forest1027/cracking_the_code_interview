package com.interview.basic.algorithms.pointer_manipulation;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 438. Find All Anagrams in a String
 * https://leetcode.com/problems/find-all-anagrams-in-a-string/
 */
public class AnagramsString {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new LinkedList<>();
        int sLength = s.length();
        int pLength = p.length();
        if (sLength * pLength == 0 || sLength < pLength) return result;
        Map<Character, Integer> map = getRequiredMap(p);
        Map<Character, Integer> window = new HashMap<>();
        int current = 0;
        int required = map.size();

        for (int i = 0; i < sLength; i++) {
            // if the new element is in p, add it to window
            if (map.containsKey(s.charAt(i))) {
                int count = window.getOrDefault(s.charAt(i), 0);
                window.put(s.charAt(i), count + 1);
                int requiredCount = map.get(s.charAt(i));
                if ((count + 1) == requiredCount) current++;
                else if (count == requiredCount) current--;
            }
            // when the window length becomes fixed at p.length, start to remove element as window goes along
            if (i >= pLength) {
                if (map.containsKey(s.charAt(i - pLength))) {
                    int size = window.get(s.charAt(i - pLength));
                    window.put(s.charAt(i - pLength), size - 1);
                    int requiredCount = map.get(s.charAt(i - pLength));
                    if (size - 1 == requiredCount) current++;
                    else if (size == requiredCount) current--;
                }
            }
            if (current == required) result.add(i - pLength + 1);
        }
        return result;
    }

    private Map<Character, Integer> getRequiredMap(String p) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            int count = map.getOrDefault(p.charAt(i), 0);
            map.put(p.charAt(i), count + 1);
        }
        return map;
    }

    public static void main(String[] args) {
        String s = "abaacbabc";
        String p = "abc";
        AnagramsString sol = new AnagramsString();
        List<Integer> result = sol.findAnagrams(s, p);
        System.out.println(result);
    }
}
