package com.algo.practice.module.tree;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class TreeTraversal {
	
	/*
	 *      1
	 *     /  \
	 *    2    3 
	 *   / \   / 
	 *  4   5 6
	 *       
	 */
	public static void main(String[] args) {
		//https://www.geeksforgeeks.org/dfs-traversal-of-a-tree-using-recursion/
		TreeNode root = initialise();
		System.out.println("Inorder");
		System.out.println("=======");
		print(inOrderTraversal(root)); // Inorder (Left, Root, Right) : 4 2 5 1 6 3
		System.out.println();
		List<Integer> output = new ArrayList<>();
		inOrderRecursive(root, output);
		print(output);
		System.out.println();
		
		System.out.println("Preorder");
		System.out.println("=======");
		print(preOrderTraversal(root)); // Preorder (Root, Left, Right) : 1 2 4 5 3 6
		
		output.clear();
		preOrderRecursive(root, output);
		System.out.println();
		print(output);
		System.out.println();
		
		System.out.println("Postorder");
		System.out.println("=======");
		print(postOrderTraversal(root)); // Postorder (Left, Right, Root) : 4 5 2 6 3 1
		System.out.println();
		output.clear();
		postOrderRecursive(root, output);
		print(output);
	}

	public static List<Integer> inOrderTraversal(TreeNode root) {
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
	
	public static void inOrderRecursive(TreeNode root, List<Integer> output) {
		if(root != null) {
			inOrderRecursive(root.left, output);
			output.add(root.val);
			inOrderRecursive(root.right, output);
		}
	}

	public static List<Integer> preOrderTraversal(TreeNode root) {
		List<Integer> output = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		TreeNode current = root;
		stack.push(current);
		/*
		 * Pop all items one by one. Do following for every popped item 
		 * a) print it 
		 * b) push its right child 
		 * c) push its left child 
		 * Note that right child is pushed first so that left is processed first
		 */
		while (!stack.isEmpty()) {
			current = stack.pop();
			output.add(current.val);
			if(current.right != null)
				stack.push(current.right);
			if(current.left != null)
				stack.push(current.left);
		}
		return output;
	}
	
	public static void preOrderRecursive(TreeNode root, List<Integer> output) {
		if(root != null) {
			output.add(root.val);
			preOrderRecursive(root.left, output);
			preOrderRecursive(root.right, output);
		}
	}

	public static List<Integer> postOrderTraversal(TreeNode root) {
		List<Integer> output = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		TreeNode current = root;
		stack.push(current);
		while (!stack.isEmpty()) {
			current = stack.pop();
			output.add(0, current.val);
			if(current.left != null)
				stack.push(current.left);
			if(current.right != null)
				stack.push(current.right);
		}
		return output;
	}
	
	public static void postOrderRecursive(TreeNode root, List<Integer> output) {
		if(root != null) {
			postOrderRecursive(root.left, output);
			postOrderRecursive(root.right, output);
			output.add(root.val);
		}
	}

	public static void print(List<Integer> output) {
		for (int i = 0; i < output.size(); i++) {
			System.out.print(output.get(i));
			if (i < output.size() - 1)
				System.out.print(", ");
		}
	}

	public static TreeNode initialise() {
		TreeNode left = new TreeNode(2, new TreeNode(4), new TreeNode(5));
		TreeNode right = new TreeNode(3, new TreeNode(6), null);
		TreeNode root = new TreeNode(1, left, right);
		return root;
	}
}
