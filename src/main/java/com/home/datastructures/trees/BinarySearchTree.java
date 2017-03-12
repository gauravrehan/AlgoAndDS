package com.home.datastructures.trees;

/**
 * Created by richa on 3/11/2017.
 */
public class BinarySearchTree<T extends Comparable> {

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

    /*
    Done
     */
    public TreeNode<T> treeMaximum()
    {
        if(root != null)
        {
            TreeNode<T> x = root, y = null;

            while(x != null)
            {
                y = x;
                x = x.getRightChild();
            }
            return y;
        }
        return null;
    }

    /*
    Done
     */
    public TreeNode<T> treeMinimum()
    {
        if(root != null)
        {
            TreeNode<T> x = root, y = null;

            while(x != null)
            {
                y = x;
                x = x.getRightChild();
            }
            return y;
        }
        return null;
    }

    /*
    TODO
     */
    public TreeNode<T> getSuccessor(TreeNode<T> node)
    {
        /*
        Case 1:
         */
        return node;
    }

    /*
    TODO
     */
    public TreeNode<T> getPredecessor(TreeNode<T> node)
    {
        return node;
    }

    /*
    Done
     */
    public TreeNode<T> searchElement(TreeNode<T> startNode, T searchValue)
    {
        if(startNode != null) {
            if (startNode.getValueObject().compareTo(searchValue) == 0)
                return startNode;
            if(startNode.getValueObject().compareTo(searchValue) < 0)
                searchElement(startNode.getLeftChild(), searchValue);
            else
                searchElement(startNode.getRightChild(), searchValue);
        }
        return null;
    }




    /*
    Done
     */
    public TreeNode<T> insertElement(T insertValue)
    {
        TreeNode<T> newNode = createTreeNode(insertValue);
        if(root == null)
        {
            root = newNode;
            return root;
        }

        TreeNode<T> x = root,  y = null;

        while(x != null) {

            if (x.getValueObject().compareTo(insertValue) < 0) {
                y = x;
                x = x.getLeftChild();
            } else {
                y = x;
                x = x.getRightChild();
            }
        }

        newNode.setParent(y);

        if(y.getValueObject().compareTo(insertValue) < 0)
            y.setLeftChild(newNode);
        else
            y.setRightChild(newNode);

        return newNode;
    }

    /*
    TODO
     */
    public void deleteElement(T deleteValue)
    {
        /*
        Case 1: if the node to be deleted has no children
            Reach to the node and unlink it with its parent

        Case 2: If there is one child
            Splice the node's child to the nodes parent.

        Case 3: If there are both children
            Find first successor with no left children
            Replace the to be deleted node with this idenfified child.
            spice the moved nodes childern to moved node's parent.
        */

    }

    /*
    Done
     */
    private TreeNode<T> createTreeNode(T insertValue)
    {
        TreeNode<T> newNode = new TreeNode<T>();
        newNode.setValueObject(insertValue);
        return newNode;
    }

    /*
    Inner static class representing a node in a BST
     */
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
