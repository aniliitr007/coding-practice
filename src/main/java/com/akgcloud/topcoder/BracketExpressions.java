package com.akgcloud.topcoder;

import java.util.Stack;

public class BracketExpressions {

    public static String ifPossible(String expression) {
        boolean possible = false;
        Stack<Character> stack = new Stack<Character>();
        int a = 0, b = 10, c = 100;
        int xCount = 0;
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                if (stack.pop() != '(') {
                    possible = false;
                    break;
                }
            } else if (ch == '{') {
                stack.push(ch);
            } else if (ch == '}') {
                if (stack.pop() != '{') {
                    possible = false;
                    break;
                }
            } else if (ch == '[') {
                stack.push(ch);
            } else if (ch == ']') {
                if (stack.pop() != '[') {
                    possible = false;
                    break;
                }
            } else if (ch == 'X') {
                xCount++;
            }

            if (a + xCount < 0 || b + xCount < 10 || c + xCount < 100) {
                possible = false;
                break;
            }

            if (a == 0 && b == 0 && c == 0) {
                if (xCount > 0) {
                    possible = false;
                }
            }
        }
        if (possible) {
            return "possible";
        } else {
            return "impossible";
        }
    }

    public static void main(String[] args) {
        System.out.println(BracketExpressions.ifPossible("{}"));
    }
}
