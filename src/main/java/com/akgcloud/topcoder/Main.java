package com.akgcloud.topcoder;

public class Main {

    public static void recursiveCall(int i) {
        
        if (i < 4) {
            recursiveCall(i + 1);
            
        }
        System.out.println(i);
    }

    public static void main(String[] args) {
        Main.recursiveCall(0);
    }
}
