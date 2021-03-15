package com.company.recursion;

/*
 * 멱집합(모든 부분집합의 집합을 구하기)
 * */
public class Powerset {

    private static char[] data = {'a', 'b', 'c', 'd', 'e', 'f'};
    private static int n = data.length;
    private static boolean[] include = new boolean[n];
    private static int count = 0;

    public static void powerset(int k) {

        //k가 배열 맨끝 요소의 다음을 가리킨다면 s가 공집합임
        if (k == n) {
            for (int i = 0; i < n; i++) {
                if (include[i]) {
                    System.out.print(data[i] + " ");
                }
            }
            count++;
            System.out.println();
            return;
        }
        //data[k]를 포함하지 않는 경우(왼쪽 자식노드)
        include[k] = false; //현재 원소(노드)를 포함 X
        powerset(k + 1);
        //포함하는 경우(오른쪽 자식 노드)
        include[k] = true;
        powerset(k + 1);

    }

    public static void main(String[] args) {
        Powerset.powerset(0);
        int a = Powerset.data.length;
        System.out.println(Powerset.count);
        System.out.println(Powerset.count == Math.pow(2, a));
    }
}
