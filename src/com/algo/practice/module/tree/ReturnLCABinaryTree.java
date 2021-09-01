package com.algo.practice.module.tree;

public class ReturnLCABinaryTree {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(5);
		root.right = new TreeNode(1);
		root.right.right = new TreeNode(8);
		root.right.left = new TreeNode(0);
		
		root.left.left = new TreeNode(6);
		root.left.right = new TreeNode(2);
		root.left.right.left = new TreeNode(7);
		root.left.right.right = new TreeNode(4);
		
		TreeNode p = new TreeNode(5);
		TreeNode q = new TreeNode(4);
		System.out.println(lowestCommonAncestor(root, p, q));
	}

	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == p || root == q || root == null)
			return root;

		TreeNode left = lowestCommonAncestor(root.left, p, q);
		TreeNode right = lowestCommonAncestor(root.right, p, q);
		if (left == null)
			return right;
		else if (right == null)
			return left;
		else
			return root;
	}
}
