package com.algo.practice.module.string;
import java.util.Stack;

public class AddStrings {

	public static void main(String[] args) {
		System.out.println(addStrings2("11", "123")); // 134
		System.out.println(addStrings2("456", "77")); // 533
		System.out.println(addStrings2("0", "0")); // 533
		System.out.println(addStrings2("6913259244", "71103343")); // 6984362587
	}

	public static String addStrings(String num1, String num2) {
		Stack<Integer> s1 = new Stack<>();
		Stack<Integer> s2 = new Stack<>();
		for (int i = 0; i < num1.length(); i++)
			s1.push(Character.getNumericValue(num1.charAt(i)));
		for (int i = 0; i < num2.length(); i++)
			s2.push(Character.getNumericValue(num2.charAt(i)));
		int carry = 0;
		StringBuilder sb = new StringBuilder();
		while (!s1.isEmpty() || !s2.isEmpty() || carry != 0) {
			int n1 = s1.isEmpty() ? 0 : s1.pop();
			int n2 = s2.isEmpty() ? 0 : s2.pop();
			int val = n1 + n2 + carry;
			if (val >= 10) {
				val = val % 10;
				carry = 1;
			} else
				carry = 0;

			sb.append(val);
		}
		return sb.reverse().toString();
	}

	public static String addStrings2(String num1, String num2) {
		int i = num1.length() - 1;
		int j = num2.length() - 1;
		int carry = 0;
		StringBuilder sb = new StringBuilder();
		while (i >= 0 || j >= 0 || carry != 0) {
			int n1 = 0;
			int n2 = 0;

			if (i >= 0) {
				n1 = num1.charAt(i) - '0';
				i--;
			}

			if (j >= 0) {
				n2 = num2.charAt(j) - '0';
				j--;
			}

			int val = n1 + n2 + carry;
			if (val >= 10) {
				val = val % 10;
				carry = 1;
			} else
				carry = 0;

			sb.append(val);
		}

		return sb.reverse().toString();

	}
}
