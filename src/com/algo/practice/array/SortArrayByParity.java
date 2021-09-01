package com.algo.practice.array;

public class SortArrayByParity {
	public static void main(String[] args) {
		int nums1[] = { 3, 2, 1, 4 };
		print(solution(nums1)); // [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
	}

	public static void print(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i]);
			if (i < nums.length - 1) {
				System.out.print(", ");
			}
		}
	}

	public static int[] solution(int[] nums) {
		int j = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] % 2 == 0) {
				int tmp = nums[i];
				nums[i] = nums[j];
				nums[j] = tmp;
				j++;
			}
		}
		return nums;
	}

}
