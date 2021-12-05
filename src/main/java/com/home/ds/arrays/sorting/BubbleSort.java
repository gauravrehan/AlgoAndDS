package com.home.ds.arrays.sorting;

import java.util.Arrays;
/*
 * Bubble sort is the most basic sorting algo with O(n^2) as worst time complexity
 * 
 */
public class BubbleSort implements ISort {

    public static void main(String[] args) {

    	BubbleSort bs = new BubbleSort();
    	int[] arr = {3, 5, 7, 1, 2, 5, 9};
    	bs.sort(arr);
    }

    public void bubbleSort(int[] arr, int startIndex, int endIndex) {
        for (int j = endIndex; j > startIndex; j--) {

            for (int i = startIndex; i < j; i++) {
                if (arr[i] > arr[i + 1]) {
					swap(arr, i, i+1);
                }
            }
        }

        return;
    }

	@Override
	public void sort(int[] A) {
		

        System.out.println("Original Array: " + Arrays.toString(A));

        bubbleSort(A, 0, A.length - 1);

        System.out.println("Sorted Array: " + Arrays.toString(A));

		
	}
}
