package com.akgcloud.java;

public class StringPermutation {

    public static void printAllPermutations(String prefix, String s, int count) {
        System.out.println(count);
        int len = s.length();
        if (len == 0) {
            System.out.println(prefix);
        } else {
            for (int i = 0; i < len; i++) {
                printAllPermutations(prefix + s.charAt(i), s.substring(0, i) + s.substring(i + 1, len), count++);
            }
        }
    }

    public static void main(String[] args) {
        String str = "helo";
        StringPermutation.printAllPermutations("", str, 0);
    }

}
