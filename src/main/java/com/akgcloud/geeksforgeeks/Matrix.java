package com.akgcloud.geeksforgeeks;

public class Matrix {

    // mXn matrix diagonally opposite trace count
    public int allTraceCount(int m, int n) {
        if (m == 1 || n == 1) {
            return 1;
        }
        return allTraceCount(m - 1, n) + allTraceCount(m, n - 1);
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Matrix mat = new Matrix();
        System.out.println(mat.allTraceCount(3, 4));

    }

}
