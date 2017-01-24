package com.home.sorting;

import org.junit.Test;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Before;

public class InsertionSortTest {

	private InsertionSort sorter;
	
	@Before
	public void setup()
	{
		sorter = new InsertionSort();
	}
	
	@Test
	public void SortTest()
	{
		int[] array = new int[] {2,6,1,3,80,4};
		int[] expectedArray = new int[] {1,2,3,4,6,80};
		int[] resultArray = sorter.Sort(array);
//		Below string is printed only when the test fails
		Assert.assertArrayEquals("Test Failed: " + Arrays.toString(resultArray), resultArray, expectedArray);
	}
	
	@Test
	public void SortTestIndexOne()
	{
		int[] array = new int[] {2};
		int[] expectedArray = new int[] {2};
		int[] resultArray = sorter.Sort(array);
//		Below string is printed only when this test fails
		Assert.assertArrayEquals("Test Failed: " + Arrays.toString(resultArray), resultArray, expectedArray);
	}

}
