package com.algo.practice.array;

public class ReturnFirstAndLastPositionSortedArray {
	public static void main(String[] args) {
		int[] nums = { 5, 7, 7, 8, 8, 10 };
		int target = 8; // Output: [3,4]
		int[] output = solution(nums, target);
		System.out.println(output[0] + "," + output[1]);

		int[] nums2 = { 5, 7, 7, 8, 8, 10 };
		int target2 = 6; // Output: [-1,-1]
		int[] output2 = solution(nums2, target2);
		System.out.println(output2[0] + "," + output2[1]);

		int[] nums3 = {};
		int target3 = 0; // Output: [-1,-1]
		int[] output3 = solution(nums3, target3);
		System.out.println(output3[0] + "," + output3[1]);

	}

	public static int[] solution(int[] nums, int target) {
		int[] result = new int[2];
		result[0] = findFirst(nums, target);
		result[1] = findLast(nums, target);
		return result;
	}

	public static int findFirst(int[] nums, int target) {
		int start = 0;
		int end = nums.length - 1;
		int idx = -1;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (nums[mid] >= target)
				end = mid - 1;
			else if (nums[mid] <= target)
				start = mid + 1;

			if (nums[mid] == target)
				idx = mid;
		}
		return idx;
	}

	public static int findLast(int[] nums, int target) {
		int start = 0;
		int end = nums.length - 1;
		int idx = -1;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (nums[mid] <= target)
				start = mid + 1;
			else if (nums[mid] >= target)
				end = mid - 1;

			if (nums[mid] == target)
				idx = mid;
		}
		return idx;
	}

	public static int[] solution2(int[] nums, int target) {
		// Time Complexity O(n)
		int[] output = { -1, -1 };
		int index = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == target)
				output[index++] = i;
		}
		return output;
	}
}
