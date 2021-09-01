package com.algo.practice;

public class ElectronicsShop {
	public static void main(String[] args) {
		int[] keyboards1 = { 3, 1 };
		int[] drives1 = { 5, 2, 8 };
		System.out.println(getMoneySpent(keyboards1, drives1, 10)); // 9

		int[] keyboards2 = { 4 };
		int[] drives2 = { 5 };
		System.out.println(getMoneySpent(keyboards2, drives2, 5)); // -1
	}

	public static int getMoneySpent(int[] keyboards, int[] drives, int b) {
		int i = 0, j = 0;
		int max = -1;
		while (i < keyboards.length || j < drives.length - 1) {
			int current = keyboards[i] + drives[j];
			if (current <= b && current >= max)
				max = current;

			if (j < drives.length - 1)
				j++;
			else {
				i++;
				if (i < keyboards.length)
					j = 0;
			}
		}
		return max;
	}

	public static int getMoneySpent1(int[] keyboards, int[] drives, int b) {
		int max = -1;
		for (int i = 0; i < keyboards.length; i++) {
			for (int j = 0; j < drives.length; j++) {
				int current = keyboards[i] + drives[j];
				if (current <= b && current >= max)
					max = current;
			}
		}
		return max;
	}
}
