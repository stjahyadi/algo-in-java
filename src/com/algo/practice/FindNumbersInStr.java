package com.algo.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindNumbersInStr {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution("qwe2ret4")));
	}

	public static Integer[] solution(String s) {
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (Character.isDigit(c)) {
				list.add(Integer.parseInt("" + c));
			}
		}
		Integer[] result = new Integer[list.size()];
		list.toArray(result);
		return result;
	}
}
