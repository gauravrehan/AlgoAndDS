package com.home.datastructures.trees;

/**
 * Created by richa on 3/11/2017.
 */
public class BinarySearchTree<T> {

    //Traversal - Inorder, PreOrder, and PostOrder
    //Recursive Search
    //Iterative Search
    //Tree Minimum
    //Tree Maximum
    //Tree Successor
    //Tree Predecessor
    //Tree Insert
    //Tree Deletion
    //T has to extend comparable interface

    private TreeNode<T> root;


    public BinarySearchTree() {

        root = null;
    }

    public TreeNode<T> treeMaximum()
    {
        return null;
    }

    public TreeNode<T> treeMinimum()
    {
        return null;
    }

    public TreeNode<T> getSuccessor(TreeNode<T> node)
    {
        return node;
    }

    public TreeNode<T> getPredecessor(TreeNode<T> node)
    {
        return node;
    }

    public TreeNode<T> searchElement(T searchValue)
    {
        return null;
    }

    public void insertElement(T insertValue)
    {
        return;
    }

    public void deleteElement(T deleteValue)
    {

    }





    private TreeNode<T> createTreeNode(T insertValue)
    {
        TreeNode<T> newNode = new TreeNode<T>();
        newNode.setValueObject(insertValue);
        return newNode;
    }






    static class TreeNode<T>
    {
        private TreeNode<T> leftChild;
        private TreeNode<T> rightChild;
        private TreeNode<T> parent;
        private T valueObject;

        public TreeNode()
        {
            valueObject = null;
            leftChild = null;
            rightChild = null;
            parent = null;
        }

        public TreeNode<T> getLeftChild() {
            return leftChild;
        }

        public TreeNode<T> getRightChild() {
            return rightChild;
        }

        public TreeNode<T> getParent() {
            return parent;
        }

        public void setLeftChild(TreeNode<T> leftChild) {
            this.leftChild = leftChild;
        }

        public void setRightChild(TreeNode<T> rightChild) {
            this.rightChild = rightChild;
        }

        public void setParent(TreeNode<T> parent) {
            this.parent = parent;
        }

        public T getValueObject() {
            return valueObject;
        }

        public void setValueObject(T valueObject) {
            this.valueObject = valueObject;
        }
    }


}
