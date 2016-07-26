/**
 * 
 */
package com.ds.tree;

/**
 * @author Murli
 *
 */
public class ThreadedBinaryTree {

	static ThreadedBT dummy = createThreadedBT();
	/**
	 * @param args
	 */
	public static void main(String[] args) {

//		preOrderPrint(dummy.left);
		ThreadedBT temp = findNodeInTBT(dummy.left, 3);
		System.out.println("Node:"+temp.data);
		
	}

    public static ThreadedBT inorderSuccessor(ThreadedBT node)
 {
		if (node.rtag == 0)
			return node.right;
		ThreadedBT temp = node.right;
		while (temp.ltag == 1)
			temp = temp.left;
		return temp;
	}
    
    public static ThreadedBT findNodeInTBT(ThreadedBT root, int data)
    {
    	if(root.data==data)
    		return root;
    	
    	if(root.ltag==1)
    	{
    		
    		ThreadedBT node = findNodeInTBT(root.left, data);
    		if(node!=null)
        		return node;
    	}
    	
    	if(root.rtag==1)
    	return findNodeInTBT(root.right, data);
    	
    	return null;
    }
    
    public static void preOrderPrint(ThreadedBT root)
    {
    	System.out.println(root.data);
    	if(root.ltag==1)
    	preOrderPrint(root.left);
    	if(root.rtag==1)
    	preOrderPrint(root.right);
    }
	public static ThreadedBT createThreadedBT()
 {
		ThreadedBT dummy = new ThreadedBT(-111);
		dummy.ltag = 1;
		dummy.rtag = 1;
		dummy.right = dummy;

		ThreadedBT root = new ThreadedBT(1);
		dummy.left = root;

		root.ltag = 1;
		root.rtag = 1;

		ThreadedBT left1 = new ThreadedBT(2);
		left1.ltag = 1;
		left1.rtag = 1;
		ThreadedBT right1 = new ThreadedBT(3);
		right1.ltag = 1;
		right1.rtag = 1;

		root.left = left1;
		root.right = right1;

		ThreadedBT left2 = new ThreadedBT(4);
		left1.left = left2;
		left2.ltag = 0;
		left2.left = dummy;
		left2.rtag = 0;
		left2.right = left1;

		ThreadedBT right2 = new ThreadedBT(5);
		left1.right = right2;
		right2.ltag = 0;
		right2.left = left1;
		right2.rtag = 0;
		right2.right = root;

		ThreadedBT left3 = new ThreadedBT(6);
		right1.left = left3;
		left3.ltag = 0;
		left3.left = root;
		left3.rtag = 0;
		left3.right = right1;

		ThreadedBT right3 = new ThreadedBT(7);
		right1.right = right3;
		right3.ltag = 0;
		right3.left = right1;
		right3.right = dummy;

		return dummy;
	}

}


class ThreadedBT
{
	int ltag;
	int rtag;
	int data;
	ThreadedBT left;
	ThreadedBT right;
	
	public ThreadedBT(int data) {
		this.data = data;
	}
}
