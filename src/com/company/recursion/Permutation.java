package com.company.recursion;

/*
 * 순열 구하기
 * a -> b,c,d 순열을 구해서 a를 다 더해주기
 * b -> c,d 순열을 구해서, c - > d, b 순열을 구해서, d -> b,c 순열을 구해서....
 *
 * */
public class Permutation {

    char[] data = {'a', 'b', 'c', 'd'};
    int n = data.length;

    public void perm(int k) {
        
        //마지막 원소일때는 그냥 출력하면 됨
        if (k == n) {
            for (int i = 0; i < n; i++) {
                System.out.print(data[i]+" ");
            }
            System.out.println();
        }
        //k가 0 -> a이면
        //j는 0(1), 1(2), 2(3), 3(4)을 반복
        for (int j = k; j < n; j++) {
            swap(data, k, j); //j가 k인 경우는 swap 안됨 a가 대장인 것 부터 시작
            perm(k + 1); //k가 대장인 경우 그 이후 요소들의 순열을 구하기 위해 재귀 호출함
            swap(data, k, j); //순서를 보장하기 위해 다시 swap
        }
    }

    public void swap(char[] d, int a, int b) {
        char tmp = d[a];
        d[a] = d[b];
        d[b] = tmp;
    }

    public static void main(String[] args) {

        Permutation test = new Permutation();

        test.perm(0);
    }
}
