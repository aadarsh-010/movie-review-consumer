package com.example.demo.config;

public class StringConverter {
    public static String removeSlashes(String jsonString) {
        return jsonString.replace("\\", "");
    }

    public static String cleanJsonString(String jsonString) {
        // Remove outer quotes if present
        if (jsonString.startsWith("\"") && jsonString.endsWith("\"")) {
            jsonString = jsonString.substring(1, jsonString.length() - 1);
        }
        return jsonString;
    }


}
