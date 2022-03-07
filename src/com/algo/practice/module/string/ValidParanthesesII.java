package com.algo.practice.module.string;
import java.util.Stack;

public class ValidParanthesesII {
	public static void main(String[] args) {
//		System.out.println(isValid2("()")); //true
//		System.out.println(isValid2("()[]{}")); //true
//		System.out.println(isValid2("(]")); //false
//		System.out.println(isValid2("{[]}")); //true
		
		System.out.println(isValid("(({}))")); // true
		System.out.println(isValid("({())}")); // true
		System.out.println(isValid("()}{")); // false
		System.out.println(isValid("({}))(")); // false
		System.out.println(isValid("())")); // false
	}
	
	public static boolean isValid2(String s) {
		Stack<Character> stack = new Stack<>();
		for(int i=0;i<s.length();i++) {
			switch(s.charAt(i)) {
			case '{': stack.push('{'); break;
			case '(': stack.push('('); break;
			case '[': stack.push('['); break;
			case '}': 
				if(!stack.isEmpty() && stack.peek() == '{') {
					stack.pop();
				}
				break;
			case ')':
				if(!stack.isEmpty() && stack.peek() == '(') {
					stack.pop();
				}
				break;
			case ']':
				if(!stack.isEmpty() && stack.peek() == '[') {
					stack.pop();
				}
				break;
			}
		}
		return stack.isEmpty();
	}

	public static boolean isValid(String s) {
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			switch (s.charAt(i)) {
			case '{':
				stack.push('{');
				break;
			case '[':
				stack.push('[');
				break;
			case '(':
				stack.push('(');
				break;
			case ']':
				if (!stack.isEmpty() && stack.peek() == '[')
					stack.pop();
				else if (!stack.isEmpty())
					stack.remove(stack.indexOf('['));
				else
					stack.push(']');
				break;
			case '}':
				if (!stack.isEmpty() && stack.peek() == '{')
					stack.pop();
				else if (!stack.isEmpty())
					stack.remove(stack.indexOf('{'));
				else
					stack.push('}');
				break;
			case ')':
				if (!stack.isEmpty() && stack.peek() == '(')
					stack.pop();
				else if (!stack.isEmpty())
					stack.remove(stack.indexOf('('));
				else
					stack.push(')');
				break;
			}
		}
		return stack.isEmpty();
	}

}
