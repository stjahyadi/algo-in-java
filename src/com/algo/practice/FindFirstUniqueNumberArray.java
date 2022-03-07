package com.algo.practice;

import java.util.HashMap;
import java.util.Map;

public class FindFirstUniqueNumberArray {
	public static void main(String[] args) {
		System.out.println(solution(new int[] { 4, 10, 5, 4, 2, 10 })); // 5
		System.out.println(solution(new int[] { 1, 4, 3, 3, 1, 2 })); // 4
		System.out.println(solution(new int[] { 6, 4, 4, 6 })); // -1
	}

	public static int solution(int[] A) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i : A) {
			map.put(i, map.getOrDefault(i, 0) + 1);
		}

		for (int i : A) {
			if (map.get(i) == 1)
				return i;
		}
		return -1;
	}
}
