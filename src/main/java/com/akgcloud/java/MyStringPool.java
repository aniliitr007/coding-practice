package com.akgcloud.java;

public class MyStringPool {

    /**
     * @param args
     */
    public static void main(String[] args) {
        String str1 = "P";
        String str2 = "P";
        String str3 = new String("A");
        str1 = new String("A");

        System.out.println(str1 == str2);
        System.out.println(str1.equals(str2));
        System.out.println(str1 == str3);
        System.out.println(str1.equals(str3));

    }

}
