package com.company.sort;

public class SelectionSort {

    public static void main(String[] args) {

        int[] a = {0, 5, 10, 105, 100, 120, 34, 45, 77, 99};

        int n = a.length;
        for (int i = 0; i < n - 1; i++) {
            int min = i;
            for (int k = i + 1; k < n; k++) {
                if (a[k] < a[min]) {
                    min = k;
                }
            }
            int temp = a[i];
            a[i] = a[min];
            a[min] = temp;
        }

        for (int j = 0; j < a.length; j++) {
            System.out.print(a[j] + ", ");
        }

    }
}
