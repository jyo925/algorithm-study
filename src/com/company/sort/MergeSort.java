package com.company.sort;

/*
 * 분할정복법 중 하나
 * 시간복잡도 NlogN
 * 1. 절반으로 나눈다
 * 2. 정렬한다.
 * 3. 병합한다.
 * */
public class MergeSort {

    public static void mergeSort(int arr[], int l, int r) {
        if (l < r) {
            int mid = (l + r) / 2;  //arr 8
            mergeSort(arr, l, mid);   // (0, 3) -> (0, 1)/(2, 3)
            mergeSort(arr, mid + 1, r); //(4, 8)
            merge(arr, l, mid, r);
        }
    }

    public static void merge(int arr[], int l, int mid, int r) {
        int i = l;
        int j = mid + 1;
        int k = l;
 
        int temp[] = new int[arr.length];
 
        while (i <= mid && j <= r) {
            if (arr[i] < arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }
        
        //j가 먼저 다 정렬되버린 경우 나머지 정렬
        while (i <= mid)
            temp[k++] = arr[i++];
        //i가 먼저 다 정렬되버린 경우
        while (j <= r)
            temp[k++] = arr[j++];
        
        //원래 배열에 값을 복사
        for (int index = l; index < k; index++)
            arr[index] = temp[index];
    }

    public static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int arr[] = {6,3,3,7,1,21,3,7,2,25};
        mergeSort(arr, 0, arr.length - 1);
        printArray(arr);
    }

}
