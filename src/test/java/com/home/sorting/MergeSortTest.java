package com.home.sorting;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class MergeSortTest {
	
	private MergeSort mergeSort;
	
	@Before
	public void setup()
	{
		mergeSort = new MergeSort();
	}

	@Test
	public void mergeSortTest()
	{
		int a[] = new int[] {2,5,6,8,3,1,7,38,8,43,23,3};
		mergeSort.sort(a, 0, a.length - 1);
		System.out.println(Arrays.toString(a));
	}

}
