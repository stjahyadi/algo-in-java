package com.algo.practice.array;
import java.util.HashSet;
import java.util.Set;

public class ReturnLargestKValue {
	/*
	 * Write a function that, 
	 * given an array A of N integers, returns the largest
	 * integer K > 0 such that both values K and -K exist in array A. 
	 * If there is no such integer, the function should return 0.
	 */
	public static void main(String[] args) {
		int[] A1 = { 3, 2, -2, 5, -3 };
		System.out.println(solution(A1));
		
		int[] A2 = {1, 2, 3, -4 };
		System.out.println(solution(A2));
	}

	public static int solution(int[] A) {
		Set<Integer> set = new HashSet<>();
		for (int i : A) {
			set.add(i);
		}
		int temp = 0;
		for (int i : A) {
			if (set.contains(i) && set.contains(Math.negateExact(i))) {
				temp = Math.max(temp, i);
			}
		}
		return temp;
	}
}
