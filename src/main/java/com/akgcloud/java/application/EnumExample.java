package com.akgcloud.java.application;

public enum EnumExample {

    ONE("A", "Apple"),

    TWO("B", "Book"), ;

    private String serial;

    private String displayString;

    EnumExample(String srl, String dispString) {
        serial = srl;
        displayString = dispString;
    }

    public String getSerial() {
        return serial;
    }

    public String getDisplayString() {
        return displayString;
    }

    public void setDisplayString(String str) {
        displayString = str;
    }

    public static void main(String[] args) {
        for (EnumExample enm : EnumExample.values()) {
            System.out.println(enm.getDisplayString());
        }
        EnumExample.ONE.setDisplayString("Axe");
        for (EnumExample enm : EnumExample.values()) {
            System.out.println(enm.getDisplayString());
        }
        EnumExample.ONE.setDisplayString("test");
        for (EnumExample enm : EnumExample.values()) {
            System.out.println(enm.getDisplayString());
        }
    }
}
