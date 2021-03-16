package com.company.binsearchtree;

public class BinaryTree<E> {

    protected static class Node<E> {

        protected E data;
        protected Node<E> left;
        protected Node<E> right;

        public Node(E data) {
            this.data = data;
            left = null;
            right = null;
        }

        public String toString() {
            return data.toString();
        }
    }

    protected Node<E> root;

    public BinaryTree() {
        root = null;
    }
    protected BinaryTree(Node<E> root) {
        this.root = root;
    }
    public BinaryTree(E data, BinaryTree<E> leftTree, BinaryTree<E> rightTree) {

        root = new Node<E>(data);

        if (leftTree != null)
            root.left = leftTree.root;
        else
            root.left = null;

        if (rightTree != null)
            root.right = rightTree.root;
        else
            root.right = null;
    }

    public BinaryTree<E> getLeftSubtree() {
        if (root != null && root.left != null)
            return new BinaryTree<E>(root.left);
        else
            return null;
    }

    public BinaryTree<E> getRightSubtree() {
        if (root != null && root.right != null)
            return new BinaryTree<E>(root.right);
        else
            return null;
    }
}
