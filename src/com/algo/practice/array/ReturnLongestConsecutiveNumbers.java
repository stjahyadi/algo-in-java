package com.algo.practice.array;


public class ReturnLongestConsecutiveNumbers {
	public static void main(String[] args) {
		//System.out.println(solution(new int[] { 1, 2, 3, 5, 6, 7, 8, 9 })); // 5
		//System.out.println(solution(new int[] { 1, 2, 3, 10, 11, 15 })); // 3
		//System.out.println(solution(new int[] { 5, 4, 2, 1 })); // 2
		//System.out.println(solution(new int[] { 3, 5, 7, 10, 15 })); // 1
		//System.out.println(solution(new int[] { 5, -3, -2, -1, 0, 1 })); // 5
		System.out.println(solution(new int[] { 3, 4, 5, -2, -1, 0, 1, 6, 7 })); // 4
		//System.out.println(solution(new int[] { 2, 3, 12, 11, 10, 9 })); // 4
		//System.out.println(solution(new int[] { 4, 5, 6, -4, -3 - 2, -1, 0, 2, 3 })); // 5
		System.out.println(solution(new int[] { 1, 3, 4 - 7, -8, -9, -10, -11, 12, 11 })); // 5

	}

	public static int solution(int[] A) {
		int counter = 0;
		for (int i : A) {
			int num = i;
			int currCounter = 1;
			while (arrayCheck(A, num + 1)) {
				num += 1;
				currCounter += 1;
			}
			counter = Math.max(counter, currCounter);
		}
		return counter;
	}

	public static boolean arrayCheck(int[] A, int num) {
		for (int i : A) {
			if (i == num)
				return true;
		}

		return false;
	}

}
