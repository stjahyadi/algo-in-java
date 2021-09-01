package com.algo.practice;

public class ReturnTotalNumberPalindrome {
	public static void main(String[] args) {
		System.out.println(reverse(123));
	}

	public static int reverse(int num) {
		int reverse = 0;
		// run loop until num becomes 0
		while (num != 0) {
			// get last digit from num
			int digit = num % 10;
			reverse = reverse * 10 + digit;

			// remove the last digit from num
			num = num / 10;
		}
		return reverse;
	}

}
