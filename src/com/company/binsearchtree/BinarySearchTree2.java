package com.company.binsearchtree;

//https://kim6394.tistory.com/223 참고
//delete 남음

/**
 * 이진 검색 트리 구현
 * 각 노드의 자식이 2개 이하이며, 왼쪽 자식은 부모보다 작고 오른쪽 자식은 부모보다 크다.
 * 1. Dynamic Set을 트리 형태로 구현 (Search, Insert, Delete)
 * 이때 시간 복잡도는 O(logN)~O(N)
 * 2. 이진 트리처럼 순회 기능도 구현하기
 * 3. delete 구현이 까다로움
 * - 자식이 없으면 그냥 삭제
 * - 자식이 1개이면 자식을 자기 위치로 올리기
 * - 자식이 2개이면 successor를 찾아서 자기 위치에 복사하고 successor 노드를 삭제하기(case 1 or case2에 해당)
 *
 * 편향된 트리인 경우 O(N)이 소요되므로 이진검색트리를 사용하는 것이 허무해짐
 * -> 최악의 경우에도 O(logN)을 보장하는 RedBlack Tree 등이 있음
 */
public class BinarySearchTree2 {

    public class Node {
        private int data;
        private Node left;
        private Node right;
        private Node parent;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
            this.parent = null;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public Node getParent() {
            return parent;
        }
        
        public void setParent(Node parent) {
            this.parent = parent;
        }
    }


    public Node root;

    public BinarySearchTree2() {
        this.root = null;
    }

    //search 반복ver1(t/f 반환)
    public boolean search(int val) {
        Node tmp = root;
        while (tmp != null) {
            if (tmp.getData() == val) {
                return true;
            } else if (tmp.getData() > val) {
                tmp = tmp.getLeft();
            } else {
                tmp = tmp.getRight();
            }
        }
        return false;
    }

    //search 반복ver2(노드 반환)
    public Node search3(Node treeNode, int val) {
        Node tmp = root;
        while (tmp != null && val != tmp.getData()) {
            if (tmp.getData() > val) {
                tmp = tmp.getLeft();
            } else {
                tmp = tmp.getRight();
            }
        }
        return tmp;
    }

    //search 재귀ver
    public Node search2(Node treeNode, int val) {
        if (treeNode == null || treeNode.getData() == val) {
            return treeNode;
        }
        if (val < treeNode.getData()) {
            return search2(treeNode.getLeft(), val);
        } else {
            return search2(treeNode.getRight(), val);
        }
    }

    //트리 최소값
    public Node treeMinimum(Node root) {
        Node tmp = root;
        while (tmp.getLeft() != null) {
            tmp = tmp.getLeft();
        }
        return tmp;
    }
    //트리 최대값
    public Node treeMaximum(Node root) {
        Node tmp = root;
        while (tmp.getRight() != null) {
            tmp = tmp.getRight();
        }
        return tmp;
    }


    public Node getSuccessor(Node delete) {
        Node x = delete;
        //오른쪽 부트리가 존재하는 경우
        if (x.getRight() != null) {
            return treeMinimum(x.getRight());
        }
        //오른쪽 부트리가 없는 경우
        Node y = x.getParent();
        while (y != null && x == y.getRight()) {
            x = y;
            y = y.getParent();
        }
        return y;
        //부모를 따라 루트까지 올라가면서 그 노드가 처음으로 누군가의 왼쪽 자식이 된다면
        //그 노드의 부모 노드가 답
        //부모노드를 알 수 있어야함... insert 부터 수정하기
        //두 경우 존재하지 않으면 succssor는 존재하지 않음

    }

    //insert
    public void insert(int val) {
        Node newNode = new Node(val);

        if (root == null) {
            root = newNode;
            return;
        }
        Node current = root;
        Node parent = null;

        while (true) {
            parent = current;
            if (val < current.getData()) {
                current = current.getLeft();
                if (current == null) {
                    parent.setLeft(newNode);
                    newNode.setParent(parent);
                    break;
                }
            } else {
                current = current.getRight();
                if (current == null) {
                    parent.setRight(newNode);
                    newNode.setParent(parent);
                    break;
                }
            }
        }
    }

    //delete
    public boolean delete(int val) {
        Node parent = root;
        Node current = root;

        boolean isLeftChild = false;

        //트리에서 val 찾기
        while (current.getData() != val) {
            parent = current;
            if (current.getData() > val) {
                isLeftChild = true;
                current = current.getLeft();
            } else {
                isLeftChild = false;
                current = current.getRight();
            }
            if (current == null) {
                return false;
            }
        }

        //case1 자식 노드가 없는 경우
        if (current.getLeft() == null && current.getRight() == null) {
            if (current == root) {
                root = null;
            }
            if (isLeftChild) {
                parent.setLeft(null);
            } else {
                parent.setRight(null);
            }
        }
        //case2 1개의 자식을 갖는 경우
        else if (current.getRight() == null) {
            if (current == root) {
                root = current.getLeft();
            } else if (isLeftChild) {
                parent.setLeft(current.getLeft());
            } else {
                parent.setRight(current.getLeft());
            }
        } else if (current.getLeft() == null) {
            if (current == root) {
                root = current.getRight();
            } else if (isLeftChild) {
                parent.setLeft(current.getRight());
            } else {
                parent.setRight(current.getRight());
            }
        }
        //case3 두개의 자식을 갖는 경우



        return false;
    }



    //inoder 순회
    public void display(Node root) {
        if (root != null) {
            display(root.getLeft());
            System.out.print(" " + root.getData());
            display(root.getRight());
        }
    }

    public static void main(String[] args) {

        BinarySearchTree2 tree = new BinarySearchTree2();

        //트리에 노드 삽입
        tree.insert(3);
        tree.insert(8);
        tree.insert(4);
        tree.insert(1);
        tree.insert(6);
        tree.insert(2);
        tree.insert(10);
        tree.insert(9);
        tree.insert(20);
        tree.insert(25);
        tree.insert(16);
        tree.insert(15);

        System.out.print("트리 삽입 결과: ");
        tree.display(tree.root);

        System.out.println();
        System.out.println("트리에서 4 탐색: " + tree.search(4));
        System.out.println("트리에서 4 탐색: " + tree.search3(tree.root, 4).getData());
        System.out.println("트리에서 부모노드값: " + tree.search3(tree.root, 10).getParent().getData());

        try {
            System.out.println("트리에서 6 탐색: " + tree.search2(tree.root, 100).getData());
        } catch (NullPointerException e) {
            System.out.println("탐색 결과가 없습니다.");
        }

        System.out.println("트리 최소값 탐색: " + tree.treeMinimum(tree.root).getData());
        System.out.println("트리 최대값 탐색: " + tree.treeMaximum(tree.root).getData());

        System.out.println("successor 값: " + tree.getSuccessor(tree.search3(tree.root, 10)).getData());

    }

}
