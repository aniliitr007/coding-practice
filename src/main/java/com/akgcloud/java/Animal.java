package com.akgcloud.java;

import java.io.Serializable;

public abstract class Animal implements Serializable {

    public String name;

    public void sounds() {
        System.out.println("Dont know");
    }

    public boolean equals(Object o) {
        return true;
    }

    public boolean equals(Animal o) {
        return false;
    }

    public static void testStatic() {
        System.out.println("static animal");
    }

}
