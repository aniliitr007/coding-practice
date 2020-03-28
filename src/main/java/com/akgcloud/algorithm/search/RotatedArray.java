package com.akgcloud.algorithm.search;

public class RotatedArray {

    // search in a sorted array {1, 2, 3, 4, 5, 6}
    public static int binarySearch(int[] a, int low, int high, int key) {

        if (low > high) {
            return -1;
        }
        int mid = (low + high) / 2;

        if (a[mid] == key) {
            return mid;
        }
        if (a[mid] < key) {
            return binarySearch(a, mid + 1, high, key);
        } else {
            return binarySearch(a, low, mid - 1, key);
        }
    }

    // search in a rotated sorted array {3, 4, 5, 6, 1, 2}
    public static int rotatedArrayBinarySearch(int[] a, int low, int high, int key) {

        int pivot = findPivot(a, low, high);

        if (pivot == -1 || key > a[pivot]) {
            return -1;
        }

        if (key == a[pivot]) {
            return pivot;
        }

        if (key >= a[0]) {
            return binarySearch(a, low, pivot - 1, key);
        } else {
            return binarySearch(a, pivot + 1, high, key);
        }

    }

    public static int findPivot(int[] a, int low, int high) {

        if (high < low) {
            return -1;
        }

        if (high == low) {
            return low;
        }

        int mid = (high + low) / 2;

        if (mid < high && a[mid] > a[mid + 1]) {
            return mid;
        }

        if (mid > low && a[mid] < a[mid - 1]) {
            return mid - 1;
        }

        if (a[mid] <= a[low]) {
            return findPivot(a, low, mid - 1);
        } else {
            return findPivot(a, mid + 1, high);
        }
    }

    public static void main(String[] args) {
        int[] a = { 1, 2, 3, 4, 5, 6 };
        int n = a.length;
        // System.out.println(RotatedArray.binarySearch(a, 0, n - 1, 0));

        int[] rotatedArr = { 3, 4, 5, 6, 1, 2 };
        // System.out.println(RotatedArray.findPivot(a, 0, n - 1));

        System.out.println(RotatedArray.rotatedArrayBinarySearch(rotatedArr, 0, n - 1, 0));

    }

}
