package com.home.datastructures.stack;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ListStack<E> implements Stack<E>{
	
	private LinkedList<E> list = new LinkedList<E>(); 

	@Override
	public void push(E e) {
		// TODO Auto-generated method stub
		list.addFirst(e);
	}

	@Override
	public E pop() {
		// TODO Auto-generated method stub
		return list.removeFirst();
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return list.isEmpty();
	}

	@Override
	public E top() {
		// TODO Auto-generated method stub
		return list.peek();
	}
	

}
