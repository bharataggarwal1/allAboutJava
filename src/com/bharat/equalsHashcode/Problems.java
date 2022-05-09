package com.bharat.equalsHashcode;

import java.util.Objects;

public class Problems {
    public static void main(String[] args) {
        // JVM caches Integer values from -128 to 127 therefore == behave like equals
        // similarly for Long, JVM caches Long values from -128 to 127
        boolean equal = Objects.equals("sad", null);
    }
}
