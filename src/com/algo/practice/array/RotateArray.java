package com.algo.practice.array;

public class RotateArray {
	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4 };
		rotate(nums, 3);
		print(nums);
		
		int[] nums2 = { 1, 2, 3, 4, 5, 6, 7 };
		rotate(nums2, 3); // 5,6,7,1,2,3,4
		print(nums2);
	}

	public static void rotate(int[] nums, int k) {
		/*
		 *  we have to first reverse the whole array by swapping first element with the last one and so on..
			you will get[7,6,5,4,3,2,1]
			
			reverse the elements from 0 to k-1
			reverse the elements 7,6,5
			you will get [5,6,7,4,3,2,1]
			
			reverse the elements from k to n-1
			reverse the elements 4,3,2,1
			you will get[5,6,7,1,2,3,4]
		 */
		k = k % nums.length;
		// rotate 1st part(i.e. from 0 length to length - k - 1) -> 1, 2, 3, 4 --> 4, 3, 2, 1
		swap(nums, 0, nums.length - 1);
		// rotate 2nd part(i.e. from  length - k to length - 1) -> 5, 6, 7 --> 7, 6, 5
		swap(nums, 0, k - 1);
		// rotate whole array(i.e from 0 length to length - 1) -> 4, 3, 2, 1, 7, 6, 5 --> 5, 6, 7, 1, 2, 3, 4 ==> Desired output
		swap(nums, k, nums.length - 1);
	}

	public static void swap(int[] nums, int start, int end) {
		while (start < end) {
			int tmp = nums[start];
			nums[start] = nums[end];
			nums[end] = tmp;
			start++;
			end--;
		}
	}

	public static void print(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i]);
			if (i < nums.length - 1)
				System.out.print(",");
		}
		System.out.println();
	}
}
