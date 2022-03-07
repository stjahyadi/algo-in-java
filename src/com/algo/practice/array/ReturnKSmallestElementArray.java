package com.algo.practice.array;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class ReturnKSmallestElementArray {
	public static void main(String[] args) {
		int[] nums = { 4, 4, 2, 1, 6, 2 };
		int k = 2;
		System.out.println(quickSelect(nums, 0, nums.length - 1, k)); // 2
		System.out.println(solution(nums, k)); // 2
	}

	public static int solution(int[] nums, int k) {
		Arrays.sort(nums);
		return nums[k - 1];
	}

	public static int solution2(int[] nums, int k) {
		TreeMap<Integer, Integer> map = new TreeMap<>();
		for (int i : nums) {
			map.put(i, map.getOrDefault(i, 0) + 1);
		}

		int total = 0;
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			// adding the frequencies of each element
			total += entry.getValue();
			// if at any point frequency becomes
			// greater than or equal to k then
			// return that element
			if (total >= k)
				return entry.getKey();
		}
		return -1;
	}

	private static void swap(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}

	public static int quickSelect(int[] nums, int low, int high, int k) {
		// Find K Smallest
		int pivot = low;

		// use quick sort's idea
		// put nums that are <= pivot to the left
		// put nums that are > pivot to the right
		for (int j = low; j < high; j++) {
			if (nums[j] >= nums[high]) {
				swap(nums, pivot++, j);
			}
		}
		swap(nums, pivot, high);

		// count the nums that are > pivot from high
		int count = high - pivot + 1;
		// pivot is the one!
		if (count == k)
			return nums[pivot];
		// pivot is too small, so it must be on the right
		if (count > k)
			return quickSelect(nums, pivot + 1, high, k);
		// pivot is too big, so it must be on the left
		return quickSelect(nums, low, pivot - 1, k - count);
	}
}
