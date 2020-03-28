package com.akgcloud.geeksforgeeks;

import java.util.Arrays;

public class Parenthesis {
    private String str = "";

    /**
     * @param args
     */

    public void printParenthesis(int pos, int n, int open, int close) {
        if (close == n) {
            System.out.println(str);
            return;
        } else {
            if (open < n) {
                str += '{';
                printParenthesis(pos + 1, n, open + 1, close);
            }

            if (open > close) {
                str += '}';
                printParenthesis(pos + 1, n, open, close + 1);
            }
        }
        return;
    }

    public static void main(String[] args) {
        // n = 5
        Parenthesis p = new Parenthesis();
        p.printParenthesis(0, 2, 0, 0);
        // for (int i = 1; i < 5; i++) {
        // Parenthesis.printParenthesis(0, i, 0, 0);
        // }
    }

}
