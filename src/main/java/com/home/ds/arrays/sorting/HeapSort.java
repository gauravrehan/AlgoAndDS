package com.home.ds.arrays.sorting;

import java.util.Arrays;

/**
 * Created by richa on 10/8/2016.
 *
 * HeapSort uses a Heap Data Structure which can be used to build a priority Queue.
 * O(n) = nlogn
 * Building the max heap is O(n) and maxHeapify is executed for n-1 times with a complexity of O(logn) so
 * overall complexity comes out to be nlogn
 * Sorts in place.
 *
 */
public class HeapSort implements ISort {

    private int heapSize;
    private int arraySize;
    private int[] A;

    public HeapSort()
    {

    }

//    O(1)
    private void init(int[] A)
    {
        this.A = A;
        heapSize = arraySize = A.length;
    }

//    O(1)
    private int getParentIndex(int i)
    {
        if(i == 0)
            return 0;
        return i/2 - 1;
    }

//    O(1)
    private int getLeftChildIndex(int i)
    {
        return (2 * i) + 1;
    }

//    O(1)
    private int getRightChildIndex(int i)
    {
        return (2 * i) + 2;
    }


//    O(1)
    private int getHeapSize()
    {
        return heapSize;
    }

//    O(1)
    private int getArraySize()
    {
        return arraySize;
    }

//    O(1)
    private void reduceHeapSize()
    {
        heapSize -= 1;
    }


    private void maxHeapify(int[] array, int i)
    {
        int leftIndex = getLeftChildIndex(i);
        int rightIndex = getRightChildIndex(i);
        int largest ;
//        System.out.println("arraySize = " + getArraySize());
//        System.out.println("heapSize = " + getHeapSize());
//        System.out.println("leftIndex = " + leftIndex);
//        System.out.println("rightIndex = " + rightIndex);
        if((leftIndex < getHeapSize()) && (array[leftIndex] > array[i]))
            largest = leftIndex;
        else
            largest = i;

        if((rightIndex < getHeapSize()) && (array[rightIndex] > array[largest]))
            largest = rightIndex;

        if(largest != i)
        {
//          swap value in i with largest
//            and max heapify largest
            swap(array, largest, i);
            maxHeapify(array, largest);
        }
    }

    private void buildMaxHeap()
    {
//        System.out.println("In buildMaxHeap");
//        System.out.println("arraySize " + arraySize/2);
        for(int i = arraySize/2 - 1 ; i >=0   ; i-- ) {
//            System.out.println(i);
            maxHeapify(A, i);
//            System.out.println(Arrays.toString(A));
        }
    }

    @Override
    public void sort(int[] A) {
        init(A);
//        takes O(n)
        buildMaxHeap();
//        System.out.println(Arrays.toString(A));
        for (int i = arraySize - 2; i >= 0; i--) {
//            System.out.println(Arrays.toString(A));
            swap(A, i + 1, 0);
//            System.out.println(Arrays.toString(A));
            reduceHeapSize();

//            takes O(log n)
            maxHeapify(A, 0);
//            System.out.println(Arrays.toString(A));
        }
    }

}
