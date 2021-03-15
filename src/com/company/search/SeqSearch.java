package com.company.search;

import java.util.Scanner;

//선형검색 + 보초법
public class SeqSearch {

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

        System.out.println("요소 개수 입력: ");
        int num = stdIn.nextInt();
        int[] x = new int[num + 1];

        for (int i = 0; i < num; i++) {
            System.out.println("x[" + i + "]");
            x[i] = stdIn.nextInt();
        }

        System.out.println("검색할 값: ");
        int target = stdIn.nextInt();

        int idx = seqSearchSen(x, num, target);

        if (idx == -1) {
            System.out.println("해당 요소가 없습니다.");
        } else {
            System.out.println(target+"은 x[" + idx + "]에 있습니다.");
        }

    }
}
