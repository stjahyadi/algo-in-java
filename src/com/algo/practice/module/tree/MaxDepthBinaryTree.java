package com.algo.practice.module.tree;

import java.util.Stack;

public class MaxDepthBinaryTree {
	public static void main(String[] args) {

	}

	public static int maxDepth(TreeNode root) {
		if (root == null)
			return 0;
		if (root.left == null && root.right == null)
			return 1;
		return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
	}

	public static int maxDepth2(TreeNode root) {
		if (root == null)
			return 0;
		int max = 1;
		Stack<TreeNode> nodes = new Stack<>();
		Stack<Integer> depths = new Stack<>();

		nodes.push(root);
		depths.push(1);

		while (!nodes.isEmpty()) {
			TreeNode curr = nodes.pop();
			int depth = depths.pop();

			if (curr.left == null && curr.right == null)
				max = Math.max(max, depth);

			if (curr.left != null) {
				nodes.push(curr.left);
				depths.push(depth + 1);
			}
			if (curr.right != null) {
				nodes.push(curr.right);
				depths.push(depth + 1);
			}
		}

		return max;
	}
}
