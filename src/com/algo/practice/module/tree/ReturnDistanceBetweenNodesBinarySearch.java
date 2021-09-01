package com.algo.practice.module.tree;

public class ReturnDistanceBetweenNodesBinarySearch {
	public static void main(String[] args) {

		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(7);
		root.right = new TreeNode(9);
		root.right.right = new TreeNode(3);
		root.left.left = new TreeNode(10);
		root.left.right = new TreeNode(6);
		root.left.right.left = new TreeNode(5);
		root.left.right.right = new TreeNode(11);

		System.out.println(distanceBetweenTwoNodes(root, 5, 3));
	}

	public static int distanceBetweenTwoNodes(TreeNode root, int n1, int n2) {
		if (root == null)
			return -1;
		TreeNode lca = findLca(root, n1, n2);
		return getDistance(lca, n1, 0) + getDistance(lca, n2, 0);
	}

	public static int getDistance(TreeNode src, int dest, int distance) {
		if (src == null)
			return -1;
		if (src.val == dest)
			return distance;
		int d = getDistance(src.left, dest, distance + 1);
	    
	    if (d != -1) {
	      return d;
	    }
	    
	    d = getDistance(src.right, dest, distance + 1);

	    return d;
	}

	public static TreeNode findLca(TreeNode root, int n1, int n2) {
		if (root == null)
			return root;
		if (root.val == n1 || root.val == n2)
			return root;

		TreeNode left = findLca(root.left, n1, n2);
		TreeNode right = findLca(root.right, n1, n2);

		if (left != null && right != null) {
			return root;
		}
		if (left == null) {
			return right;
		} else
			return left;
	}
}
