package com.home.sorting;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.home.ds.arrays.sorting.ISort;

import java.util.Arrays;

/**
 * Created by richa on 2/5/2017.
 */
public class QuickSortTest
{
    private ISort quickSort;

    @Before
    public void setup()
    {
        quickSort = new QuickSort();
    }

    @Test
    public void sortOddIndexTest()
    {
        int[] array = new int[] {2,6,1,3,80,4,100};
        int[] expectedArray = new int[] {1,2,3,4,6,80,100};
        quickSort.sort(array);
//		Below string is printed only when the test fails
        Assert.assertArrayEquals("Test Failed: " + Arrays.toString(array), expectedArray, array);
    }


    @Test
    public void sortEvemIndexTest()
    {
        int[] array = new int[] {2,6,1,3,45,80,4,100};
        int[] expectedArray = new int[] {1,2,3,4,6,45,80,100};
        quickSort.sort(array);
//		Below string is printed only when the test fails
        Assert.assertArrayEquals("Test Failed: " + Arrays.toString(array), expectedArray, array);
    }

    @Test
    public void sortOneIndexTest()
    {
        int[] array = new int[] {2};
        int[] expectedArray = new int[] {2};
        quickSort.sort(array);
//		Below string is printed only when the test fails
        Assert.assertArrayEquals("Test Failed: " + Arrays.toString(array), expectedArray, array);
    }

    @Test
    public void sortZeroIndexTest()
    {
        int[] array = new int[] {};
        int[] expectedArray = new int[] {};
        quickSort.sort(array);
//		Below string is printed only when the test fails
        Assert.assertArrayEquals("Test Failed: " + Arrays.toString(array), expectedArray, array);
    }

}

