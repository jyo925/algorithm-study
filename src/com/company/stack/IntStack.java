package com.company.stack;

//후입 선출, 포인터 기반, 배열로 구현
public class IntStack {

    private int max;
    private int ptr; //스택 포인터이자 저장된 개수
    private int[] stk;


    public IntStack(int capacity) {
        ptr = 0;
        max = capacity;
        try {
            stk = new int[max];
        } catch (OutOfMemoryError error) {
            max = 0;
        }
    }


    //스택이 비어있는 경우 에러 생성
    public class EmptyIntStackException extends RuntimeException {
        public EmptyIntStackException() {
        }

        ;
    }

    //꽉 찬 경우
    public class OverflowIntStackException extends RuntimeException {
        public OverflowIntStackException() {
        }
    }


    public int push(int x) throws OverflowIntStackException {
        if (ptr >= max) {
            throw new OverflowIntStackException();
        }
        return stk[ptr++] = x;
    }

    public int pop() throws EmptyIntStackException {
        if (ptr <= 0) {
            throw new EmptyIntStackException();
        }
        return stk[--ptr];
    }

    //맨 꼭대기에 있는 데이터 반환
    public int peek() throws EmptyIntStackException {
        if (ptr <= 0) {
            throw new EmptyIntStackException();
        }
        return stk[ptr - 1];
    }

    public int indexOf(int max) {
        for (int i = ptr - 1; i >= 0; i--) {
            if (stk[i] == max) {
                return i;
            }
        }
        return -1;
    }

    public void clear() {
        ptr = 0;
    }

    public int capacity() {
        return max;
    }

    public int size() {
        return ptr;
    }

    public boolean isEmpty() {
        return ptr <= 0;
    }

    public boolean isFull() {
        return ptr >= max;
    }

    public void dump() {
        if (ptr <= 0) {
            System.out.println("스택이 비어 있습니다.");
        } else {
            for (int i = 0; i < ptr; i++) {
                System.out.print(stk[i] + " ");
            }
            System.out.println();
        }
    }


}
