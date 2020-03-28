package com.akgcloud.java.application;

import java.util.Locale;
import java.util.ResourceBundle;

public class InternationalizationDemo {
    public static void main(String[] args) {

        ResourceBundle bundle = ResourceBundle.getBundle("atb.MessageBundle", Locale.US);
        System.out.println("Message in " + Locale.US + ":" + bundle.getString("greeting"));

        // changing the default locale to indonasian
        Locale.setDefault(new Locale("in", "ID"));
        bundle = ResourceBundle.getBundle("atb.MessageBundle");
        System.out.println("Message in " + Locale.getDefault() + ":" + bundle.getString("greeting"));
        System.out.println(bundle.getString("name"));
        
    }
}