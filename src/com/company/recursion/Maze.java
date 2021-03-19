package com.company.recursion;

/*
미로 찾기
*/
public class Maze {

    private int N = 8;
    private int maze[][] = {
            {0, 0, 0, 0, 0, 0, 0, 1},
            {0, 1, 1, 0, 1, 1, 0, 1},
            {0, 0, 0, 1, 0, 0, 0, 1},
            {0, 1, 0, 0, 1, 1, 0, 0},
            {0, 1, 1, 1, 0, 0, 1, 1},
            {0, 1, 0, 0, 0, 1, 0, 1},
            {0, 0, 0, 1, 0, 0, 0, 1},
            {0, 1, 1, 1, 0, 1, 0, 0}
    };

    final int PATHWAY_COLOUR = 0; // white -> 이동 가능
    final int WALL_COLOUR = 1; // blue -> 벽
    final int BLOCKED_COLOUR = 2; // red -> 불가능한 경로
    final int PATH_COLOUR = 3; // green -> 가능한 경로

    public boolean findMazePath(int x, int y) {
        //범위를 벗어나거나 이동가능 경로가 아니라면?
        //가능한 경로 3인 경우에도 이미 다녀온 경우는 다시 방문하지 않기 위해
        if (x < 0 || y < 0 || x >= N || y >= N || maze[x][y] != PATHWAY_COLOUR)
            return false;
        //x,y가 N-1좌표이면 모두 탈출
        else if (x == N - 1 && y == N - 1) {
            maze[x][y] = PATH_COLOUR;
            return true;
        } else {
            //방문표시
            maze[x][y] = PATH_COLOUR;
            //인접한 4방향에 대해서 재귀호출
            if (findMazePath(x - 1, y) || findMazePath(x, y + 1)
                    || findMazePath(x + 1, y) || findMazePath(x, y - 1)) {
                return true;
            }
            maze[x][y] = BLOCKED_COLOUR; // dead end
            return false;
        }
    }

    public void printMaze() {
        for (int i = 0; i < maze.length; i++) {
            for (int k = 0; k < maze[i].length; k++) {
                System.out.print(maze[i][k] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Maze test = new Maze();
        test.findMazePath(0,0);
        test.printMaze();
    }

}
