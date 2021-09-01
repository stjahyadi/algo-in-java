package com.algo.practice.array;
import java.util.HashMap;
import java.util.Map;

public class SingleNumber {
	public static void main(String[] args) {
		int[] nums1 = { 2, 2, 1 };
		System.out.println(solution(nums1));
		System.out.println(solution2(nums1));

		int[] nums2 = { 4, 1, 2, 1, 2 };
		System.out.println(solution(nums2));
		System.out.println(solution2(nums2));

		int[] nums3 = { 1 };
		System.out.println(solution(nums3));
		System.out.println(solution2(nums3));
	}

	public static int solution(int[] nums) {
		// Time Complexity and Space Complexity are O(n)
		Map<Integer, Integer> map = new HashMap<>();
		for (int num : nums) {
			map.put(num, map.getOrDefault(num, 0) + 1);
		}

		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if (entry.getValue() == 1)
				return entry.getKey();
		}
		return 0;
	}

	public static int solution2(int[] nums) {
		// Time Complexity is O(n) and Space Complexity is O(1)
		/*
		 * result ^= num is equivalent to result = result ^ i.. the rationale is that A^A = 0, and A^B^A=B. 
		 * So if all the number are repeated twice, all the repeated numbers will result in 0 and the only number that is not repeated will be in the result.
		 */
		int result = 0;
		for (int num : nums) {
			result ^= num;
		}
		return result;
	}
}
