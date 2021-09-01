package com.algo.practice.array;

public class ReturnBiggestNumberSubArray {
	public static void main(String[] args) {
		int[] nums1 = { 5, 6, 8, 2, 7 }; // [8,8,-1,7,-1]
		print(naiveSolution(nums1));
		System.out.println();
		print(solution(nums1));
	}

	public static int[] naiveSolution(int[] nums) {
		int max = -1;
		int[] result = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[j] > max)
					max = nums[j];
			}
			if (max > nums[i])
				result[i] = max;
			else
				result[i] = -1;
			max = -1;
		}
		return result;
	}

	public static int[] solution(int[] nums) {
		int n = nums.length;
		int[] result = new int[n];
		int i = 0, j = 1;
		int max = -1;
		while (i < n) {
			int current = nums[i];
			if (j < n && nums[j] > max) {
				max = nums[j];
			}

			if (j > n - 1) {
				if (max > current)
					result[i] = max;
				else
					result[i] = -1;
				i++;
				j = i + 1;
				max = -1;
			} else {
				j++;
			}
		}

		return result;
	}

	public static void print(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i]);
			if (i < nums.length - 1)
				System.out.print(",");
		}
	}
}
