package com.algo.practice;

public class ClimbingStairs {
	public static void main(String[] args) {
		System.out.println(climbStairs3(5)); // 8
		System.out.println(climbStairs3(6)); // 13
		System.out.println(climbStairs3(7)); // 21
	}

	public static int climbStairs(int n) {
		// Using recursive solution
		// Time complexity - O(2^n)
		if (n == 1 || n == 2)
			return n;
		else
			return climbStairs(n - 1) + climbStairs(n - 2);
	}

	public static int climbStairs2(int n) {
		// Using memoized solution
		// Time complexity - O(n)
		// Space complexity - O(n)
		int[] cache = new int[n + 1];
		return memoized(cache, n);
	}

	public static int memoized(int[] cache, int n) {
		if (n == 1 || n == 2)
			return n;
		if (cache[n] != 0)
			return cache[n];
		else
			return cache[n] = climbStairs(n - 1) + climbStairs(n - 2);
	}

	public static int climbStairs3(int n) {
		// Time complexity - O(n)
		// Space complexity - O(1)
		int first = 1, second = 1, sum = 0;
		for (int i = 2; i <= n; i++) {
			sum = first + second;
			first = second;
			second = sum;
		}
		return sum;
	}
}
