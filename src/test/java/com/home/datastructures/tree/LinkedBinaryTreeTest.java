package com.home.datastructures.tree;

import org.junit.Before;
import org.junit.Test;

public class LinkedBinaryTreeTest {

	private LinkedBinaryTree<String> tree;
	
	@Before
	public void initialize()
	{
		tree = new LinkedBinaryTree<String>();
	}
	
	@Test
	public void setRoot()
	{
		System.out.println(tree.hashCode());
		tree.addRoot("I am groot");
		System.out.println(tree.isEmpty());
		tree.addRoot("jjj");
		
		
	}
	
	@Test
	public void againSetRoot()
	{
		System.out.println(tree.hashCode());
		System.out.println(tree.isEmpty());
		tree.addRoot("Should not set");
	}


}
