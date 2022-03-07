package com.algo.practice;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class VersionComparator implements Comparator<String> {

	@Override
	public int compare(String v1, String v2) {
		String[] arr1 = v1.split("\\.");
		String[] arr2 = v2.split("\\.");

		int a1 = arr1.length, a2 = arr2.length;
		int i = 0, j = 0;
		while (i < a1 && j < a2) {
			if (Integer.parseInt(arr1[i]) == Integer.parseInt(arr2[j])) {
				i++;
				j++;
			} else if (Integer.parseInt(arr1[i]) > Integer.parseInt(arr2[j])) {
				return 1;
			} else {
				return -1;
			}
		}

		if (i == a1 && j == a2)
			return 0;
		if (i == a1)
			return -1;
		return 1;

	}

}

public class SortVersion {
	public static void main(String[] args) {
		String[] l = { "1.1.2", "1.0", "1.3.3", "1.0.12", "1.0.2" };
		//print(solution(l)); // ["1.0", "1.0.2", "1.0.12", "1.1.2", "1.3.3"]

		String[] l2 = { "1.11", "2.0.0", "1.2", "2", "0.1", "1.2.1", "1.1.1", "2.0" };
		//print(solution(l2)); // 0.1, 1.1.1, 1.2, 1.2.1, 1.11, 2, 2.0, 2.0.0

		String[] l3 = { "2.0.0", "2", "0.1", "2.0" };
		print(solution(l3)); // 0.1, 1.1.1, 1.2, 1.2.1, 1.11, 2, 2.0, 2.0.0
	}

	public static String[] solution(String[] l) {
		// Your code here
		List<String> str = Arrays.asList(l);
		VersionComparator c = new VersionComparator();
		Collections.sort(str, c);
		return str.stream().toArray(String[]::new);
	}

	public static void print(String[] l) {
		for (int i = 0; i < l.length; i++) {
			System.out.print(l[i]);
			if (i < l.length - 1)
				System.out.print(", ");
		}
		System.out.println();
	}
}
