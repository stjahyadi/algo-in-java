package com.algo.practice;

public class LengthOfLastWord {
	public static void main(String[] args) {
		System.out.println(lengthOfLastWord("Hello World"));
	}

	public static int lengthOfLastWord(String s) {
		return s.substring(s.indexOf(" "), s.length()).length() - 1;
	}
}
