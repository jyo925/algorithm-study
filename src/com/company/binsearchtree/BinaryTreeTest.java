package com.company.binsearchtree;

public class BinaryTreeTest {


    //Left자식 -> 자신 -> Right자식
    public static void inorderTreeWalk(BinaryTree.Node<String> start) {
        if (start != null) {
            inorderTreeWalk(start.left);
            System.out.print(start.data +" ");
            inorderTreeWalk(start.right);
        }
    }

    //자신 -> Left자식 -> Right자식
    public static void preorderTreeWalk(BinaryTree.Node<String> start) {
        if (start != null) {
            System.out.print(start.data +" ");
            preorderTreeWalk(start.left);
            preorderTreeWalk(start.right);
        }
    }

    //Left자식 -> Right자식 -> 자신
    public static void postorderTreeWalk(BinaryTree.Node<String> start) {
        if (start != null) {
            preorderTreeWalk(start.left);
            preorderTreeWalk(start.right);
            System.out.print(start.data +" ");
        }
    }

    public static void main(String[] args) {


        BinaryTree<String> fox =
                new BinaryTree(new BinaryTree.Node<String>("fox"));

        fox.root.left = new BinaryTree.Node<>("bear");
        fox.root.left.left = new BinaryTree.Node<>("ant");
        fox.root.left.right = new BinaryTree.Node<>("dog");
        fox.root.left.right.left = new BinaryTree.Node<>("cat");
        fox.root.left.right.right = new BinaryTree.Node<>("eagle");

        fox.root.right = new BinaryTree.Node<>("goose");
        fox.root.right.right = new BinaryTree.Node<>("hippo");
        fox.root.right.right.right = new BinaryTree.Node<>("iguana");


//        inorderTreeWalk(fox.root);
        preorderTreeWalk(fox.root);




    }
}
