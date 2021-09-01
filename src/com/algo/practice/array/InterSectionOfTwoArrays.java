package com.algo.practice.array;
import java.util.Arrays;

public class InterSectionOfTwoArrays {
	public static void main(String[] args) {
		int[] nums1 = { 4, 9, 5 };
		int[] nums2 = { 9, 4, 9, 8, 4 };
		print(intersection(nums1, nums2));
		System.out.println();
		int[] nums11 = { 1, 2, 2, 1 };
		int[] nums22 = { 2, 2 };
		print(intersection(nums11, nums22));
	}

	public static int[] intersection(int[] nums1, int[] nums2) {
		/*
		 * Note Facebook interview question
		 * Then they ask you to solve it under these
		 * constraints: O(n) time and O(1) space (the resulting array of intersections
		 * is not taken into consideration). 
		 * 
		 * You are told the lists are sorted.
		 * 
		 * Cases to take into consideration include: duplicates, negative values, single
		 * value lists, 0's, and empty list arguments. Other considerations might
		 * include sparse arrays.
		 * 
		 */
		Arrays.sort(nums1);
		Arrays.sort(nums2);

		int i = 0, j = 0, k = 0;
		while (i < nums1.length && j < nums2.length) {
			if (nums1[i] == nums2[j]) {
				if(k == 0 || nums1[i] != nums1[k-1])
					nums1[k++] = nums1[i];
				i++;
				j++;
			} else if (nums1[i] < nums2[j])
				i++;
			else
				j++;
		}

		return Arrays.copyOf(nums1, k);
	}

	public static void print(int[] output) {
		for (int i = 0; i < output.length; i++) {
			System.out.print(output[i]);
			if (i < output.length - 1)
				System.out.print(", ");
		}
	}
}
