package com.algo.practice.module.tree;

public class ReturnDistanceBetweenNodesBinarySearchTree {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(6);
		root.left = new TreeNode(4);
		root.right = new TreeNode(8);
		root.right.right = new TreeNode(9);
		root.right.right.right = new TreeNode(7);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(5);
		root.left.right.left = new TreeNode(2);

		System.out.println(distanceBetweenTwoNodes(root, 3, 7));
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
	
	public static TreeNode findLca(TreeNode root, int p, int q) {
		if (p < root.val && q < root.val) {
			return findLca(root.left, p, q);
		} else if (p > root.val && q > root.val) {
			return findLca(root.right, p, q);
		} else {
			return root;
		}
	}

	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (p.val < root.val && q.val < root.val) {
			return lowestCommonAncestor(root.left, p, q);
		} else if (p.val > root.val && q.val > root.val) {
			return lowestCommonAncestor(root.right, p, q);
		} else {
			return root;
		}
	}
}
