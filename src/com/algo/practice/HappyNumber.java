package com.algo.practice;

public class HappyNumber {
	public static void main(String[] args) {
		System.out.println(isHappy(19));
		System.out.println(isHappy(2));

	}

	public static boolean isHappy(int n) {
		while (true) {
			int sum = 0;
			while (n != 0) {
				// here, we have to extract the digits from the given number starting from the
				// last one
				int lastDigit = n % 10;
				sum += lastDigit * lastDigit; // add that digit to the sum, by squaring it
				n /= 10;
			}
			// if it is a single digit number, check if it 1 or 7
			if (sum / 10 == 0) {
				// if yes, then this a happy number
				if (sum == 1 || sum == 7)
					return true;
				else // else you want to terminate the loop as it isn't a happy number
					return false;
			}
			n = sum;
		}
	}
}
