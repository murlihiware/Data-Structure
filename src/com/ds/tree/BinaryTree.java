package com.ds.tree;

import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @author Murli
 *
 */
public class BinaryTree {

	static int count=0;
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		BinaryTreeNode root = createBinaryTree();
		int maxValue = findMaxInBinaryTree(root);
		System.out.println("Max Value:"+maxValue);
	}
	
	public static BinaryTreeNode createBinaryTree()
	{
		BinaryTreeNode root = new BinaryTreeNode(1);
		root.leftChild = new BinaryTreeNode(4);
		root.rightChild = new BinaryTreeNode(2);
		
		root.leftChild.leftChild = new BinaryTreeNode(6);
		root.leftChild.rightChild = new BinaryTreeNode(5);
		
		root.rightChild.leftChild = new BinaryTreeNode(3);
		root.rightChild.rightChild = new BinaryTreeNode(0);
	    return root;
	}
	
	public static int findMaxInBinaryTree(BinaryTreeNode root)
 {
		int maxValue = Integer.MIN_VALUE;
		if (root == null)
			return maxValue;
		int leftMaxValue = findMaxInBinaryTree(root.leftChild);
		int rightMaxValue = findMaxInBinaryTree(root.rightChild);
		if (leftMaxValue > rightMaxValue)
			maxValue = leftMaxValue;
		else
			maxValue = rightMaxValue;
		if (root.data > maxValue)
			maxValue = root.data;
		return maxValue;
	}
	
	public static BinaryTreeNode createBinarySearchTree()
	{
		BinaryTreeNode root = new BinaryTreeNode(10);
		root.leftChild = new BinaryTreeNode(6);
		root.rightChild = new BinaryTreeNode(14);
		
		root.leftChild.leftChild = new BinaryTreeNode(4);
		root.leftChild.rightChild = new BinaryTreeNode(8);
		
		root.rightChild.leftChild = new BinaryTreeNode(12);
		root.rightChild.rightChild = new BinaryTreeNode(16);
	    return root;
	}
	
	
	public static void addElement(int data)
	{
		
	}
	
	public static void inorderDisplay(BinaryTreeNode root)
	{
		if(root!=null)
		{
			inorderDisplay(root.rightChild);
			System.out.println(root.data);
			inorderDisplay(root.leftChild);
		}
		
	}
	
	public static void nonRecursiveInorderDisplay(BinaryTreeNode root)
	{
		if(root==null)
			return;
		
		Stack<BinaryTreeNode> s = new Stack<>();
		BinaryTreeNode currentNode = root;
		
		while(true)
		{
			if(currentNode!=null)
			{
				s.push(currentNode);
				currentNode = currentNode.rightChild;
			}
			else
			{
				if(!s.isEmpty())
				{
					currentNode=s.pop();
					System.out.println("Data:"+currentNode.data);
						currentNode = currentNode.leftChild;
				}
				else
				{
					break;
				}
				
			}
		}
	}
	
	public static BinaryTreeNode nonRecursiveInorderDisplay(BinaryTreeNode root, int k)
	{
		if(root==null)
			return null;
		int count=0;
		Stack<BinaryTreeNode> s = new Stack<>();
		BinaryTreeNode currentNode = root;
		
		while(true)
		{
			if(currentNode!=null)
			{
				s.push(currentNode);
				currentNode = currentNode.rightChild;
			}
			else
			{
				if(!s.isEmpty())
				{
					currentNode=s.pop();
				    count++;
				    if(count==k)
				    	return currentNode;
					currentNode = currentNode.leftChild;
				}
				else
				{
					break;
				}
				
			}
		}
		
		return null;
	}
	
	public static int kthNode(BinaryTreeNode root, int k)
 {
		if (root == null)
			return -1;
		else
		{
			int result = kthNode(root.rightChild, k);	
			if(result!=-1)
				return result;
			count++;
			if(count==k)
				return root.data;
			return kthNode(root.leftChild, k);
		}
		
	}
	
	
	public static void levelOrderDisplay(BinaryTreeNode root)
	{
		if(root==null)
			return;
		ArrayList<Integer> arrayList = new ArrayList<>();
		Queue<BinaryTreeNode> queue = new ConcurrentLinkedQueue<>();
		BinaryTreeNode tempNode;
		int count=0;
		BinaryTreeNode nullNode = new BinaryTreeNode(-1234);
		queue.offer(root);
		queue.offer(nullNode);

		while(!queue.isEmpty())
		{
			tempNode = queue.poll();
			if(tempNode!=nullNode)
			{
				arrayList.add(tempNode.data);
				if(tempNode.leftChild!=null)
					queue.offer(tempNode.leftChild);
				if(tempNode.rightChild!=null)
					queue.offer(tempNode.rightChild);
			}
			
			else
			{
				System.out.print("Level:"+(count++)+"=>");
				arrayList.stream().forEach(a->System.out.print(a+" "));
				System.out.println();
				arrayList.clear();
				if(!queue.isEmpty())
					queue.offer(nullNode);
			}
		}
		
		
	}

}


class BinaryTreeNode
{
	public int data;
	public BinaryTreeNode leftChild;
	public BinaryTreeNode rightChild;
	public BinaryTreeNode(int data) {
		this.data = data;
	}
	
	
}