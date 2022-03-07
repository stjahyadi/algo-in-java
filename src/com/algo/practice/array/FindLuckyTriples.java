package com.algo.practice.array;

public class FindLuckyTriples {
	public static void main(String[] args) {
		System.out.println(solution2(new int[] { 1, 2, 3, 4, 5, 6 })); // 3 [1, 2, 4], [1, 2, 6], [1, 3, 6]
		//System.out.println(solution2(new int[] { 3, 6, 5, 30, 18 })); // 2 [3, 6, 18], [3, 6, 30]
		//System.out.println(solution2(new int[] { 1, 1, 1 })); // 1
	}

	public static int solution(int[] arr) {
		// (x, y, z) where x divides y and y divides z
		// requirement i < j < k
		int count = 0;
		for (int x = 0; x < arr.length; x++) {
			for (int y = x + 1; y < arr.length; y++) {
				for (int z = y + 1; z < arr.length; z++) {
					if (arr[y] % arr[x] == 0 && arr[z] % arr[y] == 0) {
						count++;
						System.out.println(arr[x] + "," + arr[y] + "," + arr[z]);
					}

				}
			}
		}
		return count;

	}
	
	public static int solution2(int[] arr) {
		int count = 0;
		int[] c = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[i] % arr[j] == 0) {
					c[i] += 1;
					count += c[j];
				}
			}
		}
		return count;
	}
}
