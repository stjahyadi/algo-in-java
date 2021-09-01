package com.algo.practice.array;
import java.util.Arrays;
import java.util.List;

public class MinMaxSum {
	public static void main(String[] args) {
		miniMaxSum(Arrays.asList(new Integer[] { 1, 2, 3, 4, 5 })); //Expected: 10 14
		//miniMaxSum(Arrays.asList(new Integer[] { 7, 69, 2, 221, 8974 })); //Expected: 299 9271
	}

	public static void miniMaxSum(List<Integer> arr) {
		int n = arr.size();
		long min = arr.get(0);
		long max = arr.get(0);
		long sum = 0;
		for (int i = 0; i < n; i++) {
			sum += arr.get(i);
			min = Math.min(min, arr.get(i));
			max = Math.max(max, arr.get(i));
//			if (arr.get(i) < min)
//				min = arr.get(i);
//			if (arr.get(i) > max)
//				max = arr.get(i);
		}
		System.out.println((sum - max) + " " + (sum - min));

//		Collections.sort(arr);
//		for (int i = 0, j = n - 1; i < n - 1; i++, j--) {
//			min += arr.get(i);
//			max += arr.get(j);
//		}
//		System.out.println(min + " " + max);

	}
}
