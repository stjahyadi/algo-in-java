package com.algo.practice;

public class FibonacciSolution {

	public static int fib(int n) {
		// A naive recursive solution
		if (n == 1 || n == 2)
			return 1;
		else
			return fib(n - 1) + fib(n - 2);
	}

	public static void main(String[] args) {
		System.out.println(fib(5));
		int n = 1000;
		int[] fib = new int[n + 1];
		System.out.println(fib(fib, n));
		System.out.println(fib_bottom_up(n));

	}

	public static int fib(int[] memo, int n) {
		// A memoized solution
		int result = 0;
		if (memo[n] != 0)
			return memo[n];
		if (n == 1 || n == 2)
			result = 1;
		else
			result = fib(memo, n - 1) + fib(memo, n - 2);

		memo[n] = result;
		return result;
	}

	public static int fib_bottom_up(int n) {
		// A bottom-up solution
		int[] bottom_up = new int[n];
		bottom_up[0] = 1;
		bottom_up[1] = 1;
		for (int i = 2; i < n; i++) {
			bottom_up[i] = bottom_up[i - 1] + bottom_up[i - 2];
		}
		return bottom_up[n - 1];
	}
}
