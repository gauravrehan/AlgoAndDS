package com.home.datastructures.tree;

public abstract class AbstractTree<E> implements Tree<E> {
	
	@Override
	public boolean isInternal(Position<E> p)
	{
		return numChildern(p) > 0;
	}
	
	@Override
	public boolean isExternal(Position<E> p)
	{
		return numChildern(p) == 0;
	}
	
	@Override
	public boolean isRoot(Position<E> p)
	{
		return p == root();
	}
	
	@Override
	public boolean isEmpty()
	{
		return size() == 0;
	}
	
	/*
	 * Calculates the depth of the node (distance from root) in recursive fashion.
	 */
	public int depth(Position<E> p)
	{
		if(isRoot(p)) 
			return 0;
		else
			return 1 + depth(parent(p));
	}
	
	
	
	/*
	 * Recursive calculates the height of the node. worst case O(n). 
	 * Though difficult to prove
	 */
	public int height(Position<E> p)
	{
		int h = 0;
		for(Position<E> c : childern(p))
		{
			h = Math.max(h,  1 + height(c));
		}
		return h;
	}

}
