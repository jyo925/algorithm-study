package com.company.binsearchtree;

public class BinarySearchTreeTest {

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        bst.insertBST('G');
        bst.insertBST('I');
        bst.insertBST('H');
        bst.insertBST('D');
        bst.insertBST('B');
        bst.insertBST('M');
        bst.insertBST('N');
        bst.insertBST('A');
        bst.insertBST('J');
        bst.insertBST('E');
        bst.insertBST('Q');

        System.out.println("Binary Tree >>>");
        bst.printBST();

        System.out.println("Is There \"A\" ? >>> ");
        TreeNode p1 = bst.searchBST('A');
        if(p1!=null){
            System.out.println(p1.data + " 탐색 성공");
        }else{
            System.out.println("탐색 실패");
        }

        System.out.println("Is There \"Z\" ? >>> ");
        TreeNode p2 = bst.searchBST('Q');
        if(p2!=null){
            System.out.println(p2.data + " 탐색 성공");
        }else{
            System.out.println("탐색 실패");
        }
    }
}
