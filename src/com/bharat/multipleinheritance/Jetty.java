package com.bharat.multipleinheritance;

public class Jetty implements Vehicle,Boat{

    // same default method in both parent interfaces so overriding is mandatory
    // otherwise compile time problem
    @Override
    public void printSpeed() {

    }
}
