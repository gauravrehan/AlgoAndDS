package com.home.sorting;


/*
 * Good case: O(n)
 * Worst case: O(nlogn) makes it better than Insertion sort.
 * T(n) = 2T(n/2) {for the Conquer)+ n (for merge operation). By master theorem this becomes O(nlogn)
 *
 * Good for large size of n
 * Doesn't sort in place
 *
 */
public class MergeSort {
	
	//Divide and Conquer
	public void sort(int[] a, int p, int r)
	{
		if( p < r)
		{
			int q = (p + r)/2;
			sort(a, p, q);
			sort(a, q+1, r);
			merge(a, p, q, r);
		}
	}
	
	//Merge the sorted arrays
	private void merge(int[] a, int p, int q, int r)
	{
		int len1 = q - p + 1;
		int len2 = r - q;
		
		int[] aLeft = new int[len1 + 1];
		int[] aRight = new int[len2 + 1];
		
		for(int i = 0; i < aLeft.length - 1; i++)
		{
			aLeft[i] = a[p + i];
		}
		
		aLeft[aLeft.length - 1] = Integer.MAX_VALUE;
		
				
		for(int i = 0; i < aRight.length - 1; i++)
		{
			aRight[i] = a[q + 1 + i];
		}
		aRight[aRight.length - 1] = Integer.MAX_VALUE;
		
		int k = 0;
		int l = 0;
		
		for( int i = p; i <= r; i ++)
		{
			if(aLeft[k] <= aRight[l])
			{
				a[i] = aLeft[k];
				k++;
			}
			else
			{
				a[i] = aRight[l];
				l++;
			}
		}
	}

}
