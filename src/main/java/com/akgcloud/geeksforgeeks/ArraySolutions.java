package com.akgcloud.geeksforgeeks;

public class ArraySolutions {

    /**
     * @param args
     */
    public int findReplacedIndex(int[] a) {
        int idx = -1;
        int oCount = 0;
        int rCount = 0;// replaced count
        int cur = -1;
        int prev = -1;
        for (int i = 0; i < a.length; i++) {
            cur = a[i];

            if (cur == 1 && prev != 0) {
                oCount++;
            }

            if (cur == 1 && prev == 0) {
                oCount++;
            }

            if (cur == 0 && prev == 0) {
                rCount++;
            }

            prev = cur;
        }
        return idx;
    }

    /*
     * QuickSort
     */

    public static void quickSort(int[] a, int l, int h) {
        if (l > h) {
            return;
        }

        int i = l, j = h;
        int p = a[l + (h - l) / 2];

        while (i <= j) {
            while (a[i] < p) {
                i++;
            }
            while (a[j] > p) {
                j--;
            }
            if (i <= j) {
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
                i++;
                j--;
            }
        }

        if (l < j) {
            quickSort(a, l, j);
        }
        if (h > i) {
            quickSort(a, i, h);
        }
    }

    public static void printArray(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + ",");
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] x = { 9, 2, 4, 7, 3, 7, 10 };
        ArraySolutions.quickSort(x, 0, x.length - 1);
        ArraySolutions.printArray(x);

    }

}
