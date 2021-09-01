package com.algo.practice.array;

public class ShuffleArray {
	public static void main(String[] args) {
		int[]nums = {2,5,1,3,4,7}; //Expected: [2,3,5,4,1,7] 
		int n = 3;
		print(shuffle(nums, n));
	}
	
	public static void print(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i]);
			if (i < nums.length - 1)
				System.out.print(",");
		}
	}
	
	public static int[] shuffle(int[] nums, int n) {
		int x = 0;
		int y = n;
        int[] output = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            if(i % 2 == 0)
                output[i] = nums[x++];
            else
                output[i] = nums[y++];
        }   
        return output;
    }
}
