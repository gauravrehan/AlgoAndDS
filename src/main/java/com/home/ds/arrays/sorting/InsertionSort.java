package com.home.ds.arrays.sorting;

import java.util.Arrays;

public class InsertionSort implements ISort {

    public static void main(String[] args) {

        int[] arr = {3, 5, 7, 1, 2, 6, 4};

        ISort is = new InsertionSort();
        is.sort(arr);
        
    }

    public void insertionSort(int[] arr, int startIndex, int endIndex) {

        for(int i = startIndex+1; i <= endIndex; i++)
        {
        	int temp = arr[i];
        	int n = i;
        	while(n > startIndex && arr[n-1] >= temp)
        	{
        		arr[n] = arr[n-1];
        		--n;
        	}
        	arr[n]= temp;
        }
        return;
    }

	@Override
	public void sort(int[] A) {
		System.out.println("Original Array: " + Arrays.toString(A));

        insertionSort(A, 0, A.length - 1);

        System.out.println("Sorted Array by insertionSort: " + Arrays.toString(A));

		
	}


}


