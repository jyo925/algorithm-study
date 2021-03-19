package com.company.sort;

public class InsertionSort {

    public static void main(String[] args) {

        int[] a = {0, 5, 10, 105, 100, 120, 34, 45, 77, 99};

        int n = a.length;
        for (int i = 1; i < n; i++) {
            int j;
            int tmp = a[i];
            //왼쪽 요소가 크다면 해당 자리에 왼쪽 요소값을 대입하고 앞으로 이동
            for (j = i; j > 0 && a[j - 1] > tmp; j--) {
                a[j] = a[j - 1];
            }
            a[j] = tmp;
        }

        for (int j = 0; j < a.length; j++) {
            System.out.print(a[j] + ", ");
        }

    }
}
