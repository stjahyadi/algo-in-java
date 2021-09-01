package com.algo.practice.array;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class ReturnKLargestElementArray {
	public static void main(String[] args) {
		int[] nums = { 3, 2, 1, 5, 6, 4 };
		int k = 2;
		System.out.println(quickSelect(nums, 0, nums.length - 1, k)); // Output 5

		int[] nums2 = { 3, 2, 3, 1, 2, 4, 5, 5, 6 };
		int k2 = 4;
		System.out.println(quickSelect(nums2, 0, nums2.length - 1, k2)); // Output 4
		
		System.out.println(solution3(nums2, k2));
		
	}

	public static int solution1(int[] nums, int k) {
		// Time complexity O(n log(n))
		Arrays.sort(nums);
		return nums[nums.length - k];
	}

	public static int solution2(int[] nums, int k) {
		// Time complexity O(n log k)
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		for (int num : nums) {
			queue.add(num);
			if (queue.size() > k)
				queue.poll();
		}
		return queue.poll();
	}
	
	public static int solution3(int[] nums, int k) {
		TreeMap<Integer, Integer> map = new TreeMap<>(Collections.reverseOrder());
		for (int i : nums) {
			map.put(i, map.getOrDefault(i, 0) + 1);
		}

		int total = 0;
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			total += entry.getValue();
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
		// Find K Largest
		int pivot = low;

		// use quick sort's idea
		// put nums that are <= pivot to the left
		// put nums that are > pivot to the right
		for (int j = low; j < high; j++) {
			if (nums[j] <= nums[high]) {
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
		else if (count > k)
			return quickSelect(nums, pivot + 1, high, k);
		// pivot is too big, so it must be on the left
		else
			return quickSelect(nums, low, pivot - 1, k - count);
	}

}
