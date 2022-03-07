package com.algo.practice;

import java.util.HashMap;
import java.util.Map;

public class ReturnUniqueIntBetweenArrays {
	public static void main(String[] args) {
		int[] x = { 13, 5, 6, 2, 5 };
		int[] y = { 5, 2, 5, 13 };
		System.out.println(solution(x, y));
	}

	public static int solution(int[] x, int[] y) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int x1 : x) {
			map.put(x1, map.getOrDefault(x1, 0) + 1);
		}

		for (int y1 : y) {
			map.put(y1, map.getOrDefault(y1, 0) + 1);
		}

		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if (entry.getValue() == 1)
				return entry.getKey();
		}
		return -1;

	}

}
