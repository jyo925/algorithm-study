package com.company.search;

import java.util.Arrays;
import java.util.Scanner;

//Arrays의 binarySearch 이용
//실패 시 삽입 포인트 값 -x-1 출력하도록
public class BinarySearchTester {

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

        int idx = Arrays.binarySearch(x, target);

        if (idx < 0) {
            System.out.println("해당 요소가 없습니다. 삽입 포인트는 " + idx + "번째 입니다.");
        } else {
            System.out.println(target+"은 x[" + idx + "]에 있습니다.");
        }


    }
}
