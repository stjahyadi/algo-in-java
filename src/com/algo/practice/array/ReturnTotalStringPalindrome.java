package com.algo.practice.array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ReturnTotalStringPalindrome {
	public static void main(String[] args) {
		List<String> strs = new ArrayList<String>(Arrays.asList("Taco", "cat", "Borrow", "or", "rob", "!Abv", "ocaT"));
		System.out.println(solution(strs));
		System.out.println(fasterSolution(strs));
	}

	public static int solution(List<String> strs) {
		int counter = 0;
		for (int i = 0; i < strs.size(); i++) {
			for (int j = 0; j < strs.size(); j++) {
				if (i == j)
					continue;

				String str = strs.get(i) + strs.get(j);
				String reverse = reverse(str);
				if (str.equalsIgnoreCase(reverse)) {
					int tmp = i + j;
					System.out.println(str + "==" + reverse);
					counter += tmp;
				}
			}
		}
		return counter;
	}
	
	public static int fasterSolution(List<String> strs) {
		Set<String> set = new HashSet<String>();
		int counter = 0;
		for (int i = 0; i < strs.size(); i++) {
			StringBuilder str = new StringBuilder(strs.get(i));
			if(set.contains(str.reverse().toString())) {
				counter += i;
			}
			set.add(strs.get(i));
		}
		return counter;
	}

	public static String reverse(String str) {
		StringBuilder reverse = new StringBuilder(str);
		int length = reverse.length();
		for (int i = 0; i < length / 2; i++) {
			char c = str.charAt(i);
			int otherEnd = length - i - 1;
			reverse.setCharAt(i, str.charAt(otherEnd));
			reverse.setCharAt(otherEnd, c);
		}
		return reverse.toString();
	}
}
