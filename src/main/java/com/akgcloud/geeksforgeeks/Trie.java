package com.akgcloud.geeksforgeeks;

public class Trie {

    public static class TrieNode {
        private static final int CHAR_MAX_COUNT = 26;
        private char             label;
        private TrieNode[]       children;
        private boolean          isLeaf;

        public TrieNode(char lab) {
            label = lab;
            children = new TrieNode[CHAR_MAX_COUNT];
            isLeaf = false;
        }
    }

    public int getCharIndex(char c) {
        return (int) c - (int) 'a';
    }

    public void insert(TrieNode root, String word) {
        TrieNode temp = root;
        for (int i = 0; i < word.length(); i++) {
            int index = getCharIndex(word.charAt(i));
            if (temp.children[index] == null) {
                temp.children[index] = new TrieNode(word.charAt(i));
            }
            temp = temp.children[index];
        }
        temp.isLeaf = true;
    }

    public boolean search(TrieNode root, String word) {
        TrieNode temp = root;
        for (int i = 0; i < word.length(); i++) {
            int index = getCharIndex(word.charAt(i));
            if (temp.children[index] == null) {
                return false;
            }
            temp = temp.children[index];
        }
        return temp != null && temp.isLeaf;
    }

    public void displayAllWords(TrieNode root) {
        System.out.println("Displaying all words");
        String word = null;
        for (int i = 0; i < TrieNode.CHAR_MAX_COUNT; i++) {
            TrieNode temp = root;
            word = "";
            if (temp.children[i] != null) {
                temp = temp.children[i];
                for (int j = i; j < TrieNode.CHAR_MAX_COUNT; j++) {
                    if (temp != null) {
                        word = word + temp.children[j].label;
                        temp = temp.children[j];
                        if (temp.children[j].isLeaf) {
                            System.out.println(word);
                        }
                    }
                }
            }
        }
        System.out.println("Finished");
    }

    public static void main(String[] args) {
        TrieNode root = new TrieNode('a');
        Trie trie = new Trie();
        trie.insert(root, "the");
        trie.insert(root, "their");
        // System.out.println("word found : " + trie.search(root, "their"));
        trie.displayAllWords(root);
    }
}
