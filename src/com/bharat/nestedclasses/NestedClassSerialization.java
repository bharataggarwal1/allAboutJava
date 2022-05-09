package com.bharat.nestedclasses;

import java.io.*;

public class NestedClassSerialization {

    private int a;
    private int b;

    static class StaticNestedClass implements Serializable{
        private int c;
    }

    public static void main(String[] args) throws IOException {
        File file = new File("test.txt");
        StaticNestedClass inner = new StaticNestedClass();
        //can be serialized without dependency on enclosing class
        new ObjectOutputStream(new FileOutputStream(file)).writeObject(inner);
    }

}
