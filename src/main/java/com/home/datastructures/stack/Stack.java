package com.home.datastructures.stack;

public interface Stack<E> {

	void push(E e);

	E pop();

	boolean isEmpty();

	E top();
}
