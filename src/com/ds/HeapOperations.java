/**
 * 
 */
package com.ds;

/**
 * @author Murli
 *
 */
public class HeapOperations {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int data[] = { 31, 1, 10, 9, 3, 2, 8, 7, 21, 12, 18 };
        Heap heap = new Heap(data, data.length, data.length);
        heap.buildHeap();
        heap.displayHeap();
        int []sortedArray = heap.heapSort();
        System.out.println("Sorted Elements");
        for (int i : sortedArray) {
			System.out.print(" "+i);
		}
	
	}

}


class Heap
{
	int []data;
	int count;
	int capacity;
	public Heap(int capacity) {
		this.capacity = capacity;
		data = new int[capacity];
	}
	
	
	
	public Heap(int[] data, int count, int capacity) {
		this.data = data;
		this.count = count;
		this.capacity = capacity;
	}



	public int lchild(int i)
	{
		return (2*i + 1);
	}
	
	public int rchild(int i)
	{
		return (2*i+2);
	}
	
	public int Parent(int i)
	{
		return (i-1)/2;
	}
	
	public void buildHeap()
	{
		for(int i =(count-2)/2; i>=0; i--)
		{
			heapify(i);
		}
	}
	
	public void heapify(int i)
	{
	  
	  int lchild = lchild(i);
	  int rchild = rchild(i);
	  int maxIndex;
	  maxIndex = i;
	  
	  if(lchild <=count-1 &&  data[i] < data[lchild])
		  maxIndex = lchild;
	  
	  if(rchild <=count-1 && data[maxIndex] < data[rchild])
		  maxIndex = rchild;
	  
	  if(i!=maxIndex)
	  {
		  int temp = data[i];
		  data[i] = data[maxIndex];
		  data[maxIndex] = temp;
		  heapify(maxIndex);
	  }
	}
	
	public void displayHeap()
	{
		System.out.println("After Building Heap:");
		for (int i : data) {
			System.out.print(" "+i);
		}
	}
	
	public int[] heapSort()
	{
		int sortedArray[] = new int [count];
		int j=0;
		for(int i=count-1; i>=0; i--)
		{
			int temp = data[0];
			sortedArray[j++] = temp;
			data[0] = data[i];
			heapify(0);
			count--;
		}
		
		return sortedArray;
	}
}
