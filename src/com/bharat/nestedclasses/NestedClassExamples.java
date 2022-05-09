package com.bharat.nestedclasses;


//outer class can access all members of inner class
//inner class can access all members of outer class

// if it is a static nested class then only static variables of outer class can be accessed directly
// otherwise use an object of the outer class to access non-static members
final class Test4 {
    class Inner {
        private final boolean flag = false;
        private void test() {
            if (Test4.this.flag) { //to prevent shadowing of enclosing member variable
                sample();
            }
        }
    }

    private boolean flag = true; // this gets shadowed in inner class, in order to use it use Test4.this.flag

    private void sample() {
        System.out.println("Sample");
    }

    public Test4() {
        (new Inner()).test();
    }

    public static void main(String args[]) {
        new Test4();
    }
}
