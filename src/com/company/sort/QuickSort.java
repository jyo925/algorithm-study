package com.company.sort;

/*
* 분할정복법 중 하나
* MergeSort와 차이점은 항상 중간값을 기준으로 반반 나누는 것이 아닌
* Pivot를 기준으로 나눈다.
* 시간복잡도는 최악의 경우 O(n^2), 항상 절반으로 분할되는 경우 O(nlogn)
* Pivot를 정하는 기준에는 다양한 방법이 있으며  여기서는 마지막 값을 Pivot으로 설정
*
* 1. pivot을 정한다
* 2. pivot 보다 작은 값들은 pivot기준 왼쪽, 큰값들은 오른쪽에 오도록 배치
* 3. 오른쪽, 왼쪽에 대해서 정렬 재귀호출
* 4. 정렬은 마지막 값(피벗)과 앞에서부터 차례대로 비교
* */
public class QuickSort {

    public static void quickSort(int[] arr, int p, int r) {

        if (p < r) {
            int q = partition(arr, p, r); //pivot 기준 정렬 수행해서 pivot 위치 리턴
            quickSort(arr, p, q - 1);
            quickSort(arr, q+1, r);
        }
    }

    private static int partition(int[] arr, int p, int r) {

        //마지막 값을 피벗
        int pivot = arr[r];
        int i = p-1;
        for (int j = p; j < r; j++) {
            //j가 pivot보다 작으면 i+1(큰 값중에 첫번째) 값과 swqp
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        //마지막에 pivot 이동
        swap(arr, i+1, r);
        return i+1;
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {

        int arr[] = {6,3,3,7,1,21,3,7,2,25};
        quickSort(arr, 0, arr.length-1);
        printArr(arr);

        System.out.println(9/2 + "");
    }

    private static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }
}
