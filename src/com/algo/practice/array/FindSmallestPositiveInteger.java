package com.algo.practice.array;
import java.util.HashSet;
import java.util.Set;

public class FindSmallestPositiveInteger {
	/*
	 * Given an array A of N integers, returns the smallest positive integer
	 * (greater than 0) that does not occur in A.
	 * 
	 * For example
	 * Given A = [1, 3, 6, 4, 1, 2], the function should return 5.
	 * Given A = [1, 2, 3], the function should return 4. 
	 * Given A = [-1, -3], the function should return 1.
	 * 
	 * Write an efficient algorithm for the following assumptions: N is an integer
	 * within the range [1..100,000]; each element of array A is an integer within
	 * the range [-1,000,000..1,000,000].
	 * 
	 */

	public static void main(String[] args) {
		int[] A1 = { 1, 3, 6, 4, 1, 2 }; // the function should return 5.
		System.out.println(solution(A1));
		int[] A2 = { 1, 2, 3 }; // the function should return 4.
		System.out.println(solution(A2));
		int[] A3 = { -1, -3 }; // the function should return 1.
		System.out.println(solution(A3));
	}

	public static int solution(int[] A) {
		Set<Integer> set = new HashSet<Integer>();
		for (int i : A) {
			if (i > 0)
				set.add(i);
		}

		for (int i = 1; i <= A.length + 1; i++) {
			if (!set.contains(i)) {
				return i;
			}
		}
		return -1;
	}
}
