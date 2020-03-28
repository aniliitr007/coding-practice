package com.akgcloud.topcoder;

import java.util.Arrays;

public class BinaryCode {

    // Q[i] = P[i-1] + P[i] + P[i+1] ; P = 011100011 => Q = 123210122
    // Program for decoding
    public String[] decode(String message) {
        String[] decodeArray = new String[2];
        // case1: P[0] = 0
        int val = 0;
        int old1 = 0;
        int old2 = 0;
        String decode1 = "0";
        for (int i = 0; i < message.length(); i++) {
            if (i == 0) {
                old1 = val = Integer.parseInt("" + message.charAt(i)) - old2;// P[1]
            } else {
                val = Integer.parseInt("" + message.charAt(i)) - old1 - old2;
                old2 = old1;
                old1 = val;
            }
            if (val > 1 || val < 0) {
                decode1 = "NONE";
                break;
            } else {
                if (decode1.length() < message.length()) {
                    decode1 += val;
                }
            }
        }
        decodeArray[0] = decode1;

        // case2: P[0] = 1
        val = 0;
        old1 = 0;
        old2 = 1;
        String decode2 = "1";
        for (int i = 0; i < message.length(); i++) {
            if (i == 0) {
                old1 = val = Integer.parseInt("" + message.charAt(i)) - old2;// P[1]
            } else {
                val = Integer.parseInt("" + message.charAt(i)) - old1 - old2;
                old2 = old1;
                old1 = val;
            }
            if (val > 1 || val < 0) {
                decode2 = "NONE";
                break;
            } else {
                if (decode2.length() < message.length()) {
                    decode2 += val;
                }
            }
        }
        decodeArray[1] = decode2;

        return decodeArray;
    }

    public static void main(String[] args) {
        // Ex 11, 22111,12221112222221112221111111112221111
        BinaryCode time = new BinaryCode();
        String[] str = time.decode("22111");
        System.out.println(Arrays.toString(str));
    }
}
