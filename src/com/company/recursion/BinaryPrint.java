package com.company.recursion;

public class BinaryPrint {

    void printInBinary(int n) {
        if (n < 2) {
            System.out.print(n);
        } else {
            printInBinary(n / 2);   //p(10) p(5) p(2) p(1) -> 1 0 1 0
            System.out.print(n%2);
        }
    }

    public static void main(String[] args) {

        new BinaryPrint().printInBinary(10);

    }
}
