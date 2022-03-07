package com.algo.practice;

import java.util.ArrayList;
import java.util.List;

public class ReturnMaximumTwoDigits {
	public static void main(String[] args) {
		System.out.println(solution("50552"));
		System.out.println(solution("10101"));
		System.out.println(solution("88"));
		System.out.println(solution("8810"));
	}

	public static int solution(String S) {
		// write your code in Java SE 8
		List<Integer> output = new ArrayList<>();
		int len = S.length();
		if (len % 2 == 0) {
			for (int i = 0; i < len - 1; i+=2) {
				char c1 = S.charAt(i);
				char c2 = S.charAt(i+1);
				String data = String.valueOf(new char[] {c1, c2});
				output.add(Integer.valueOf(data));
			}
		} else {
			for (int i = 0; i < len - 1; i++) {
				char c1 = S.charAt(i);
				char c2 = S.charAt(i+1);
				String data = String.valueOf(new char[] {c1, c2});
				output.add(Integer.valueOf(data));
			}
		}
		
		int max = 0;
		for(Integer i : output) {
			max = Math.max(i, max);
		}
		return max;
	}
}
