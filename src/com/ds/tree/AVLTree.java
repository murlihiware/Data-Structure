/**
 * 
 */
package com.ds.tree;

/**
 * @author Murli 
 * This Class is implements different operation supported by AVL Tree
 */
public class AVLTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}
	
	public static AVLTreeNode createAVLTree()
	{
	 AVLTreeNode root = new AVLTreeNode(null, null, 10, 1);	
	 return root;
	}
	
	public static void insert(AVLTreeNode parent,int data, int height)
	{
	    if(parent==null)
	    {
	    	parent = new AVLTreeNode();
	    	parent.setData(data);
	    	parent.setHeight(1);
	    	return;
	    }
		
		if (data< parent.getData())
		{
			insert(parent.getLeftChild(), data, parent.getHeight() + 1);
			int diff = height(parent.getLeftChild()) - height(parent.getRightChild());
			if(Math.abs(diff)==2)
			{
				if(data<parent.getLeftChild().getData())
				{
					parent = singleLLRotation(parent);
				}
				else
				{
					parent = doubleLRRotation(parent);		
				}
			}
		}
		else if (data > parent.getData())
		{
			insert(parent.getRightChild(), data, parent.getHeight() + 1);
			int diff = height(parent.getLeftChild()) - height(parent.getRightChild());
			if(Math.abs(diff)==2)
			{
				if (data > parent.getRightChild().getData())
					parent = singleRRRotation(parent);
				else
					parent = doubleRLRotation(parent);
			}
		}
	}
	
	public static int height(AVLTreeNode node)
	
	{
		if(node==null)
			return 0;
		return node.getHeight();
	}
	
	public static AVLTreeNode singleRRRotation(AVLTreeNode root)
	{
		AVLTreeNode temp = root.getLeftChild();
		root.setLeftChild(temp.getRightChild());
		temp.setRightChild(root);
		
		root.setHeight(Math.max(height(root.getLeftChild()), height(root.getRightChild())) + 1);
		temp.setHeight(Math.max(height(temp.getLeftChild()), height(temp.getRightChild())) + 1);
		return temp;
	}
	
	public static AVLTreeNode singleLLRotation(AVLTreeNode root)
	{
		
		AVLTreeNode temp = root.getRightChild();
		root.setRightChild(temp.getLeftChild());
		temp.setLeftChild(root);
		
		root.setHeight(Math.max(height(root.getLeftChild()), height(root.getRightChild())) + 1);
		temp.setHeight(Math.max(height(temp.getLeftChild()), height(temp.getRightChild())) + 1);
		return temp;
	}
	
	public static AVLTreeNode doubleLRRotation(AVLTreeNode root)
	{
		
		return null;
	}
	
	public static AVLTreeNode doubleRLRotation(AVLTreeNode root)
	{
		
		return null;
	}

}

class AVLTreeNode {
	private AVLTreeNode leftChild;
	private AVLTreeNode rightChild;
	private int data;

	public AVLTreeNode() {
	}

	public AVLTreeNode(AVLTreeNode leftChild, AVLTreeNode rightChild, int data, int height) {
		this.leftChild = leftChild;
		this.rightChild = rightChild;
		this.data = data;
		this.height = height;
	}

	public AVLTreeNode getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(AVLTreeNode leftChild) {
		this.leftChild = leftChild;
	}

	public AVLTreeNode getRightChild() {
		return rightChild;
	}

	public void setRightChild(AVLTreeNode rightChild) {
		this.rightChild = rightChild;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	private int height;

}
