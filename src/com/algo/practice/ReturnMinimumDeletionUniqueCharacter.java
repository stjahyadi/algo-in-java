package com.algo.practice;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ReturnMinimumDeletionUniqueCharacter {
	public static void main(String[] args) {
		System.out.println(solution("aaaabbbb")); // 1
		System.out.println(solution("ccaaffddecee")); // 6
		System.out.println(solution("eeee")); // 0
		System.out.println(solution("example")); // 4
	}

	public static int solution(String S) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < S.length(); i++) {
			char c = S.charAt(i);
			map.put(c, map.getOrDefault(c, 0) + 1);
		}

		int delete = 0;
		if (map.size() > 1) {
			Integer[] counts = map.values().toArray(new Integer[0]);
			Arrays.sort(counts, Collections.reverseOrder());
			for (int i = 0; i < counts.length - 1; i++) {
				for (int j = i + 1; j < counts.length; j++) {
					if (counts[i] > 0 && counts[i] == counts[j]) {
						int count = counts[j];
						counts[j] = count - 1;
						delete++;
					} else
						break;
				}
			}
		}
		return delete;
	}

}
