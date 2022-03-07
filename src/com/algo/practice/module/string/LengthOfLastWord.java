package com.algo.practice.module.string;

public class LengthOfLastWord {
	public static void main(String[] args) {
		System.out.println(solution2(" a")); // 1
		System.out.println(solution2("a")); // 1
		System.out.println(solution2("Hello World")); // 5
		System.out.println(solution2("   fly me   to   the moon  ")); // 4
	}

	public static int solution(String s) {
		int i = s.length() - 1;
		boolean stop = false;
		while (!stop && i > 0) {
			i--;
			if (i > 0 && s.charAt(i - 1) == ' ' && s.charAt(i) != ' ')
				stop = true;
		}
		// System.out.println(s.substring(i).trim());
		return s.substring(i).trim().length();
	}

	public static int solution2(String s) {
		int len = 0;
		for (int i = s.length() - 1; i >= 0; i--) {
			if (s.charAt(i) == ' ') {
				if (len != 0)
					return len;
			} else {
				len++;
			}
		}
		return len;
	}
}
