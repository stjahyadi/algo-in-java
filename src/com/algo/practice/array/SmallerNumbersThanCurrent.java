package com.algo.practice.array;

public class SmallerNumbersThanCurrent {

	public static void main(String[] args) {
		int[] nums = { 8, 1, 2, 2, 3 };
		print(smallerNumbersThanCurrent(nums));
	}

	public static void print(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i]);
			if (i < nums.length-1)
				System.out.print(",");
		}
	}

	public static int[] smallerNumbersThanCurrent(int[] nums) {
		int n = nums.length;
		int[] result = new int[n];
		int i = 0, j = 0;
		while (i < n) {
			if (i != j && nums[j] < nums[i])
				result[i] += 1;

			if (j < n - 1)
				j++;
			else {
				i++;
				j = 0;
			}
		}
		return result;

	}
}
