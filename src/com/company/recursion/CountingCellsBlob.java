package com.company.recursion;

/*
* 한 지점이 속한 Blob(좌, 우, 위, 아래, 대각선으로 인접한 색칠된 픽셀 집합)의 픽셀 수 출력
* */
public class CountingCellsBlob {

    private static int BACKGROUND_COLOR = 0; //흰색
    private static int IMAGE_COLOR = 1; //색칠된 픽셀
    private static int ALREADY_COUNTED = 2; //count한 픽셀

    private int n;
    private int[][] grid = {{1,0,0,1}, {0,0,0,1}, {1,1,0,0}, {0,0,0,0}};

    public int countCells(int x, int y) {

        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) {
            return 0;
        } else if (grid[x][y] != IMAGE_COLOR) {
            return 0;
        } else {
            grid[x][y] = ALREADY_COUNTED;
            return 1 + countCells(x - 1, y + 1) + countCells(x, y + 1)
                    + countCells(x + 1, y + 1) + countCells(x - 1, y)
                    + countCells(x + 1, y) + countCells(x - 1, y - 1)
                    + countCells(x, y + 1) + countCells(x + 1, y + 1);
        }
    }

    public static void main(String[] args) {
        CountingCellsBlob countingCellsBlob = new CountingCellsBlob();
        System.out.println(countingCellsBlob.countCells(2,0));

    }
}
