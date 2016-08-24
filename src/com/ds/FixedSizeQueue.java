/**
 * 
 */
package com.ds;

/**
 * @author Murli
 *
 */
public class FixedSizeQueue {
	
	int queue[];
	int size;
	int front;
	int rear;
	
	
	
    public FixedSizeQueue(int capacity) {
		queue = new int [capacity];
		size = front = rear = 0;
	}
    
    public void enQueue(int data)
    {
    	if(isFull())
    		throw new RuntimeException("Queue is Full!!!");
    	queue[rear] =data;
    	size++;
		rear = (rear + 1) % queue.length;
    }
    
    public int deQueue()
    {
    	if(isEmpty())
    		throw new RuntimeException("Queue is Empty!!!");
    	int data = queue[front];
    	size--;
		front = (front + 1) % queue.length;
		return data;
    }

    public boolean isFull()
    {
    	if(size==queue.length)
    		return true;
    	return false;
    }
    
    public boolean isEmpty()
    {
    	return size==0 ? true : false; 
    }
    
    @Override
	public String toString() {
		String temp = "Queue[";
		for (int i = 0; i < size; i++)
			temp += queue[(front + i) % queue.length] + ",";

		temp+="]";
		return temp;
	}


	public static void main(String[] args) {

		FixedSizeQueue fixedSizeQueue = new FixedSizeQueue(10);
		for (int i = 1; i <=10; i++)
			fixedSizeQueue.enQueue(i);

		fixedSizeQueue.deQueue();
		fixedSizeQueue.deQueue();
		fixedSizeQueue.deQueue();
		
		fixedSizeQueue.enQueue(11);
		fixedSizeQueue.enQueue(12);		
		
		System.out.println(fixedSizeQueue);
	}	
	
	

}
