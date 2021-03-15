package com.company.search;

import java.util.Scanner;

//Q2
public class SeqSearch2 {

    static int seqSearchSen(int[] a, int n, int key) {

        int i = 0;

        a[n] = key; //보초 추가

        while (true) {
            if (a[i] == key) {
                break;
            }
            i++;
        }

        return (i == n) ? -1 : i;

    }

    public static void main(String[] args) {

        Scanner stdIn = new Scanner(System.in);

        int num = stdIn.nextInt();
        int[] x = new int[num + 1];

        for (int i = 0; i < num; i++) {
            x[i] = stdIn.nextInt();
        }
        System.out.print("  ");
        for (int i = 0; i < num; i++) {
            System.out.print(x[i] + " ");
        }
        System.out.println();

        while (true) {
            int target = stdIn.nextInt(); //검색할 값
            int idx = seqSearchSen(x, num, target);

            for (int i = 0; i <= idx*2+1; i++) {
                    System.out.print(" ");
            }
            System.out.println("*");
            System.out.print(idx + "|");
            for (int i = 0; i < num; i++) {
                System.out.print(x[i] + " ");
            }
            System.out.println();
        }

    }
}
