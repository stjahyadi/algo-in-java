package com.algo.practice;

public class SearchInsertPosition {
	public static void main(String[] args) {
		int[] nums = { 1, 3, 5, 6 };
		System.out.println(searchInsertWithBinarySearch(nums, 5));// Expected 2

		System.out.println(searchInsertWithBinarySearch(nums, 2)); // Expected 1
		System.out.println(searchInsertWithBinarySearch(nums, 4)); // Expected 2
		System.out.println(searchInsertWithBinarySearch(nums, 7)); // Expected 4

		int[] nums2 = { 2, 5 };
		System.out.println(searchInsertWithBinarySearch(nums2, 1)); // Expected 0

		int[] nums3 = { 0 };
		System.out.println(searchInsertWithBinarySearch(nums3, 0)); // Expected 0

	}

	public static int searchInsert(int[] nums, int target) {
		// Time complexity O(n)
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == target)
				return i;
			else if (nums[i] > target)
				return i;
		}
		return nums.length;
	}

	public static int searchInsertWithBinarySearch(int[] nums, int target) {
		// Time complexity O(log n)
		if (nums.length == 0)
			return 0;
		if (target <= nums[0])
			return 0;
		if (target > nums[nums.length - 1])
			return nums.length;

		int low = 0;
		int high = nums.length - 1;
		int mid = (low + high) / 2;

		while (low != mid) {
			if (target == nums[mid])
				return mid;
			if (target < nums[mid])
				high = mid;
			else
				low = mid;
			mid = (low + high) / 2;
		}
		return high;
	}
}
