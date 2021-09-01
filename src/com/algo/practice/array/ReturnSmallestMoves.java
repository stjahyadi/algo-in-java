package com.algo.practice.array;
import java.util.Arrays;

public class ReturnSmallestMoves {
	public static void main(String[] args) {
		// int A[] = { 1, 2, 1 };
		// Expected output: 1,2,2 -> 1,2,3
		// Expected output: [3,2,1], [1,3,2], [2,3,1]
		// int A[] = { 2, 1, 4, 4 };
		int A[] = { 6, 2, 3, 5, 6, 3 };
		System.out.println(solution(A));
	}

	public static int solution(int[] A) {
		Arrays.sort(A);
		int counter = 0;
		int max = A.length;
		for (int i = 1; i < max; i++) {
			while (A[i] <= A[i - 1]) {
				if (A[i] < max)
					A[i]++;
				else
					A[i]--;
				counter++;
				Arrays.sort(A);
			}
		}
		print(A);
		System.out.println();
		return counter;
	}

	public static int minIncrementForUnique(int[] A) {
		Arrays.sort(A);
		int counter = 0;
		int max = A.length;
		for (int i = 1; i < max; i++) {
			while (A[i] <= A[i - 1]) {
				A[i]++;
				counter++;
			}
		}
		print(A);
		System.out.println();
		return counter;
	}

	public static void print(int[] A) {
		for (int i = 0; i < A.length; i++) {
			System.out.print(A[i]);
			if (i < A.length - 1)
				System.out.print(",");
		}
	}

}
