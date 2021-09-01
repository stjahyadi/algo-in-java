package com.algo.practice;
import java.util.Arrays;
import java.util.List;

public class PlusMinus {
	public static void main(String[] args) {
		plusMinus(Arrays.asList(new Integer[] { -4, 3, -9, 0, 4, 1 }));
	}

	public static void plusMinus(List<Integer> arr) {
		// Write your code here
		int[] temp = { 0, 0, 0 };
		for (int i : arr) {
			if (i > 0)
				temp[0] += 1;
			else if (i < 0)
				temp[1] += 1;
			else
				temp[2] += 1;
		}

		for (int i : temp) {
			System.out.printf("%.6f\n", (double) i / arr.size());
		}

	}
}
