 package com.home.datastructures.tree;

import java.util.Iterator;

public interface Tree<E> extends Iterable<E> {

	Position<E> root();
	
	Position<E> parent(Position<E> p) throws IllegalArgumentException;
	
	/*
	 * Immediate level childern
	 */
	Iterable<Position<E>> childern(Position<E> p) throws IllegalArgumentException;
	
	int numChildern(Position<E> p) throws IllegalArgumentException;
	
	boolean isInternal(Position<E> p) throws IllegalArgumentException;
	
	boolean isExternal(Position<E> p) throws IllegalArgumentException;
	
	boolean isRoot(Position<E> p) throws IllegalArgumentException;
		
	int size();
	
	boolean isEmpty();
	
	Iterator<E> iterator();
	
	Iterable<Position<E>> postions();
		
}
