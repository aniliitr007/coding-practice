package com.akgcloud.test.flipkart;

public class DataTypeFactory {

    public static IDataType getDataTypeInstance(String typeString) {
        if ("Employee".equals(typeString)) {
            return new Employee();
        } else if ("Division".equals(typeString)) {
            return new Division();
        }
        return null;
    }

}
