package com.interview.basic.algorithms.pointer_manipulation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 187. Repeated DNA Sequences
 * https://leetcode.com/problems/repeated-dna-sequences/
 */
public class RepeatedDNA {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> tracker = new HashSet<>();
        Set<String> result = new HashSet<>();
        if (s.length() < 11) return new ArrayList<>(result);
        int i = 0;
        StringBuilder sub = new StringBuilder();
        while (i < s.length()) {
            sub.append(s.charAt(i));
            if (i >= 10) {
                sub.deleteCharAt(0);
            }
            if (sub.length() == 10) {
                if (tracker.contains(sub.toString())) result.add(sub.toString());
                else tracker.add(sub.toString());
            }
            i++;
        }
        return new ArrayList<>(result);
    }

    public static void main(String[] args) {
        String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        RepeatedDNA sol = new RepeatedDNA();
        List<String> result = sol.findRepeatedDnaSequences(s);
        System.out.println(result);
    }
}
