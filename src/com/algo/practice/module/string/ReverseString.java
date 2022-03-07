package com.algo.practice.module.string;

import java.util.Stack;

public class ReverseString {
	public static void main(String[] args) {
		//System.out.println(reverse2("Hello World"));
		//System.out.println(reverse2("the sky is blue")); // blue is sky the
		System.out.println(reverse2("  hello world  ")); // world hello
		System.out.println(reverse2("a good   example")); // example good a
	}

	public static String reverse(String word) {
		Stack<String> stack = new Stack<>();
		StringBuilder str = new StringBuilder();
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if (c != ' ')
				str.append(c);

			if (c == ' ' || i == word.length() - 1) {
				if (!str.toString().isEmpty()) {
					stack.add(str.toString());
					str = new StringBuilder();
				}
			}

		}
		StringBuilder result = new StringBuilder();
		while (!stack.isEmpty()) {
			result.append(stack.pop()).append(" ");
		}
		return result.toString().trim();
	}
	
	public static String reverse2(String word) {
		Stack<String> stack = new Stack<>();
		for(String tmp : word.split(" ")) {
			if(!tmp.isEmpty())
				stack.push(tmp);
		}
		
		StringBuilder sb = new StringBuilder();
		while(!stack.isEmpty()) {
			sb.append(stack.pop());
			sb.append(" ");
		}
		return sb.toString().trim();
	}

}
