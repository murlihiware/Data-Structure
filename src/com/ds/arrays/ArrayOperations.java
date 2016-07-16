/**
 * 
 */
package com.ds.arrays;

/**
 * @author Murli
 *
 */
public class ArrayOperations {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int a[] = {1,1,1,2,2,3,4,4,4,5,6,7,8,9,10,10,10,10};
		int index = numberOfOccurences(a, 10);

		System.out.println("Count:"+index);
	}

	
	//This method returns number of occurrences of element in sorted Array
	public static int numberOfOccurences(int a[], int element)
 {
		int lastIndex = binarySearchFirstOrLastOccurence(a, 0, a.length - 1, element, false);
		int firstIndex =binarySearchFirstOrLastOccurence(a, 0, lastIndex, element, true);
		return lastIndex -firstIndex +1;
	}
	
	public static int binarySearch(int a[], int low, int high, int elem)
	{
	  int mid = (low+high)/2;
	  if(low>high)
		  return -1;
	  if(elem == a[mid])
		  return mid;
	  else if(elem < a[mid])
		  return binarySearch(a, low, mid-1, elem);
	  else
		  return binarySearch(a, mid+1, high, elem);
	}
	
	public static int binarySearchFirstOrLastOccurence(int a[], int low, int high, int elem, boolean searchFirst)
	{
	  int mid = (low+high)/2;
	  if(low>high)
		  return -1;
	  if(elem == a[mid] && ( (searchFirst && (mid==low || elem!=a[mid-1])) || (!searchFirst && (mid==high || elem!=a[mid+1])) ))
		  return mid;
	  else if(elem <a[mid] || ((searchFirst && elem==a[mid])))
		  return binarySearchFirstOrLastOccurence(a, low, mid-1, elem, searchFirst);
	  else
		  return binarySearchFirstOrLastOccurence(a, mid+1, high, elem,searchFirst);
	}
}
