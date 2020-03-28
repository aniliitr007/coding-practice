package com.akgcloud.geeksforgeeks;

import java.util.Scanner;

public class SortedSubSequence {

    public static int minMaxSubSequenceCount(int[] a) {
        int count = 0;
        int temp = 0;
        int min = 0;
        for (int i = 0; i < a.length; i++) {
            temp = min = a[i];
            for (int j = i; j < a.length; j++) {
                if (temp <= a[j]) {
                    temp = a[j];
                    count++;
                }
                if (min > a[j]) {
                    break;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = in.nextInt();
        }
        System.out.println(minMaxSubSequenceCount(arr));

    }

}
