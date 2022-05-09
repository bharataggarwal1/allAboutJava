package com.bharat.nestedclasses;

interface Vehicle{
    void start();
}
public class TestAnonymousInnerClass {
    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle() {
            @Override
            public void start() {
                System.out.println("Started");
            }
        };
        vehicle.start();
    }
}
