package com.akgcloud.java.designpattern;

public class TestPizzaDrive {

    /**
     * @param args
     */
    public static void main(String[] args) {
        PizzaStore nyPizaa = new NYPizzaStore();
        nyPizaa.orderPizza("cheese");
        
        PizzaStore chPizaa = new ChicagoPizzaStore();
        chPizaa.orderPizza("cheese");

    }

}
