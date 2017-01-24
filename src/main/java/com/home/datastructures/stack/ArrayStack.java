package com.home.datastructures.stack;

public class ArrayStack<E> implements Stack<E> {
	
	private E[] data;
	private int index = -1;
	
	public ArrayStack(int size)
	{
		data = (E[]) (new Object[size]);
	}

	@Override
	public void push(E e) {
		// TODO Auto-generated method stub
		if(index + 1 == data.length)
			throw new IllegalStateException ("Stack is full");
		data[++index] = e;
	}

	@Override
	public E pop() {
		// TODO Auto-generated method stub
		if(isEmpty())
			throw new IllegalStateException ("Stack is empty");
		return data[index--];
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return index == -1 ? true : false;
	}

	@Override
	public E top() {
		// TODO Auto-generated method stub
		return data[index];
	}

}
