package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner kb = new Scanner(System.in);

        String col_row = kb.next();

        int col = col_row.charAt(0) - 'a' + 1;
        int row = Integer.parseInt(String.valueOf(col_row.charAt(1)));

        int[][] list = {{-2, -1}, {-1, -2}, {1, -2}, {2, -1}, {2, 1}, {1, 2}, {-1, 2}, {-2, 1}};

        int result = 0;

        for (int i = 0; i < list.length; i++) {
//            System.out.println(list[i][0] + " " + list[i][1]);
            int next_row = row + list[i][0];
            int next_col = row + list[i][1];
            if (next_row >= 1 && next_row <= 8 && next_col >= 1 && next_col <= 8) {
                result += 1;
            }
        }

        System.out.println("가능한 경우의 수는 " + result + "입니다.");
    }
}
