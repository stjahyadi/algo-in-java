package com.algo.practice;

import java.util.HashMap;
import java.util.Map;


/*
 * Shark (A) eats Salmon (B) and Herring (C)
 * Salmon (B) eats Herring (C) and Sardine (D)
 * Herring (C) eats Sardine (D)
 * Sardine (D) is too small and eats no other fish
 
 Returns an integer that gives the number of fishes surviving, after all fishes have eaten their neighbors, that they are able to eat.
 This function has to be applied, until there are no neighbors available any longer, that could be eaten. Also the function
 should find the smallest number of surviving fishes, if there are several possible sequences of eating the neighbors.
 
 Assume that
 * Length of String is in range of [0.. 1.000.000]
 * Every character in String S is out of the list: 'A', 'B', 'C' and 'D'
 * 
 * For example:
 * 
 * Given a String "ABAD" the result will be 3, because the sharks will eat the Salmon and the rest will survive
 * 
 * Given a String "ACCD" the result will be 1, because the Herring will eat the Sardine and the Shark will finally eat the Herrings.
 */
public class ReturnFishesSurvive {
	public static void main(String[] args) {
		System.out.println(solution("ABAD")); // 3
		System.out.println(solution("ACCD")); // 1
	}

	public static int solution(String S) {
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < S.length(); i++) {
			map.put(S.charAt(i), map.getOrDefault(S.charAt(i), 0) + 1);
		}

		int n = S.length();
		for (int i = n - 1; i >= 0; i--) {
			char c = S.charAt(i);
			if (c == 'A' && map.getOrDefault('A', 0) != 0) {
				if (map.getOrDefault('B', 0) != 0) {
					n -= map.get('B');
					map.replace('B', 0);
				} else if (map.getOrDefault('C', 0) != 0) {
					n -= map.get('C');
					map.replace('C', 0);
				}
			} else if (c == 'B' && map.getOrDefault('B', 0) != 0) {
				if (map.getOrDefault('C', 0) != 0) {
					n -= map.get('C');
					map.replace('C', 0);
				} else if (map.getOrDefault('D', 0) != 0) {
					n -= map.get('D');
					map.replace('D', 0);
				}
			} else if (c == 'C' && map.getOrDefault('C', 0) != 0) {
				if (map.getOrDefault('D', 0) != 0) {
					n -= map.get('D');
					map.replace('D', 0);
				}
			}
		}
		return n;
	}
}
