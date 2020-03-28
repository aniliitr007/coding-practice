package com.akgcloud.java.designpattern;

public class SingletonClass {

    private SingletonClass singleton = null;

    private SingletonClass() {
    }

    public SingletonClass getInstance() {
        if (singleton == null) {
            synchronized (singleton) {
                if (singleton == null) {
                    singleton = new SingletonClass();
                }
            }
        }
        return singleton;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
