package com.akgcloud.test.flipkart;

import java.util.HashMap;
import java.util.Map;

public class TestRun2 {

    public String employeeType   = "Employee = id:int, name:string, salary:int";
    public String employeeObject = "e1 = Employee|id:007, name:Bond, salary:700700";

    public boolean isValidObject(String type, String obj) {
        if (type == null || obj == null) {
            return false;
        }
        
        Map<String, Map<String, String>> attributeTypeMap = getAttributeMap(type, "type");
        Map<String, Map<String, String>> attributeObjMap = getAttributeMap(obj, "obj");
        Map<String, String> empTypeMap = attributeTypeMap.get("Employee");
        Map<String, String> empObjMap = attributeTypeMap.get("Employee");

        String[] objStrings = obj.split("[|]");
        String objName = objStrings[0].trim();
        String objDefString = objStrings[1].trim();
        String[] objDefs = objDefString.split(",");
        Map<String, String> objAttrMap = new HashMap<String, String>();

        for (String objDef : objDefs) {
            String[] objAttrs = objDef.split("[:]");
            objAttrMap.put(objAttrs[0], objAttrs[1]);
        }

//        if (!typeName.equals(objName) || typeAttrMap.size() != objAttrMap.size()) {
//            return false;
//        }
//
//        for (String key : typeAttrMap.keySet()) {
//            if (objAttrMap.get(key) == null) {
//                return false;
//            }
//            String valueType = typeAttrMap.get(key);
//            String value = objAttrMap.get(key);
//            if ("int".equals(valueType)) {
//                try {
//                    if (value != null) {
//                        Integer.parseInt(value);
//                    }
//                } catch (Exception e) {
//                    return false;
//                }
//            } else if ("otherType".equals(valueType)) {
//
//            }
//        }
        return true;
    }

    public Map<String, Map<String, String>> getAttributeMap(String param, String paramType) {
        Map<String, Map<String, String>> nameToAttributeMap = new HashMap<String, Map<String, String>>();
        Map<String, String> typeAttrMap = new HashMap<String, String>();
        String[] typeStrings = null;
        if ("type".equals(paramType)) {
            typeStrings = param.split("[=]");
        } else {
            typeStrings = param.split("[|]");
        }
        String typeName = typeStrings[0].trim();
        String typeDefString = typeStrings[1].trim();
        String[] typeDefs = typeDefString.split(",");

        for (String typeDef : typeDefs) {
            String[] typeAttrs = typeDef.split("[:]");
            typeAttrMap.put(typeAttrs[0], typeAttrs[1]);
        }
        nameToAttributeMap.put(typeName, typeAttrMap);
        return nameToAttributeMap;
    }
    

    public static void main(String[] args) {
        String type = "Employee = id:int, name:string, salary:int";
        String object = "Employee|id:007, name:Bond, salary:700700";
        DumbObjectNotation test = new DumbObjectNotation();
        System.out.println(test.isValidObject(type, object));
    }

}
