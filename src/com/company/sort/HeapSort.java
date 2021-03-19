package com.company.sort;

/*
* 최악의 경우 시간 복잡도 o(nlogn)보장
* 추가 배열 필요 X
* 이진 힙(binary heap) 자료구조 이용
* */
public class HeapSort {

    private static void maxHeapBuild(int[] arr) {
        int length = arr.length;
        // 마지막 노드의 부모 노드에서부터 시작
        for (int i = length / 2; i >= 0; i--) {
            maxHeapify(arr, i, arr.length);
        }
    }

    //두 자식들 중 더 큰 쪽이 부모보다 크면 서로 교환
    private static void maxHeapify(int[] arr, int i, int length) {
        int leftChild = i*2;
        int rightChild = (i*2)+1;
        int k = 0;

        //자식 노드가 없을 경우에는 종료한다.
        //둘다 없거나 왼쪽만 있을 수도 있음
        if(rightChild >= length ||
                (rightChild >= length && leftChild >= length)) {
            return;
        }

        k = (arr[leftChild] > arr[rightChild]) ? leftChild:rightChild;

        //부모 노드가 자식보다 큰 경우 종
        if (arr[i] >= arr[k]) {
            return;
        }
        //swap
        swap(arr, i, k);
        maxHeapify(arr, k, length);
    }


    private static void heapSort(int[] arr) {
        maxHeapBuild(arr);
        //n-1번 반복
        for (int i = arr.length-1; i > 0; i--) {
            swap(arr, 0, i);
            //마지막 힙 제외하고(정렬 완료) maxHeapify 수행 i-1
            maxHeapify(arr, 0, i-1);
        }
    }

    public static void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        int arr[] = { 5, 2, 1, 7, 112, 42, 52, 62, 8, 100 };
        heapSort(arr);
        printArray(arr);
    }
}
