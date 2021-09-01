package com.algo.practice;

public class ReviewCode {

	public static void main(String[] args) {
		//Initial input
		//int a[] = {-2, -1, 2, 1};
		int a[] = {-2, -1, 2, 1};
		System.out.println(solution(a));
	}
	
	public static int solution(int[] A) {
        int ans = 0;
        //for (int i = 1; i < A.length; i++) {
        for (int i = 0; i < A.length; i++) {
            if (ans > A[i]) {
                ans = A[i];
            }
        }
        return ans;
    }
}
