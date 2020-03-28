package com.akgcloud.geeksforgeeks;

import java.util.Arrays;

public class Circle {

    /**
     * @param args A[1,5,2,1,4,0] center = (0, i) radius = A[i] find number of
     *            intersected circle B[2,1,3,1,3,0]
     */
    public static int[] numberOfIntersectedCircle(int[] a) {
        int[] counter = new int[a.length];
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            count = 0;
            for (int j = 0; j < a.length; j++) {
                if (i != j && (Math.abs(a[i] - a[j]) <= Math.abs(i - j)) && (Math.abs(i - j) <= a[i] + a[j])) {
                    count++;
                }
            }
            counter[i] = count;
        }

        return counter;
    }

    public static void main(String[] args) {
        int[] a = { 1, 5, 2, 1, 4, 0 };
        System.out.println(Arrays.toString(Circle.numberOfIntersectedCircle(a)));

    }

}
