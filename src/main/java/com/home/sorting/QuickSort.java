package com.home.sorting;

import java.util.Arrays;

/**
 * Created by gauravrehan on 9/10/16.
 *
 * Worst case: O(n^2)
 * Average case: O(nlogn)
 * Sorts in place.
 * Hence better than HeapSort (well heapsort also sorts in place so i need to revalidate this point)
 *
 */
public class QuickSort implements ISort {


    @Override
    public void sort(int[] A) {
        if(A != null & A.length > 1)
        quickSort(A, 0, A.length - 1);
    }

    private void quickSort(int[] A, int p, int r)
    {
        if(p == r || p > r)
            return;

        int pivot = partition(A, p, r);
        quickSort(A, p, pivot - 1);
        quickSort(A, pivot + 1, r);
    }

    private int partition(int[] A, int p, int r)
    {

//        System.out.println(Arrays.toString(A));
//        System.out.println("p="+p+"r="+r);
        int x = A[r];
        int i = p-1;

        for(int j = p; j < r; j ++)
        {
            if(A[j] <= x )
            {
                i += 1;
                swap(A, i, j);
            }
        }
        swap(A, i+1, r);

        return i + 1;
    }
}
