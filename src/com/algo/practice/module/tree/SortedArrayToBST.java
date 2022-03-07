package com.algo.practice.module.tree;

public class SortedArrayToBST {
	public static void main(String[] args) {
		int[] nums = { -10, -3, 0, 5, 9 };
		sortedArrayToBST(nums);

		int[] nums2 = { -3, -2, -1, 0, 1, 2, 3 };
		sortedArrayToBST(nums2);

		int[] nums3 = { -4, -3, -2, -1, 0, 1, 2, 3, 4 };
		sortedArrayToBST(nums3);
	}

	public static TreeNode sortedArrayToBST(int[] nums) {
		TreeNode head = helper(nums, 0, nums.length - 1);
		return head;
	}

	public static TreeNode helper(int[] nums, int low, int high) {
		if (low > high)
			return null;

		int mid = (low + high) / 2;
		TreeNode root = new TreeNode(nums[mid]);
		root.left = helper(nums, low, mid - 1);
		root.right = helper(nums, mid + 1, high);
		return root;
	}
}
