package com.company.search;

import java.util.Scanner;

//Q5
//이진검색 결과가 동일 값이 있을 때 가장 첫 요소를 반환하도록 수정
public class BinSearch2 {

    static int binSearch(int[] a, int n, int key) {

        int start = 0;
        int end = n - 1;

        do {
            int mid = (start + end) / 2; //중앙값
            if (a[mid] == key) {
                while (true) {
                    if (a[mid] == a[mid - 1]) {
                        mid = mid -1;
                        continue;
                    }
                    break;
                }
                return mid;
            } else if (a[mid] < key) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        } while (start <= end);

        return -1;
    }

    public static void main(String[] args) {

        Scanner stdIn = new Scanner(System.in);

        System.out.println("요소 개수 입력: ");
        int num = stdIn.nextInt();
        int[] x = new int[num];

        System.out.println("오름차순으로 입력하세요.");

        System.out.print("x[0]: ");
        x[0] = stdIn.nextInt();

        for (int i = 1; i < num; i++) {
            do {
                System.out.print("x[" + i + "]: ");
                x[i] = stdIn.nextInt();
            } while (x[i] < x[i - 1]); //이전 요소보다 작은 값이 들어오면 재입력 받기
        }

        System.out.println("검색할 값: ");
        int target = stdIn.nextInt();

        int idx = binSearch(x, num, target);

        if (idx == -1) {
            System.out.println("해당 요소가 없습니다.");
        } else {
            System.out.println(target+"은 x[" + idx + "]에 있습니다.");
        }
    }

}
