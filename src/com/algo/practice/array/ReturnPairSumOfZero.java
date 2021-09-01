package com.algo.practice.array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ReturnPairSumOfZero {
	public static void main(String[] args) {
		int[] nums = { -1, 0, 1, 2, -2, -1 };
		print(solution(nums));
	}

	public static void print(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i]);
			if (i < nums.length - 1)
				System.out.print(" ");
		}
	}

	public static int[] solution(int[] nums) {
		Set<Integer> set = new HashSet<>();
		for (int i : nums) {
			set.add(i);
		}
		List<Integer> sums = new ArrayList<>();
		for (int i : nums) {
			if (set.contains(i) && set.contains(-i) && i != 0) {
				if (!sums.contains(i) && !sums.contains(-i)) {
					sums.add(i);
					sums.add(-i);
				}
			}
		}

		return sums.stream().mapToInt(Integer::intValue).toArray();
	}
}
