package com.home.ds.arrays.sorting;

import java.util.Arrays;

public class SelectionSort implements ISort{

    public static void main(String[] args) {

        int[] arr = {3, 5, 7, 1, 2, 6, 4};
        ISort is = new SelectionSort();
        is.sort(arr);

    }

    public  void selectionSort(int[] arr, int startIndex, int endIndex) {
        for (int j = startIndex; j < endIndex; j++) {

            int min = j;

            for (int i = j+1; i <= endIndex; i++) {
                if(arr[i] < arr[min])
                {
                    min = i;
                }

            }

            if(min != j)
                {
                    swap(arr, j, min);
                }
        }

        return;
    }

	@Override
	public void sort(int[] A) {
		System.out.println("Original Array: " + Arrays.toString(A));

        selectionSort(A, 0, A.length - 1);

        System.out.println("Sorted Array by selectionSort: " + Arrays.toString(A));
		
	}


}


