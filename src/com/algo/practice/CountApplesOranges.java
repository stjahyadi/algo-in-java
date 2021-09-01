package com.algo.practice;

public class CountApplesOranges {
	public static void main(String[] args) {
		int[] apples1 = { -2, 2, 1 };
		int[] oranges1 = { 5, -6 };
		solution2(7, 11, 5, 15, apples1, oranges1); // 1 1

		int[] apples2 = { -2 };
		int[] oranges2 = { -1 };
		// solution2(2, 3, 1, 5, apples2, oranges2); // 0 0
	}

	public static void solution(int s, int t, int a, int b, int[] apples, int[] oranges) {
		int countApples = 0;
		for (int i = 0; i < apples.length; i++) {
			int tmp = a + apples[i];
			if (tmp >= s && tmp <= t)
				countApples++;
		}

		int countOranges = 0;
		for (int i = 0; i < oranges.length; i++) {
			int tmp = b + oranges[i];
			if (tmp >= s && tmp <= t)
				countOranges++;
		}

		System.out.println(countApples + " " + countOranges);
	}

	public static void solution2(int s, int t, int a, int b, int[] apples, int[] oranges) {
		int i = 0, j = 0;
		int countApples = 0, countOranges = 0;
		while (i < apples.length || j < oranges.length) {
			if (i < apples.length) {
				int tmp1 = a + apples[i];
				if (tmp1 >= s && tmp1 <= t)
					countApples++;
			}

			if (j < oranges.length) {
				int tmp2 = b + oranges[j];
				if (tmp2 >= s && tmp2 <= t)
					countOranges++;
			}

			i++;
			j++;
		}
		System.out.println(countApples + " " + countOranges);
	}
}
