package com.home.datastructures.tree;

import java.util.List;
import java.util.ArrayList;

public abstract class AbstractBinaryTree<E> extends AbstractTree<E> implements BinaryTree<E> {
	
	@Override
	public Position<E> sibling(Position<E> p)
	{
		Position<E> parent = parent(p);
		if (parent == null) return null;
		if(p == left(parent))
			return right(parent);
		else
			return left(parent);
	}
	
	@Override
	public int numChildern(Position<E> p)
	{
		int count = 0;
		if(left(p) != null)
			count++;
		if(right(p) != null)
			count++;
		return count;
	}
	
	@Override
	public Iterable<Position<E>> childern(Position<E> p)
	{
		List<Position<E>> snapshot = new ArrayList<Position<E>>(2);
		if(left(p) != null)
			snapshot.add(left(p));
		if(right(p) != null)
			snapshot.add(right(p));
		return snapshot;
	}

}
