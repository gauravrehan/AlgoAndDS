package com.home.datastructures.stack;

/**
 * @author gauravrehan
 *
 * @param <E>
 */
public class StackUtils<E> {
	
	private ListStack<E> stack;
	
	/**
	 * 
	 */
	public StackUtils()
	{
		stack = new ListStack<E>();
	}
	
	
	
	/**
	 * Reverses a Type array.
	 * 
	 * @param a 
	 */
	public void reverse (E[] a)
	{
		for(E e : a)
		{
			stack.push(e);
		}
		
		for(int i = 0; i < a.length; i++)
		{
			a[i] = stack.pop();
		}
		
	}

}
