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
