package com.home.sorting;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.home.ds.arrays.sorting.HeapSort;
import com.home.ds.arrays.sorting.ISort;

import java.util.Arrays;

/**
 * Created by Gaurav on 05-02-2017.
 */
public class HeapSortTest {

    private ISort heapSort;

    @Before
    public void setup()
    {
        heapSort = new HeapSort();
    }

    @Test
    public void sortOddIndexTest()
    {
        int[] array = new int[] {2,6,1,3,80,4,100};
        int[] expectedArray = new int[] {1,2,3,4,6,80,100};
        heapSort.sort(array);
//		Below string is printed only when the test fails
        Assert.assertArrayEquals("Test Failed: " + Arrays.toString(array), expectedArray, array);
    }


    @Test
    public void sortEvemIndexTest()
    {
        int[] array = new int[] {2,6,1,3,45,80,4,100};
        int[] expectedArray = new int[] {1,2,3,4,6,45,80,100};
        heapSort.sort(array);
//		Below string is printed only when the test fails
        Assert.assertArrayEquals("Test Failed: " + Arrays.toString(array), expectedArray, array);
    }

    @Test
    public void sortOneIndexTest()
    {
        int[] array = new int[] {2};
        int[] expectedArray = new int[] {2};
        heapSort.sort(array);
//		Below string is printed only when the test fails
        Assert.assertArrayEquals("Test Failed: " + Arrays.toString(array), expectedArray, array);
    }

    @Test
    public void sortZeroIndexTest()
    {
        int[] array = new int[] {};
        int[] expectedArray = new int[] {};
        heapSort.sort(array);
//		Below string is printed only when the test fails
        Assert.assertArrayEquals("Test Failed: " + Arrays.toString(array), expectedArray, array);
    }

}

