package com.algo.practice.array;
import java.util.Arrays;

public class Return2ndHighestNum {
	/*
	 * https://www.geeksforgeeks.org/find-second-largest-element-array/
	 */
	public static void main(String[] args) {
		int[] nums1 = { 5, -5, -1 }; // -1
		System.out.println(solution3(nums1));
		int[] nums2 = { 1, 2, 3, 4 }; // 3
		System.out.println(solution3(nums2));
		int[] nums3 = { 5, 1, 5, 4, 3 }; // 5
		System.out.println(solution3(nums3));
	}

	public static int solution2(int[] nums) {
		Arrays.sort(nums);
		return nums[nums.length - 2];
	}

	public static int solution3(int[] nums) {
		int max = nums[0];
		int index = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > max) {
				max = nums[i];
				index = i;
			}
		}
		
		int secondMax = -1;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == max && i == index) {
				continue;
			}

			if (nums[i] >= secondMax) {
				secondMax = nums[i];
			}

		}

		return secondMax;
	}
	
}
