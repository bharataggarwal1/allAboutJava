package com.bharat.overload;

class Test {
    public void print(Object a) {
        System.out.println(a);
    }

    public void print(String a) {
        System.out.println(a);
    }

    //uncomment and see compile error while passing null
//    public void print(Long a) {
//        System.out.println(a);
//    }


}

public class FunctionOverloading {
    public static void main(String[] args) {
        Test t = new Test();
        t.print(null);
        // if argument belongs to both parent class and child class -> then child class argument is selected
        // if argument belongs to two different classes -> then passing "null" will produce compile error
        t.print(1);
    }
}
