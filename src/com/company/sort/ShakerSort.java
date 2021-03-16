package com.company.sort;

import java.util.Scanner;

public class ShakerSort {
    // 배열의 요소 a[idx1]과 a[idx2]를 교환
    static void swap(int[] a, int idx1, int idx2) {
        int t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;
    }

    // 양방향 버블정렬(셰이커정렬)
    static void shakerSort(int[] a, int n) {
        //마지막으로 자리를 바꾼 지점을 각각 left, right로 저장
        //뒤에서 부터 앞으로 먼저 정렬을 하면서 마지막에 자리바꾼 위치를 left에 저장
        //left는 즉 앞쪽부터 정렬할 때의 시작점을 나타냄
        //left보다 인덱스가 작은 요소들은 이미 정렬되었기 때문
        int left = 0;
        int right = n - 1;
        int last = right;

        while (left < right) {
            for (int j = right; j > left; j--) {
                if (a[j - 1] > a[j]) { //j-1을 j로 보내기
                    swap(a, j - 1, j);
                    last = j;
                }
            }
            left = last; 

            for (int j = left; j < right; j++) {
                if (a[j] > a[j + 1]) {
                    swap(a, j, j + 1);
                    last = j;
                }
            }
            right = last;
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("양방향 버블정렬(셰이커정렬)");
        System.out.print("요솟수：");
        int nx = stdIn.nextInt();
        int[] x = new int[nx];

        for (int i = 0; i < nx; i++) {
            System.out.print("x[" + i + "]：");
            x[i] = stdIn.nextInt();
        }

        shakerSort(x, nx); // 배열 x를 양방향 버블정렬

        System.out.println("오름차순으로 정렬했습니다.");
        for (int i = 0; i < nx; i++)
            System.out.println("x[" + i + "]＝" + x[i]);
    }
}
