package com.algo.practice.module.string;

public class RomanToInt {
	public static void main(String[] args) {
		System.out.println(romanToInt("III")); // 3
		System.out.println(romanToInt("IV")); // 4
		System.out.println(romanToInt("IX")); // 9
		System.out.println(romanToInt2("XL")); // 40
		System.out.println(romanToInt2("XLVIII")); // 48
		System.out.println(romanToInt("LVIII")); // 58
		System.out.println(romanToInt("MCMXCIV")); // 1994
	}

	public static int romanToInt(String s) {
		int n = 0;
		char prev = ' ';
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			n += getValue(c, prev);
			prev = c;
		}

		return n;
	}

	private static int getValue(char c, char prev) {
		switch (c) {
		case 'I':
			return 1;
		case 'V':
			return prev == 'I' ? 3 : 5;
		case 'X':
			return prev == 'I' ? 8 : 10;
		case 'L':
			return prev == 'X' ? 30 : 50;
		case 'C':
			return prev == 'X' ? 80 : 100;
		case 'D':
			return prev == 'C' ? 300 : 500;
		case 'M':
			return prev == 'C' ? 800 : 1000;
		}

		throw new IllegalArgumentException();
	}

	public static int romanToInt2(String s) {
		int n = 0;
		for (int i = 0; i < s.length() - 1; i++) {
			int a = getValue2(s.charAt(i));
			int b = getValue2(s.charAt(i + 1));
			if (a < b) {
				n -= a;
			} else {
				n += a;
			}
		}
		n += getValue2(s.charAt(s.length() - 1));
		return n;
	}

	private static int getValue2(char c) {
		if (c == 'I')
			return 1;
		else if (c == 'V')
			return 5;
		else if (c == 'X')
			return 10;
		else if (c == 'L')
			return 50;
		else if (c == 'C')
			return 100;
		else if (c == 'D')
			return 500;
		else
			return 1000;
	}
}
