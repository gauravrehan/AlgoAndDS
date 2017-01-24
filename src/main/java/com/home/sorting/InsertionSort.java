package com.home.sorting;

import java.util.Arrays;

/*
 * Best case: O(n) i.e. if the sequence is already sorted.
 * Worst case: O(n^2)
 *
 * Good for smaller size inputs
 * Sorts in place.
 *
 */
public class InsertionSort {
	
	public int[] Sort(int[] array)
	{
		int[] a = array.clone();
		int len = a.length;
		//sample array [2,6,1,3,80,4];
		System.out.println(Arrays.toString(a));
		for(int i= 1; i < len; i ++)
		{
			int valueToInsert = a[i];
			int j = i-1;
			while(j >= 0 && a[j] > valueToInsert)
			{
				a[j+1] = a[j];
				j--;
				System.out.println("Interim " + Arrays.toString(a));
			}
			a[j+1] = valueToInsert;
			System.out.println(Arrays.toString(a));
		}
		return a;
	}
}
