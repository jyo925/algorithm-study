package com.company.binsearchtree;

//https://kim6394.tistory.com/223 참고
//노드가 주어졌을 때 그 노드의 서브 트리에서 최소값
//노드가 주어졌을 때 그 노드의 서브 트리에서 최대값
//successor 구하기

public class BinarySearchTree2 {

    public class Node {
        private int data;
        private Node left;
        private Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
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
    }


    public Node root;

    public BinarySearchTree2() {
        this.root = null;
    }

    //search 반복
    public boolean search(int val) {
        Node current = root;
        while (current != null) {
            if (current.getData() == val) {
                return true;
            } else if (current.getData() > val) {
                current = current.getLeft();
            } else {
                current = current.getRight();
            }
        }
        return false;
    }

    //search 재귀
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
                    break;
                }
            } else {
                current = current.getRight();
                if (current == null) {
                    parent.setRight(newNode);
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
        tree.insert(10);

        System.out.print("트리 삽입 결과: ");
        tree.display(tree.root);

        System.out.println();
        System.out.println("트리에서 4 탐색: " + tree.search(4));

        try {
            System.out.println("트리에서 6 탐색: " + tree.search2(tree.root, 100).getData());
        } catch (NullPointerException e) {
            System.out.println("탐색 결과가 없습니다.");
        }


    }

}
