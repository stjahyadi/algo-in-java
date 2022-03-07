package com.algo.practice.array;

public class MedianTwoSortedArray {
	public static void main(String[] args) {
		int[] nums1 = { 1, 3 };
		int[] nums2 = { 2 };
		System.out.println(solution(nums1, nums2)); // 2.0000

		int[] nums3 = { 1, 2 };
		int[] nums4 = { 3, 4 };
		System.out.println(solution(nums3, nums4)); // 2.5000

		int[] nums5 = { 0, 0 };
		int[] nums6 = { 0, 0 };
		System.out.println(solution(nums5, nums6)); // 0.0000

		int[] nums7 = {};
		int[] nums8 = { 1 };
		System.out.println(solution(nums7, nums8)); // 1.0000

		int[] nums9 = { 2 };
		int[] nums10 = { };
		System.out.println(solution(nums9, nums10)); // 2.0000
	}
	
	public static double solution(int[] nums1, int[] nums2) {
		// Time Complexity O(n + m)
		int i = 0, j = 0;
		int n1 = nums1.length;
		int n2 = nums2.length;
		int[] result = new int[n1 + n2];
		int index = 0;
		while (i < n1 && j < n2) {
			if (nums1[i] < nums2[j]) {
				result[index++] = nums1[i];
				i++;
			} else {
				result[index++] = nums2[j];
				j++;
			}
		}

		while (i < n1) {
			result[index++] = nums1[i];
			i++;
		}

		while (j < n2) {
			result[index++] = nums2[j];
			j++;
		}

		int position = (n1 + n2) / 2;
		if ((n1 + n2) % 2 == 1)
			return (result[position]);
		else
			return (result[position-1] + result[position]) / 2.0;
	}

	public static void print(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i]);
			if (i < nums.length - 1)
				System.out.print(",");
		}
		System.out.println();
	}
	
	public double findMedianSortedArrays(int input1[], int input2[]) {
		//https://www.youtube.com/watch?v=LPFhl65R7ww
        //if input1 length is greater than switch them so that input1 is smaller than input2.
        if (input1.length > input2.length) {
            return findMedianSortedArrays(input2, input1);
        }
        int x = input1.length;
        int y = input2.length;

        int low = 0;
        int high = x;
        while (low <= high) {
            int partitionX = (low + high)/2;
            int partitionY = (x + y + 1)/2 - partitionX;

            //if partitionX is 0 it means nothing is there on left side. Use -INF for maxLeftX
            //if partitionX is length of input then there is nothing on right side. Use +INF for minRightX
            int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : input1[partitionX - 1];
            int minRightX = (partitionX == x) ? Integer.MAX_VALUE : input1[partitionX];

            int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : input2[partitionY - 1];
            int minRightY = (partitionY == y) ? Integer.MAX_VALUE : input2[partitionY];

            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
                //We have partitioned array at correct place
                // Now get max of left elements and min of right elements to get the median in case of even length combined array size
                // or get max of left for odd length combined array size.
                if ((x + y) % 2 == 0) {
                    return ((double)Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY))/2;
                } else {
                    return (double)Math.max(maxLeftX, maxLeftY);
                }
            } else if (maxLeftX > minRightY) { //we are too far on right side for partitionX. Go on left side.
                high = partitionX - 1;
            } else { //we are too far on left side for partitionX. Go on right side.
                low = partitionX + 1;
            }
        }

        //Only we we can come here is if input arrays were not sorted. Throw in that scenario.
        throw new IllegalArgumentException();
    }
}
