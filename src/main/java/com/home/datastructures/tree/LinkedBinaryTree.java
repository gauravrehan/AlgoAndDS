package com.home.datastructures.tree;

import java.util.Iterator;

public class LinkedBinaryTree<E> extends AbstractBinaryTree<E> {
	/*
	 * Inner class for Node linked structure
	 */
	protected static class Node<E> implements Position<E> {
		private E element;
		private Node<E> parent;
		private Node<E> left;
		private Node<E> right;

		public Node(E e, Node<E> above, Node<E> leftChild, Node<E> rightChild) {
			element = e;
			parent = above;
			left = leftChild;
			right = rightChild;
		}

		@Override
		public E getElement() {
			return element;
		}

		public void setElement(E element) {
			this.element = element;
		}

		public Node<E> getParent() {
			return parent;
		}

		public void setParent(Node<E> parent) {
			this.parent = parent;
		}

		public Node<E> getLeft() {
			return left;
		}

		public void setLeft(Node<E> left) {
			this.left = left;
		}

		public Node<E> getRight() {
			return right;
		}

		public void setRight(Node<E> right) {
			this.right = right;
		}

	}

	protected Node<E> createNode(E e, Node<E> parent, Node<E> left, Node<E> right) {
		return new Node<E>(e, parent, left, right);
	}

	/*
	 * Root node
	 */
	public Node<E> root = null;

	private int size = 0;

	public LinkedBinaryTree() {
	}

	/*
	 * Validates the node. if it is parent to itself means that it is no longer
	 * part of the tree.
	 */
	protected Node<E> validate(Position<E> p) throws IllegalArgumentException {
		if (!(p instanceof Node))
			throw new IllegalArgumentException("Not valid position type");
		Node<E> node = (Node<E>) p;
		if (node.getParent() == node)
			throw new IllegalArgumentException("p is no longer in the tree");
		return node;
	}

	@Override
	public Position<E> left(Position<E> p) throws IllegalArgumentException {
		Node<E> node = validate(p);
		return node.getLeft();
	}

	@Override
	public Position<E> right(Position<E> p) throws IllegalArgumentException {
		Node<E> node = validate(p);
		return node.getRight();
	}

	@Override
	public Position<E> root() {
		return root;
	}

	@Override
	public Position<E> parent(Position<E> p) throws IllegalArgumentException {
		Node<E> node = validate(p);
		return node.getParent();
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Position<E>> postions() {
		// TODO Auto-generated method stub
		return null;
	}

	public Position<E> addRoot(E e) throws IllegalStateException {
		if (!isEmpty())
			throw new IllegalStateException("Tree is not empty.");
		root = createNode(e, null, null, null);
		size = 1;
		return root;
	}

	public Position<E> addLeft(Position<E> p, E e) throws IllegalArgumentException {
		Node<E> node = (Node<E>) validate(p);
		if (node.getLeft() != null)
			throw new IllegalArgumentException("Left not empty");
		Node<E> n1 = createNode(e, null, null, null);
		node.setLeft(n1);
		size++;
		return n1;
	}

	public Position<E> addRight(Position<E> p, E e) throws IllegalArgumentException {
		Node<E> node = (Node<E>) validate(p);
		if (node.getRight() != null)
			throw new IllegalArgumentException("Right not empty");
		Node<E> n1 = createNode(e, null, null, null);
		node.setRight(n1);
		size++;
		return n1;
	}

	public E set(Position<E> p, E e) throws IllegalArgumentException {
		Node<E> node = validate(p);
		E eOld = node.getElement();
		node.setElement(e);
		return eOld;
	}

	public void attach(Position<E> p, LinkedBinaryTree<E> t1, LinkedBinaryTree<E> t2) {
		Node<E> node = validate(p);
		if (node.getLeft() != null || node.getRight() != null)
			throw new IllegalStateException("Node is already populated with left or right or both subtrees.");

		size = t1.size() + t2.size();

		if (!t1.isEmpty()) {
			node.setLeft(t1.root);
			t1.root.setParent(node);
			t1.root = null;
			t1.size = 0;
		}

		if (!t2.isEmpty()) {
			node.setRight(t2.root);
			t2.root.setParent(node);
			t2.root = null;
			t2.size = 0;
		}
	}
	
	
	/*
	 * If node has two childern, the removal cannot proceed.
	 */
	public E remove(Position<E> p) throws IllegalArgumentException, IllegalStateException
	{
		Node<E> node = validate(p);
		if(numChildern(node) == 2)
			throw new IllegalStateException ("Node has two children. cannot remove");
		Node<E> nodeParent = node.getParent();
		Node<E> nodeToUpgrade = node.getLeft() != null ? node.getLeft() : node.getRight();
			
		nodeToUpgrade.setParent(nodeParent);
		
		if(node == root)
			nodeToUpgrade = root;
		
		if(nodeParent.getLeft() == node)
			nodeParent.setLeft(nodeToUpgrade);
		else
			nodeParent.setRight(nodeToUpgrade);
		
		size--;
		E eOld = node.getElement();
		node.setElement(null);
		node.setParent(node);
		node.setLeft(null);
		node.setRight(null);
		return eOld;
	}

}
