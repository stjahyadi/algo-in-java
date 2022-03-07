package com.algo.practice;

import java.util.Arrays;

public class FindLargestNumberDivBy3 {
	public static void main(String[] args) {
//		System.out.println(maxSumDivThree(new int[] { 3, 6, 5, 1, 8 })); // 18
//		System.out.println(maxSumDivThree(new int[] { 4 })); // Output: 0
//		System.out.println(maxSumDivThree(new int[] { 1, 2, 3, 4, 4 })); // Output: 12
		System.out.println(maxSumDivThree(new int[] { 2, 6, 2, 2, 7 })); // Output: 15
		
		System.out.println(solution(new int[] { 3, 6, 5, 1, 8 }));
		System.out.println(solution(new int[] { 4 })); // Output: 0
		System.out.println(solution(new int[] { 3, 4, 0, 1, 5 })); // Output: 5430
		System.out.println(solution(new int[] { 3, 1, 4, 1 })); // Output: 4311
		System.out.println(solution(new int[] { 3, 1, 4, 1, 5, 9 })); // Output: 94311
		System.out.println(solution(new int[] { 5, 5, 5, 7 })); // Output: 555
	}
	
	public static int maxSumDivThree(int[] arr) {
		int sum = 0;
		int oneRemainder = 20000;
		int twoRemainder = 20000;

		for (int num : arr) {
			sum += num;

			if (num % 3 == 1) {
				twoRemainder = Math.min(twoRemainder, oneRemainder + num); //Get the smallest of 2 elements of remainder 2
				oneRemainder = Math.min(oneRemainder, num); //Get the smallest of single digit of remainder 1
			}

			if (num % 3 == 2) {
				oneRemainder = Math.min(oneRemainder, twoRemainder + num); //Get the smallest of 2 elements of remainder 1
				twoRemainder = Math.min(twoRemainder, num); //Get the smallest of single digit of remainder 2

			}
		}

		if (sum % 3 == 0)
			return sum;

		if (sum % 3 == 1)
			return sum - oneRemainder;

		if (sum % 3 == 2)
			return sum - twoRemainder;

		return 0;
	}

	public static int solution(int[] arr) {
		// sort
		sort(arr);

		// sum all
		int sum = 0;
		int n = arr.length;
		StringBuilder b = new StringBuilder();
		for (int i = n - 1; i >= 0; i--) {
			sum += arr[i];
			b.append(arr[i]);
		}
		// Find remainder
		int remainder = sum % 3;
		if (remainder == 0) {
			// If sum is divisible by 3, no need to delete an element
			return Integer.parseInt(b.toString());
		} else if (remainder == 1) {
			// If remainder is '1', we have to delete either one element of remainder '1' or
			// two elements of remainder '2'
			int[] remove = { -1, -1 };
			for (int i = n - 1; i >= 0; i--) {
				if (arr[i] % 3 == 1)
					// If this remainder is 1
					return removeAndCalculate(arr, new int[] { i, -1 });
				else if (arr[i] % 3 == 2) {
					// If this is first occurrence of remainder 2
					if (remove[0] == -1)
						remove[0] = i;
					// If second occurrence
					else if (remove[1] == -1)
						remove[1] = i;
				}
				if (remove[0] != -1 && remove[1] != -1)
					return removeAndCalculate(arr, remove);
			}
		} else if (remainder == 2) {
			// If remainder is '2', we have to delete either one element of remainder '2' or
			// two elements of remainder '1'
			int[] remove = { -1, -1 };
			for (int i = n - 1; i >= 0; i--) {
				if (arr[i] % 3 == 2)
					// If this remainder is 2
					return removeAndCalculate(arr, new int[] { i, -1 });
				else if (arr[i] % 3 == 1) {
					// If this is first occurrence of remainder 1
					if (remove[0] == -1)
						remove[0] = i;
					// If second occurrence
					else if (remove[1] == -1)
						remove[1] = i;
				}
				if (remove[0] != -1 && remove[1] != -1)
					return removeAndCalculate(arr, remove);

			}
		}
		return 0;
	}

	public static int removeAndCalculate(int[] arr, int[] remove) {
		StringBuilder str = new StringBuilder();
		for (int i = arr.length - 1; i >= 0; i--) {
			if (i != remove[0] && i != remove[1]) {
				str.append(arr[i]);
			}
		}
		if (!str.toString().isEmpty()) {
			return Integer.parseInt(str.toString());
		}
		return 0;
	}
	
	public static void sort(int[] l) {
		Arrays.sort(l);
		// Sorting descending
//		for (int i = 0; i < l.length / 2; i++) {
//			int temp = l[i];
//			l[i] = l[l.length - i - 1];
//			l[l.length - i - 1] = temp;
//		}
	}
}
