package com.algo.practice;

import java.util.Scanner;

public class ProblemY {
	public static void main(String[] args) {
//		Scanner in = new Scanner(System.in);
//		int input = in.nextInt();
//		in.close();
//		System.out.println(solution(input));

		//solution(12); // 3
		//solution(14); // 6
		//solution(11); // No Solution.
		solution(20); // 1
		//solution(0);
	}

	public static void solution(int sushi) {
		if(sushi <= 0)
			throw new IllegalArgumentException();
		if(sushi % 2 != 0)
			throw new IllegalArgumentException("No solution.");
		for (int i = 2; i < sushi; i++) {
			if (sushi % i == 0)
				System.out.println(i-1);
		}
	}
}
