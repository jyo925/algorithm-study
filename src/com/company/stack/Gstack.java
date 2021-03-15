package com.company.stack;

import java.lang.reflect.Array;

//Q2
//제네릭 스택 클래스
public class Gstack<E> {

    private int max;
    private int ptr;
    private E[] stk;

    public Gstack(int capacity) {
        this.max = capacity;
        ptr = 0;
        try {
            stk = (E[]) new Object[max];
        } catch (OutOfMemoryError error) {
            max = 0;
        }
    }

    // 실행할 때 예외：스택이 비어 있음
    public static class EmptyGstackException extends RuntimeException {
        public EmptyGstackException() {
        }
    }

    // 실행할 때 예외：스택이 가득 참
    public static class OverflowGstackException extends RuntimeException {
        public OverflowGstackException() {
        }
    }

    // 스택에 x를 푸시
    public E push(E x) throws OverflowGstackException {
        if (ptr >= max) // 스택이 가득 참
            throw new OverflowGstackException();
        return stk[ptr++] = x;
    }

    // 스택에서 데이터를 팝 (꼭대기의 데이터를 꺼냄)
    public E pop() throws EmptyGstackException {
        if (ptr <= 0) // 스택이 비어 있음
            throw new EmptyGstackException();
        return stk[--ptr];
    }

    // 스택에서 데이터를 피크(꼭대기의 데이터를 살펴 봄)
    public E peek() throws EmptyGstackException {
        if (ptr <= 0) // 스택이 비어 있음
            throw new EmptyGstackException();
        return stk[ptr - 1];
    }

    // 스택에서 x를 검색하여 index(찾지 못하면 -1)를 반환
    public int indexOf(E x) {
        for (int i = ptr - 1; i >= 0; i--) // 꼭대기쪽부터 선형 검색
            if (stk[i].equals(x)) //equals로 비교할것
                return i;  
        return -1;  
    }

    // 스택을 비움
    public void clear() {
        ptr = 0;
    }

    // 스택의 용량을 반환
    public int capacity() {
        return max;
    }

    // 스택에 쌓여있는 데이터 수를 반환
    public int size() {
        return ptr;
    }

    // 스택이 비어 있는가?
    public boolean isEmpty() {
        return ptr <= 0;
    }

    // 스택이 가득 찼는가?
    public boolean isFull() {
        return ptr >= max;
    }

    // 스택 안의 데이터를 바닥→꼭대기의 차례로 출력함
    public void dump() {
        if (ptr <= 0)
            System.out.println("스택이 비었습니다.");
        else {
            for (int i = 0; i < ptr; i++)
                System.out.print(stk[i] + " ");
            System.out.println();
        }
    }

}
