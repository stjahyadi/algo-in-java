package com.algo.practice.array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ClosestSumPair {
	public static void main(String[] args) {
		int[] a1 = { 7, 4, 1, 10 };
		int[] a2 = { 4, 5, 8, 7 };
		int aTarget = 13;
		print(closestSumPair(a1, a2, aTarget)); // should return {4, 8}, {7, 7}, {7, 5}, or {10, 4}
		System.out.println();

		int[] b1 = { -1, 3, 8, 2, 9, 5 };
		int[] b2 = { 4, 1, 2, 10, 5, 20 };
		int bTarget = 24;
		// print(closestSumPair(b1, b2, bTarget)); //should return {5, 20} or {3, 20}
		print(simplerVerson(b1, b2, bTarget));
		System.out.println();

		int[] c1 = { 6, 8, -1, -8, -3 };
		int[] c2 = { 4, -6, 2, 9, -3 };
		int cTarget = 3;
		// print(closestSumPair(c1, c2, cTarget)); //should return {-1, 4} or {6, -3}
		System.out.println();

		int[] d1 = { 19, 14, 6, 11, -16, 14, -16, -9, 16, 13 };
		int[] d2 = { 13, 9, -15, -2, -18, 16, 17, 2, -11, -7 };
		int dTarget = -15;
		// print(closestSumPair(d1, d2, dTarget)); // should return {-16, 2}, {-9, -7}
	}

	// a1 and a2 are the given arrays, and target is the target sum.
	// It should return an array of two numbers as the result,
	// one from each array.
	public static int[] closestSumPair(int[] a1, int[] a2, int target) {
		Arrays.sort(a1);
		Arrays.sort(a2);
		List<Integer> pairs = new ArrayList<>();
		int i = 0;
		int j = a2.length - 1;

		while (i < a1.length && j > 0) {
			int v1 = a1[j];
			int v2 = a2[i];
			int currentDiff = v1 + v2 - target;
			if (Math.abs(currentDiff) == 1 || currentDiff == 0) {
				pairs.add(v1);
				pairs.add(v2);
			}
			if (currentDiff < 0)
				i++;
			else
				j--;

		}
		int[] output = pairs.stream().mapToInt(Integer::intValue).toArray();
		return output;
	}

	public static int[] simplerVerson(int[] a1, int[] a2, int target) {
		Set<Integer> set = new HashSet<>();
		for (int i : a1) {
			set.add(i);
		}

		List<Integer> pairs = new ArrayList<>();
		for (int i : a2) {
			int find = target - i;
			if (set.contains(find)) {
				pairs.add(i);
				pairs.add(find);
			} else if (set.contains(find + 1)) {
				pairs.add(i);
				pairs.add(find + 1);
			} else if(set.contains(find - 1)) {
				pairs.add(i);
				pairs.add(find - 1);
			}
		}
		return pairs.stream().mapToInt(Integer::intValue).toArray();
	}

	public static void print(int[] output) {
		for (int i = 0; i < output.length; i++) {
			System.out.print(output[i]);
			if (i < output.length - 1)
				System.out.print(", ");
		}
	}
}
