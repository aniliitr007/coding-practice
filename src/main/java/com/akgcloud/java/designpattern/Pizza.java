package com.akgcloud.java.designpattern;

import java.util.ArrayList;
import java.util.List;

public abstract class Pizza {

    public String       name;
    public String       souce;
    public List<String> toppings = new ArrayList<String>();

    public void prepare() {
        System.out.println("Preparing pizza with " + name + " and " + souce);
    }

    public void bake() {
        System.out.println("Baking pizza");
    }

    public void cut() {
        System.out.println("Cutting pizza");
    }

    public void box() {
        System.out.println("Packaging pizza");
    }

}
