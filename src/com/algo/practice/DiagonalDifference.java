package com.algo.practice;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DiagonalDifference {
	public static void main(String[] args) {
		List<List<Integer>> arr = new ArrayList<>();
		arr.add(Arrays.asList(new Integer[] { 1, 2, 3 }));
		arr.add(Arrays.asList(new Integer[] { 4, 5, 6 }));
		arr.add(Arrays.asList(new Integer[] { 9, 8, 9 }));
		System.out.println(diagonalDifference(arr)); // 15 - 17 = 2
		
		arr.clear();
		arr.add(Arrays.asList(new Integer[] { -1, 1, -7, -8 }));
		arr.add(Arrays.asList(new Integer[] { -10, -8, -5, -2 }));
		arr.add(Arrays.asList(new Integer[] { 0, 9, 7, -1 }));
		arr.add(Arrays.asList(new Integer[] { 4, 4, -2, 1 }));
		System.out.println(diagonalDifference(arr)); //Expected 1
	}

	public static int diagonalDifference(List<List<Integer>> arr) {
		// Write your code here
		int leftSum = 0;
		int rightSum = 0;
		int n = arr.size();
		for (int i = 0; i < n; i++) {
			leftSum += arr.get(i).get(i);
			rightSum += arr.get(i).get(n - 1 - i);
		}
		return Math.abs(leftSum - rightSum);
	}
}
