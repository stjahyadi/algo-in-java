package com.algo.practice.module.tree;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BST {
	public static void main(String[] args) {
		int[] nums = { 1, 2, 3 };
		print(preOrderTraversal(init(nums)));
	}

	private static TreeNode init(int[] nums) {
		TreeNode root = null;
		for (int i : nums) {
			root = addRecursive(root, i);
		}
		return root;
	}
	
	public static void print(List<Integer> output) {
		for (int i = 0; i < output.size(); i++) {
			System.out.print(output.get(i));
			if (i < output.size() - 1)
				System.out.print(", ");
		}
	}
	
	public static List<Integer> preOrderTraversal(TreeNode root) {
		//TODO::
		List<Integer> output = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		TreeNode current = root;
		while (current != null || !stack.isEmpty()) {
			while (current != null) {
				stack.push(current);
				current = current.left;
			}
			current = stack.pop();
			output.add(current.val);
			current = current.right;
		}
		return output;
	}

	/*
	 * we have to find the place where we want to add a new node in order to keep
	 * the tree sorted. We'll follow these rules starting from the root node: 
	 * if the new node's value is lower than the current node's, we go to the left child 
	 * if the new node's value is greater than the current node's, we go to the right child 
	 * when the current node is null, we've reached a leaf node and we can insert the new node in that position
	 */
	private static TreeNode addRecursive(TreeNode current, int value) {
		if (current == null) {
			return new TreeNode(value);
		}

		if (value < current.val) {
			current.left = addRecursive(current.left, value);
		} else if (value > current.val) {
			current.right = addRecursive(current.right, value);
		} else {
			return current;
		}

		return current;
	}
}
