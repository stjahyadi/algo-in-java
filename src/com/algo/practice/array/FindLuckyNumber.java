package com.algo.practice.array;
import java.util.HashMap;
import java.util.Map;

public class FindLuckyNumber {
	public static void main(String[] args) {
		int[] arr = { 1, 2, 2, 3, 3, 3 };
		System.out.println(findLucky(arr));
	}

	public static int findLucky(int[] arr) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i : arr) {
			map.put(i, map.getOrDefault(i, 0) + 1);
		}

		int lucky = -1;
		for (int i : map.keySet()) {
			if (i == map.get(i) && map.get(i) > lucky) {
				lucky = i;
			}
		}
		return lucky;
	}
}
