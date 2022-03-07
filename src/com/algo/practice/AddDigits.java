package com.algo.practive;

/*https://leetcode.com/problems/add-digits*/
public class AddDigits {
	public static void main(String[] args) {
		System.out.println(solution2(38));
		System.out.println(solution(0));
	}

	public static int solution(int num) {
		String numStr = String.valueOf(num);
		int result = 0;
		while (numStr.length() > 1) {
			for (int i = 0; i < numStr.length(); i++) {
				result += Character.getNumericValue(numStr.charAt(i));
			}
			numStr = String.valueOf(result);
			result = 0;
		}
		return Integer.valueOf(numStr);
	}

	public static int solution2(int num) {
		if (num / 10 < 1)
			return num;

		int result = 0;
		while (num / 10 >= 1) {
			result += num % 10;
			num = num / 10;
		}
		result += num;
		return solution2(result);
	}
}
