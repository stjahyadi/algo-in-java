package com.algo.practice.array;

public class BinarySearchArray {
	public static void main(String[] args) {
		int arr[] = { 2, 3, 4, 10, 40 };
		int target = 40;
		System.out.println(binarySearch(arr, target));

		// Must be sorted array
		// Must check whether the elements are unique, otherwise will need to handle differently
		int arr2[] = { 2, 5, 8, 12, 16, 23, 38, 56, 72, 91 };
		int target2 = 23;
		System.out.println(binarySearch(arr2, target2));
		
		int arr3[] = { 1, 2, 3, 4, 5, 6, 7 };
		int target3 = 6;
		System.out.println(binarySearch(arr3, target3)); // index: 5
	}

	public static int binarySearch(int[] nums, int target) {
		int start = 0;
		int end = nums.length - 1;
		int idx = -1;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (nums[mid] == target)
				return mid;

			if (nums[mid] < target)
				start = mid + 1;
			else
				end = mid - 1;

		}
		return idx;
	}
}
