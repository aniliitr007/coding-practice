package com.akgcloud.geeksforgeeks;

class CricketRating {

    public static int getMaxConsistentRating(int[] a) {
        int maxRate = 0;
        int lastIdx = a.length - 1;
        for (int i = 0; i < a.length; i++) {
            int lsum = 0, rsum = 0;
            for (int j = 0; j < a.length; j++) {
                if (j <= i) {
                    if (lsum + a[j] < 0) {
                        lsum = 0;
                    } else {
                        lsum += a[j];
                    }
                }
                if (lastIdx - j > i) {
                    if (rsum + a[lastIdx - j] < 0) {
                        rsum = 0;
                    } else {
                        rsum += a[lastIdx - j];
                    }
                }
            }
            if (maxRate < lsum + rsum) {
                maxRate = lsum + rsum;
            }
        }
        return maxRate;
    }

    public static int getMax(int[] a) {
        int max = 0;
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum = sum + a[i];
            if (sum < 0) {
                sum = 0;
            }
            if (max < sum) {
                max = sum;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] a = { -1, -4, 4, -2, 0, 1, 4, -5 };
        System.out.println("Maxx: " + CricketRating.getMax(a));
    }
}
