package com.company.recursion;

/*
 * 하나의 퀸이 위치하면 좌, 우, 위, 아래, 대각선에 다른 퀸이 존재할 수 없음
 * N*N에서 퀸들이 위치할 수 있는 가능한 위치를 출력
 * Backtracking, recursion
 * */
public class NQeens {

    private int n;
    private int[] cols;  //각 level 마다 정답이 몇번째 열인지 저장

    public NQeens(int n) {
        this.n = n;
        cols = new int[n + 1];
    }

    //level 0부터 시작하는데 0에서 1번말 확정, 1에서 2번말 확정,,,,,7(n-1)에서 8번말 확정
    public boolean queens(int level) {
        if (!promising(level)) { //더이상 아래 노드를 탐색할 필요가 없는 경우(infeasible)
            return false;
        } else if (level == n) { //n이 level과 같다면 마지막 = 다 찾음
            for (int i = 1; i <= n; i++) {
                System.out.println("(" + i + "," + cols[i] + ")");
            }
            return true;
        }
        //마지막도 아니고 not infeasible인 경우 재귀로 자식노드들을 탐색
        for (int i = 1; i <= n; i++) {
            cols[level + 1] = i; //i번째 열
            //여기서 if를 걸면 경우의 수를 한가지만 찾음...
            //if가 없으면 경우의 수를 다 찾으나 이후 cols값이 이상함
            // (아마 마지막노드까지 순회하면서 값을 업데이트해서 모두4가 나오는듯)
            if (queens(level + 1)) {
                return true;
            }
        }

        return false;

    }

    private boolean promising(int level) {
        for (int i = 1; i < level; i++) {
            if (cols[i] == cols[level]) { //같은 열인 경우
                return false;
            } else if (level - i == Math.abs(cols[level] - cols[i])) { //대각선인 경우
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        NQeens test = new NQeens(4);
        test.queens(0);

        for (int i = 1; i < test.cols.length; i++) {
            System.out.println(test.cols[i]);
        }
    }

}
