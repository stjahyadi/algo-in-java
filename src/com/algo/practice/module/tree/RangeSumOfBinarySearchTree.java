package com.algo.practice.module.tree;


public class RangeSumOfBinarySearchTree {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(5);
		root.right = new TreeNode(15);
		root.right.right = new TreeNode(18);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(7);
		System.out.println(rangeSumBST(root, 7, 15));

	}

	public static int rangeSumBST(TreeNode root, int low, int high) {
		if (root == null)
			return 0;

		int sum = 0;
		if (root.val >= low && root.val <= high)
			sum += root.val;
		sum += rangeSumBST(root.left, low, high);
		sum += rangeSumBST(root.right, low, high);
		return sum;
	}

}
