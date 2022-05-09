package com.bharat;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        // New features
        var x = new HashMap<String, Object>();
        Map.Entry<String, String> entry = Map.entry("bharat", "value");
        Map<String, String> stringStringMap = Map.ofEntries(entry);

    }
}
