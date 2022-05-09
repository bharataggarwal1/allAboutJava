package com.bharat.overriding;

class Parent {
    Parent() {
        test();
    }

    public void test() {
        System.out.println("Hello Parent");
    }
}

class Child extends Parent {
    Child() {
        test();
    }

    public void test() {
        System.out.println("Hello Child");
    }
}

public class DynamicDispatchAndConstructorOrdering {

    public static void main(String[] args) {

        Parent p2 = new Parent();
        p2.test();
        System.out.println();
        Parent p = new Child();
        p.test();

        Parent p3 = new Parent();
        //Child c = (Child)p3; //Class Cast Exception -> cannot cast parent object to child class
        System.out.println(p3);

    }
}
