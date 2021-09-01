package com.algo.practice.array;
import java.util.ArrayList;
import java.util.List;

public class NumIdenticalPairs {
	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 1, 1, 3 };
		System.out.println(numIdenticalPairs(nums)); // Expected output: 4

		int[] nums2 = { 1, 1, 1, 1 };
		System.out.println(numIdenticalPairs(nums2)); // Expected output: 6

		int[] nums3 = { 1, 2, 3 };
		System.out.println(numIdenticalPairs(nums3)); // Expected output: 0
	}

	public static int numIdenticalPairs(int[] nums) {
		int i = 0, j = 1;
		int n = nums.length;
		List<String> temp = new ArrayList<>();
		int count = 0;
		while (i < j) {
			if (nums[i] == nums[j] && i < j) {
				temp.add("(" + i + "," + j + ")");
				count++;
			}

			if (j < n - 1)
				j++;
			else {
				i++;
				if (i < n - 1)
					j = i + 1;
			}
		}
		print(temp);
		return count;
	}

	public static void print(List<String> data) {
		for (String a : data) {
			System.out.println(a);
		}
	}
}
