package com.company.sort;

public class BubbleSort {


    public static void main(String[] args) {


        int[] a = {0, 5, 10, 34, 45, 77, 99, 105, 100, 120};

        for (int i = 0; i < a.length - 1; i++) { //n-1번 반복
            for (int j = a.length - 1; j > i; j--) {
                if (a[j] < a[j - 1]) {
                    int tmp = a[j];
                    a[j] = a[j - 1];
                    a[j - 1] = tmp;
                }
            }
        }

//        int count = 0;
//        for (int i = a.length - 1 ; i > 0; i--) { //n-1번 반복 i
//            int exchg = 0;
//            count ++;
//            for (int j = 0; j < i; j++) {
//                if (a[j] > a[j + 1]) {
//                    int tmp = a[j];
//                    a[j] = a[j + 1];
//                    a[j + 1] = tmp;
//                    exchg++;
//                }
//            }
//            if(exchg ==0) break;
//        }


        int k = 0;
        int n = a.length;
        while (k < n - 1) {
            int last = n - 1;
            for (int j = n - 1; j > k; j--) {
                if (a[j] < a[j - 1]) {
                    int tmp = a[j];
                    a[j] = a[j - 1];
                    a[j - 1] = tmp;
                    last = j;
                }
            }
            k = last;
        }


        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + ", ");
        }
    }
}
