package com.algo.practice.array;
import java.util.HashSet;
import java.util.Set;

public class FindMissingNumber {
	public static void main(String[] args) {
		int[] nums = { 9, 6, 4, 2, 3, 5, 7, 0, 1 }; // 8
		System.out.println(solution(nums));
		
		int[] nums2 = { 0 }; // 1
		System.out.println(solution(nums2));
	}

	public static int solution(int[] nums) {
		Set<Integer> set = new HashSet<>();
		for (int i : nums) {
			set.add(i);
		}

		for (int i = 1; i <= nums.length + 1; i++) {
			if (!set.contains(i))
				return i;
		}
		return -1;
	}
}
