package com.bharat.algoDesignPatterns.recursion;

import java.util.StringJoiner;

public class Recursion {
    public static void main(String[] args) {
        Recursion r = new Recursion();
        System.out.println("Factorial:" + r.factorial(9));
        r.printFibonacci(50);
    }

    public long factorial(int n) {
        if (n <= 1) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }

    public void printFibonacci(int numberOfElements) {
        int first = 0;
        int second = 1;
        StringJoiner resultString = new StringJoiner(" ");
        if (numberOfElements == 1) {
            resultString.add(first + "");
        } else if (numberOfElements >= 2) {
            resultString.add(first + "").add(second + "");
            calculateRemainingSeries(first, second, numberOfElements - 2, resultString);
            System.out.println("Fibonacci: "+resultString);
        }
    }

    private void calculateRemainingSeries(int first, int second, int remainingElements, StringJoiner resultString) {
        if (remainingElements != 0) {
            int third = first + second;
            resultString.add(third + "");
            calculateRemainingSeries(second, third, remainingElements - 1, resultString);
        }
    }


}
