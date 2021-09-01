package com.algo.practice.array;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

public class RelativeSortArray {
	public static void main(String[] args) {
		int[] arr1 = { 2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19 };
		int[] arr2 = { 2, 1, 4, 3, 9, 6 };
		int[] output = relativeSortArray2(arr1, arr2);
		for (int i = 0; i < output.length; i++) {
			System.out.print(output[i]);
			if (i < output.length - 1)
				System.out.print(", ");
		}
	}

	public static int[] relativeSortArray2(int[] arr1, int[] arr2) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i : arr1)
			map.put(i, map.getOrDefault(i, 0) + 1);

		int index = 0;
		for (int i : arr2) {
			for (int j = 0; j < map.get(i); j++) {
				arr1[index++] = i;
			}
			map.remove(i);
		}

		SortedSet<Integer> keySet = new TreeSet<>(map.keySet());
		for (int i : keySet) {
			for (int j = 0; j < map.get(i); j++) {
				arr1[index++] = i;
			}
		}
		return arr1;
	}

	public static int[] relativeSortArray(int[] arr1, int[] arr2) {
		int[] cnt = new int[1001]; // Reverse 1001 spaces
		for (int n : arr1) {
			cnt[n]++; // Count++ based on index
		}
		int i = 0;
		for (int n : arr2) {
			while (cnt[n]-- > 0) { // Loop until the count become 0 for specific index
				arr1[i++] = n; // Override arr1 with the n value as many as the count
			}
		}
		for (int n = 0; n < cnt.length; n++) { // Loop the leftover
			while (cnt[n]-- > 0) { // Loop until the count become 0 for unavailable values arr1 inside arr2
				arr1[i++] = n; // Override arr1 with index value as many as the count
			}
		}
		return arr1;
	}
}
