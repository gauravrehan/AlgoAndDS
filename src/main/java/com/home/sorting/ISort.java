package com.home.sorting;

/**
 * Created by Gaurav on 05-02-2017.
 */
public interface ISort {
    void sort(int[] A);

    public default void swap(int[] array, int i, int j)
    {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
