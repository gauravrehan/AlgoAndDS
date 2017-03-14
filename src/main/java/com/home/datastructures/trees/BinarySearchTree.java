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
    public TreeNode<T> treeMaximum(TreeNode<T> node)
    {
        if(node != null)
        {
            TreeNode<T> x = node, y = null;

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
    public TreeNode<T> treeMinimum(TreeNode<T> node)
    {
        if(node != null)
        {
            TreeNode<T> x = node, y = null;

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
        Case 1: If there is right sub-tree of the node then find the treeMinimum on that node
        Case 2: if there is no right sub-tree then trace up parent by parent
         */
        if(node.getRightChild() != null)
            return this.treeMinimum(node.getRightChild());
        else
        {
            TreeNode<T> x = node, y = x.getParent();
            while (y != null && y.getRightChild() == x)
            {
                x = y;
                y = x.getParent();

            }
            return y;
        }
    }

    /*
    Done
     */
    public TreeNode<T> getPredecessor(TreeNode<T> node)
    {
            /*
        Case 1: If there is right sub-tree of the node then find the treeMinimum on that node
        Case 2: if there is no right sub-tree then trace up parent by parent
         */
        if(node.getLeftChild() != null)
            return this.treeMaximum(node.getRightChild());
        else
        {
            TreeNode<T> x = node, y = x.getParent();
            while (y != null && y.getLeftChild() == x)
            {
                x = y;
                y = x.getParent();

            }
            return y;
        }

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
    Done - but not satisfied.
    In CLRS, the logic is pretty small. rework this out.

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
            splice the moved nodes childern to moved node's parent.
        */

        TreeNode<T> nodeLocation = searchElement(root, deleteValue);
        if(nodeLocation != null)
        {
            //case 1
            if(nodeLocation.getLeftChild() == null && nodeLocation.getRightChild() == null)
            {
                if( nodeLocation.getParent().getLeftChild() == nodeLocation)
                    nodeLocation.getParent().setLeftChild(null);
                else
                    nodeLocation.getParent().setRightChild(null);

                nodeLocation.setParent(null);
                return;
            }
            //case 2
            if( (nodeLocation.getLeftChild() == null && nodeLocation.getRightChild() != null)
                || (nodeLocation.getLeftChild() != null && nodeLocation.getRightChild() == null) )
            {
                TreeNode<T> child = nodeLocation.getLeftChild();
                if(child != null)
                {
                    child.setParent(nodeLocation.getParent());
                    nodeLocation.getParent().setLeftChild(child);
                    nodeLocation.setParent(null);
                    nodeLocation.setLeftChild(null);
                }
                else
                {
                    child.setParent(nodeLocation.getParent());
                    nodeLocation.getParent().setRightChild(child);
                    nodeLocation.setParent(null);
                    nodeLocation.setRightChild(null);
                }
                return;
            }
            else
            {
                TreeNode<T> successor = this.getSuccessor(nodeLocation);

                while(successor != null && successor.getLeftChild() != null)
                {
                    successor = this.getSuccessor(successor);
                }

                if(successor != null)
                {
                    //splice the successor child to successor parent
                    successor.getParent().setRightChild(successor.getRightChild());
                    successor.getRightChild().setParent(successor.getParent());
                    //replace the nodeLocation with successor
                    successor.setParent(nodeLocation.getParent());
                    successor.setLeftChild(nodeLocation.getLeftChild());
                    successor.setRightChild(nodeLocation.getRightChild());
                    //nullify nodeLocation
                    nodeLocation.setParent(null);
                    nodeLocation.setLeftChild(null);
                    nodeLocation.setRightChild(null);
                }
            }
        }

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
