package com.algo.practice;

import java.util.ArrayList;
import java.util.List;

public class ReturnBigSmallBurger {
	/*
	 * Given tomatoes and cheeses slices returns a tuple/list of the number of big burgers and mini burgers,
	 * can be prepared. All ingredients must be used up. 
	 * In case there are any remainders ingredients, output an array with values[-1,-1]
	 * In case there is one big burger and no mini burger, output for example [1,0]
	 * 
	 * A big burger contains 4 tomatoes and 1 slice of cheese
	 * A mini burger contains 2 tomatoes and 1 slice of cheese
	 * 
	 * 
	 * Example
	 * Cheese(X): 1
	 * Tomatoes(Y): 2
	 * Output: (1,0) -> 1 mini burger and 0 big burger
	 * 
	 * Cheese(X): 7
	 * Tomatoes(Y): 16
	 * Output: (6,1) -> 6 mini burgers and 1 big burger
	 * 
	 * Cheese(X): 15
	 * Tomatoes(Y): 40
	 * Output: (10,5) -> 10 mini burgers and 5 big burgers
	 */
	public static void main(String[] args) {
		int[] output = solution(1, 2);
		System.out.println(output[0] + "," + output[1]);
		
		int[] output2 = solution(7, 16);
		System.out.println(output2[0] + "," + output2[1]);
		
		int[] output3 = solution(15, 40);
		System.out.println(output3[0] + "," + output3[1]);
	}

	public static int[] solution(int cheeseSlices, int tomatoSlices) {
		/*
		 * Observation:
		 * Tomatoes always even number
		 * Cheese should be lesser than tomatoes
		 * 
		 * j = jumbo burger
		 * s = small burger
		 * t = tomato
		 * c = cheese
		 * 
		 * 1) 4j + 2s = t
		 * 2)  j + s  = c
		 *         s  = c - j
 		 * 3) 4j + 2(c - j) = t
 		 *    4j + 2c - 2j  = t
 		 *    2j + 2c = t
 		 *          j = (t - 2c) / 2
		 */
		int s = -1;
		int j = -1;
		if (tomatoSlices % 2 == 1 || cheeseSlices > tomatoSlices)
			return new int[] { -1, -1 };

		j = (tomatoSlices - (2 * cheeseSlices)) / 2;
		s = cheeseSlices - j;
		
		if(j < 0 || s < 0)
			return new int[] { -1, -1 };
		
		
		return new int[] { s, j };
	}
	
	public static List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
		if (tomatoSlices % 2 == 1 || cheeseSlices > tomatoSlices)
			return new ArrayList<Integer>();

		List<Integer> result = new ArrayList<Integer>();
		int s = 0;
		int j = 0;
		j = (tomatoSlices - (2 * cheeseSlices)) / 2;
		s = cheeseSlices - j;

		if (j < 0 || s < 0)
			return new ArrayList<Integer>();

		result.add(j);
		result.add(s);
		return result;
	}
}
