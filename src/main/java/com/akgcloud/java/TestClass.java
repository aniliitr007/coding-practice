package com.akgcloud.java;

/* IMPORTANT: Multiple classes and nested static classes are supported */
// imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;

class TestClass {
    public static void main(String args[]) throws Exception {
        /*
         * Read input from stdin and provide input before running Use either of
         * these methods for input
         */

        // BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        String inp[] = br.readLine().split(" ");
        int arr[] = new int[N];
        arr[0] = Integer.parseInt(inp[0]);

        int minGrp = 1;
        for (int i = 1; i < N; i++) {
            arr[i] = Integer.parseInt(inp[i]);
            if (arr[i] < arr[i - 1]) {
                minGrp++;
            }
        }

        System.out.println(minGrp);
    }
}
