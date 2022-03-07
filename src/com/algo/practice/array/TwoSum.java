package com.algo.practice.array;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TwoSum {

	public static void main(String[] args) {
		int[] nums = { 3, 5, 1 };
		int target = 6;
		print(solution2(nums, target)); //1 2
		print(twoSum(nums, target)); //1 2
		print(twoSumWithResult(nums, target));
		System.out.println();
		
		int[] nums2 = { 3, 2, 4 };
		print(twoSum(nums2, target)); //1 2
		print(twoSumWithResult(nums2, target));
		System.out.println();
		
		int[] nums3 = { 3, 3 };
		print(twoSum(nums3, target)); //0 1
		print(twoSumWithResult(nums3, target));
		System.out.println();
		
		int[] nums4 = { 2, 7, 11, 15 };
		int target4 = 9;
		print(twoSum(nums4, target4)); //0 1
		print(twoSumWithResult(nums4, target4));
	}
	
	public static int[] solution2(int[] nums, int target) {
		int n = nums.length;
		int i = 0, j = n - 1;
		//Arrays.sort(nums);
		while (i < j) {
			if (nums[i] + nums[j] == target) {
				return new int[] { i, j };
			} else if (nums[i] + nums[j] < target) {
				i++;
			} else
				j--;
		}
		throw new IllegalArgumentException("No Solution!");
	}

	public static int[] twoSum(int[] nums, int target) {
		//Brute Force with time complexity O(n^2) and space complexity O(1)
		/*
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] + nums[j] == target) {
					return new int[] { i, j };
				}
			}
		}
		*/
		
		//Use two-pointer with time complexity O(n*log(n)) due to sort
		/*
		Arrays.sort(nums);
		int left = 0;
		int right = nums.length - 1;
		while (left < right) {
			if (nums[left] + nums[right] == target)
				return new int[] { left, right };
			else if (nums[left] + nums[right] < target)
				left++;
			else
				right--;
		}
		*/
		
		//Time complexity O(n) and space complexity O(n)
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			int complement = target - nums[i];
			if (map.containsKey(complement)) {
				return new int[] { map.get(complement), i };
			}
			map.put(nums[i], i);
		}
		
		throw new IllegalArgumentException("No Solution!");
	}
	
	public static int[] twoSumWithResult(int[] nums,int target) {
		Set<Integer> set = new HashSet<>();
		for(int i : nums) {
			int complement = target - i;
			if(set.contains(complement)) {
				return new int[] {i, complement};
			}
			set.add(i);
		}
		throw new IllegalArgumentException("No Solution!");
	}
	
	public static void print(int[]output) {
		for (int i = 0; i < output.length; i++) {
			System.out.print(output[i] + " ");
		}
		System.out.println();
	}
}
