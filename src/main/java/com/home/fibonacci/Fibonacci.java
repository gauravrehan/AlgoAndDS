package com.home.fibonacci;

public class Fibonacci {
	
	static void getFibonacci(int n)
	{
		int n1 = 0;
		int n2 = 1;
		System.out.println(n1);
		if (n == n1)
		{
			return;
		}
		System.out.println(n2);
		if(n == n2)
		{
			return;
		}
		
		for (int i = 2; i <= n; i ++)
		{
			int next = n1 + n2;
			System.out.println(next);
			n1 = n2;
			n2 = next;
		}
	}
	
    
    
	public static void main(String[] a)
	{
		getFibonacci(10);
	
	}
}
