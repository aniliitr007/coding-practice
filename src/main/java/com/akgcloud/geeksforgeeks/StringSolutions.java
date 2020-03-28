package com.akgcloud.geeksforgeeks;

public class StringSolutions {

    public String reverseAllWords(char[] str) {
        
        return null;
    }

    public String reverseString(char[] str, int start, int end) {
        while (start < end) {
            char temp = str[start];
            str[start++] = str[end];
            str[end--] = temp;
        }
        return str.toString();
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
