package com.bharat.accessModifiers.defaultAccess.package2;

import com.bharat.accessModifiers.defaultAccess.package1.Class1;

public class TestReachability {
    Class1 obj = new Class1();

    public int getNumber() {
        return obj.getNumberOutsidePackage();
//        doesn't work outside package (default access)
//        return obj.getNumber()
    }
}
