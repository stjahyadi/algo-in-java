package com.algo.practice.module.string;

public class StrSymmetryPoint {
	public static void main(String[] args) {
		System.out.println(solution("racecar")); // 3
		System.out.println(solution("x")); // 0
		System.out.println(solution("xaax")); // -1
	}

	public static int solution(String S) {
		int n = S.length();
		if (n % 2 == 0)
			return -1;
		if (n == 1)
			return 0;
		int m = S.length() / 2;
		for (int i = 1; i <= m; i++)
			if (S.charAt(m - i) != S.charAt(m + i))
				return -1;
		return m;
	}
}
