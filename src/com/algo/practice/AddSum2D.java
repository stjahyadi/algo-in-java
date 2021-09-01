package com.algo.practice;

public class AddSum2D {
	public static void main(String[] args) {
		int[][] nums1 = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		System.out.println(solution2(nums1));
	}

	public static int solution(int[][] nums) {
		int total = 0;
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < nums[i].length; j++) {
				total += nums[i][j];
			}
		}
		return total;
	}

	public static int solution2(int[][] nums) {
		int total = 0;
		int i = 0, j = 0;
		while (i < nums.length && j < nums[i].length) {
			total += nums[i][j];
			if (j < nums[i].length - 1)
				j++;
			else {
				i++;
				j = 0;
			}
		}
		return total;
	}
}
