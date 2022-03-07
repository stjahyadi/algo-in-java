package com.algo.practice;

import java.util.Scanner;

public class ProblemX {
	public static void main(String[] args) {
//		System.out.println(solution("ABCD")); // 0
//		System.out.println(solution("AABBBCDD")); // 4
//		System.out.println(solution("ABBBCD")); // 2
//		System.out.println(solution("AOBBBCD")); // 2
//		System.out.println(solution("O")); //
		
		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		in.close();
		System.out.println(solution(input.toUpperCase()));
	}

	public static int solution(String input) {
		int slow = 0;
		int counter = 0;
		for (int i = 1; i < input.length(); i++) {
			char c = input.charAt(i);
			char p = input.charAt(slow);
			if(c == 'O')
				break;
			if (c == p) {
				counter++;
			}
			slow++;
		}

		return counter;
	}
}
