package com.algo.practice.module.string;

public class ReverseStringIII {
	public static void main(String[] args) {
		System.out.println(reverse2("Let's take LeetCode contest")); // s'teL ekat edoCteeL tsetnoc
		System.out.println(reverse2("God Ding")); // doG gniD
	}

	public static String reverse(String word) {
		StringBuilder sb = new StringBuilder();
		for (String w : word.split(" ")) {
			StringBuilder tmp = new StringBuilder();
			for (int i = w.length() - 1; i >= 0; i--) {
				char c = w.charAt(i);
				tmp.append(c);
			}
			sb.append(tmp.toString()).append(" ");
		}
		return sb.toString().trim();
	}

	public static String reverse2(String word) {
		int n = word.length();

		int firstIdx, lastIdx;
		char[] c = word.toCharArray();

		for (int i = 0; i < n; i++) {
			firstIdx = i;
			while (i < n && c[i] != ' ') {
				i++;
			}
			lastIdx = i - 1;
			while (firstIdx < lastIdx) {
				char tmp = c[firstIdx];
				c[firstIdx] = c[lastIdx];
				c[lastIdx] = tmp;
				firstIdx++;
				lastIdx--;
			}
		}
		return new String(c);
	}
}
