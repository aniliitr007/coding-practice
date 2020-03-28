package com.akgcloud.test.flipkart;

import java.util.HashMap;
import java.util.Map;

public class DumbObjectNotation {

    // split with #
    // rupam.ghosh@flipkart.com
    public static Map<String, String> typeMap   = new HashMap<String, String>();
    public static Map<String, String> objectMap = new HashMap<String, String>();

    public static boolean isValidObject(String dataType, String dataObject) {
        if (dataType == null || dataObject == null) {
            return false;
        }

        // parsing data type
        String[] dataTypeStrings = dataType.split("[=]");
        String dataTypeName = dataTypeStrings[0].trim();
        String dataTypeDefString = dataTypeStrings[1].trim();
        String[] dataTypeDefs = dataTypeDefString.split(",");
        Map<String, String> typeAttrMap = new HashMap<String, String>();
        Map<String, String> optionalTypeAttrMap = new HashMap<String, String>();

        for (String typeDef : dataTypeDefs) {
            String[] typeAttrs = typeDef.split("[:]");
            if (typeAttrs[0].indexOf("?") != -1) {
                optionalTypeAttrMap.put(typeAttrs[0].replace("?", ""), typeAttrs[1]);
            } else {
                typeAttrMap.put(typeAttrs[0], typeAttrs[1]);
            }
        }

        // parsing data object
        String[] dataObjString = dataObject.split("[=]");
        String dataObjTypeName = dataObjString[0];
        String[] objStrings = dataObjString[1].split("[|]");
        String dataObjName = objStrings[0].trim();
        String dataObjDefString = objStrings[1].trim();
        String[] objDefs = dataObjDefString.split(",");
        Map<String, String> objAttrMap = new HashMap<String, String>();

        for (String objDef : objDefs) {
            String[] objAttrs = objDef.split("[:]");
            objAttrMap.put(objAttrs[0], objAttrs[1]);
        }

        // validating data
        if (!dataTypeName.equals(dataObjName)) {
            return false;
        }

        if ((objAttrMap.size() < typeAttrMap.size() - optionalTypeAttrMap.size())
                || (objAttrMap.size() > typeAttrMap.size() + optionalTypeAttrMap.size())) {
            return false;
        }

        for (String key : typeAttrMap.keySet()) {
            if (optionalTypeAttrMap.get(key) == null && objAttrMap.get(key) == null) {
                return false;
            }
            String valueType = typeAttrMap.get(key);
            String value = objAttrMap.get(key);
            if ("int".equals(valueType)) {
                try {
                    if (!"_".equals(value)) {
                        Integer.parseInt(value);
                    }
                } catch (Exception e) {
                    return false;
                }
            } else if ("string".equals(valueType)) {
                // do nothing
            } else if ("Division".equals(valueType)) {
                // search if value exists in the entire docs and is of same
                // type;
                if (!objectMap.containsKey(valueType)) {
                    return false;
                }
            } else if ("Employee".equals(valueType)) {
                // search if value exists in the entire docs and is of same
                // type;
                if (!objectMap.containsKey(valueType)) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // make data
        String type = "Employee = id:int, name:string, salary:int";
        String type2 = "Division = id:int, name:string, salary:int xyz?:Employee";
        
        String object = "e1 = Employee|id:007, name:Bond, salary:abc";
        String object2 = "e1 = Division|id:007, name:Bond, salary:_";
        String object3 = "e1 = Division|id:007, name:Bond, salary:_";
        
//        String[] types = type.split("[=]");
//        typeMap.put(types[0].trim(), types[1].trim());
//        String[] objects = object.split("[=]");
//        objectMap.put(objects[0].trim(), objects[1].trim());
//
//        // validate
//        for (String obj : objectMap.keySet()) {
//            String[] dataObjStrings = objectMap.get(obj).split("[|]");
//            System.out.println(DumbObjectNotation.isValidObject(dataObjStrings[0], dataObjStrings[1]));
//        }
         System.out.println(DumbObjectNotation.isValidObject(type, object));
    }
}
