package com.interview.basic.algorithms.trie;

/**
 * 1032. Stream of Characters
 * https://leetcode.com/problems/stream-of-characters/
 */
public class StreamChecker {
    private Trie t;
    private StringBuilder sb;

    public StreamChecker(String[] words) {
        this.t = new Trie(new Node('\0'));
        for (String word : words) {
            t.insert(word);
        }
        this.sb = new StringBuilder();
    }

    /**
     * TC: O(M). M is the length of the longest word.
     * SC: O(1)
     */
    public boolean query(char letter) {
        sb.append(letter);
        Node node = t.root;
        for (int i = sb.length() - 1; i >= 0 && node != null; i--) {
            node = node.children[sb.charAt(i) - 'a'];
            if (node != null && node.isEnd) return true;
        }
        return false;
    }

    private class Trie {
        public Node root;

        public Trie(Node root) {
            this.root = root;
        }

        /**
         * TC: O(M). M is the length of the word
         * SC: O(M)
         */
        public void insert(String word) {
            Node node = this.root;
            for (int i = word.length() - 1; i >= 0; i--) {
                if (node.children[word.charAt(i) - 'a'] == null)
                    node.children[word.charAt(i) - 'a'] = new Node(word.charAt(i));
                node = node.children[word.charAt(i) - 'a'];
            }
            node.isEnd = true;
        }

    }

    private class Node {
        public char c;
        public Node[] children = new Node[26];
        public boolean isEnd;

        public Node(char c) {
            this.c = c;
        }
    }

    public static void main(String[] args) {
//["StreamChecker","query","query","query","query","query","query","query","query","query","query","query","query"]
//[[["cd","f","kl"]],["a"],["b"],["c"],["d"],["e"],["f"],["g"],["h"],["i"],["j"],["k"],["l"]]
        String[] words = {"cd", "f", "kl"};
        StreamChecker sc = new StreamChecker(words);
        System.out.println(sc.query('a'));
        System.out.println(sc.query('b'));
        System.out.println(sc.query('c'));
        System.out.println(sc.query('d'));
        System.out.println(sc.query('e'));
        System.out.println(sc.query('f'));
        System.out.println(sc.query('g'));
        System.out.println(sc.query('h'));
        System.out.println(sc.query('i'));
        System.out.println(sc.query('j'));
        System.out.println(sc.query('k'));
        System.out.println(sc.query('l'));
    }
}
