package com.interview.basic.algorithms.recursion;

import java.util.LinkedList;
import java.util.List;

/**
 * 93. Restore IP Addresses
 * https://leetcode.com/problems/restore-ip-addresses/
 */
public class RestoreIPAddresses {
    private String[] tracker = new String[4];
    private int ready = 0;

    public List<String> restoreIpAddresses(String s) {
        List<String> result = new LinkedList<>();
        if (s.length() > 12 || s.length() < 4) return result;
        findSolution(s, 0, result);
        return result;
    }

    private void findSolution(String s, int start, List<String> result) {
        if (ready == 4 && start == s.length()) {
            result.add(String.join(".", tracker));
            return;
        } else if (ready == 4 || start == s.length()) {
            // stop this recursion as no valid result found
            return;
        }
        for (int i = 1; i <= 3 && start + i <= s.length(); i++) {
            String current = s.substring(start, start + i);
            if (isValid(current)) {
                tracker[ready] = current;
                ready++;
                findSolution(s, start + i, result);
                ready--;
                tracker[ready] = null;
            }
        }
    }

    private boolean isValid(String current) {
        int value = Integer.valueOf(current);
        // if number is leading with 0, not valid
        return !((current.length() >= 2 && current.charAt(0) == '0') || value > 255);
    }

    public static void main(String[] args) {
        String s = "255255255255";
        RestoreIPAddresses sol = new RestoreIPAddresses();
        System.out.println(sol.restoreIpAddresses(s));
    }
}
