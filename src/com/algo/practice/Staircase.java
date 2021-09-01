package com.algo.practice;

public class Staircase {
	public static void main(String[] args) {
		staircase2(6);
	}

	public static void staircase(int n) {
		for (int i = 1; i <= n; i++) {
			for (int j = n - i; j > 0; j--) {
				System.out.print(" ");
			}
			for (int j = i; j > 0; j--) {
				System.out.print("#");
			}
			System.out.println();
		}
	}

	public static void staircase2(int n) {
		String str = "#";
		for (int i = 0; i < n; i++) {
			System.out.printf("%"+n+"s\n", str);
			str += "#";
		}
	}
}
