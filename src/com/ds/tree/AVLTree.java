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

		AVLTreeNode root = createAVLTree();
		root = insert(root, 12);
		root = insert(root, 14);
		root = insert(root, 16);
		root = insert(root, 18);
        inorderTree(root);
        System.out.println("Level Order Display:");
		levelOrderRecurSive(root);
	}
	
	public static AVLTreeNode createAVLTree()
	{
	 AVLTreeNode root = new AVLTreeNode(null, null, 10, 1);	
	 return root;
	}
	
	public static void inorderTree(AVLTreeNode root)
	{
		if(root==null)
			return;
		inorderTree(root.getLeftChild());
		System.out.println(root.getData());
		inorderTree(root.getRightChild());
	}
	
	public static void levelOrderRecurSive(AVLTreeNode root)
	{
	 int height = height(root);
	 
	 for(int i=1;i<=height;i++)
	 {
		 levelOrderRec(root, i);
		 System.out.println();
	 }
	}
	
	public static void levelOrderRec(AVLTreeNode root, int level)
	{
	 if(level ==1)
	 {
			if (root != null)
				System.out.print(root.getData()+ " ");
	 }
	 else
	 {
		 levelOrderRec(root.getLeftChild(), level-1);
		 levelOrderRec(root.getRightChild(), level-1);
	 }
		 
	}
	public static AVLTreeNode insert(AVLTreeNode parent,int data)
	{
	    if(parent==null)
	    {
	    	parent = new AVLTreeNode();
	    	parent.setData(data);
	    	parent.setHeight(1);
	    	return parent;
	    }
		
		if (data< parent.getData())
		{
			parent.setLeftChild(insert(parent.getLeftChild(), data));
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
			parent.setRightChild(insert(parent.getRightChild(), data));
			int diff = height(parent.getLeftChild()) - height(parent.getRightChild());
			if(Math.abs(diff)==2)
			{
				if (data > parent.getRightChild().getData())
					parent = singleRRRotation(parent);
				else
					parent = doubleRLRotation(parent);
			}
		}
		parent.setHeight(Math.max(height(parent.getLeftChild()), height(parent.getRightChild())) + 1);
		return parent;
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
		root.setLeftChild(singleLLRotation(root.getLeftChild()));
		return singleRRRotation(root);
	}
	
	public static AVLTreeNode doubleRLRotation(AVLTreeNode root)
	{
		root.setRightChild(singleRRRotation(root.getRightChild()));
		return singleLLRotation(root);
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
