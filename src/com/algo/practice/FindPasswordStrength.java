package com.algo.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindPasswordStrength {
	public static void main(String[] args) {
		System.out.println(solution("test")); // 19
		System.out.println(solution("good")); // 16
		System.out.println(solution("abc")); // 10
			
	}

	public static long solution(String password) {
		//Still need to improve to be able to run below 4 seconds
		int start = 0, end = 1;
		int counter = 1;
		List<Integer> counts = new ArrayList<>();
		while (counter <= password.length()) {
			String s = password.substring(start, end);
			// System.out.println(s);
			
			Map<Character, Integer> map = new HashMap<>();
			for (int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);
				map.put(c, map.getOrDefault(c, 0) + 1);
			}
			counts.add(map.size());
			start++;
			end++;
			if (end > password.length()) {
				counter++;
				start = 0;
				end = counter;
			}
		}
		
		long sum = 0;
		for(Integer i : counts) {
			sum += i;
		}
		return sum;
	}

}
