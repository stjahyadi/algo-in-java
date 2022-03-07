package com.algo.practice;

import java.util.HashMap;
import java.util.Map;

public class MakingFileNameUnique {
	public static void main(String[] args) {
		String[] str = {"pes","fifa","gta","pes(2019)"};
		//Expected: "pes","fifa","gta","pes(2019)"
		print(fileNaming(str)); 
		
		String[] str1 = { "onepiece","onepiece(1)","onepiece(2)","onepiece(3)","onepiece" };
		// Expected: "onepiece","onepiece(1)","onepiece(2)","onepiece(3)","onepiece(4)"
		print(fileNaming(str1));
		
		String[] str2 = {"wano","wano","wano","wano"};
		// Expected: "wano","wano(1)","wano(2)","wano(3)"
		print(fileNaming(str2));
		
		String[] str3 = {"gta","gta(1)","gta","avalon"}; 
		// Expected: "gta","gta(1)","gta(2)","avalon"
		print(fileNaming(str3));
		
		String[] str4 = {"kaido","kaido(1)","kaido","kaido(1)"};
		// Expected: "kaido","kaido(1)","kaido(2)","kaido(1)(1)"
		print(fileNaming(str4));
	}
	
	public static String[] fileNaming(String[] names) {
		Map<String, Integer> map = new HashMap<>();
		for (int i = 0; i < names.length; i++) {
			String current = names[i];
			while (map.containsKey(current)) {
				int count = map.get(names[i]);
				count += 1;
				map.put(names[i], count);
				current = names[i]+"("+count+")";
			}
			map.put(current, 0);
			names[i] = current;
		}
		return names;
	}

	public static void print(String[] names) {
		for (int i = 0; i < names.length; i++) {
			System.out.print(names[i]);
			if (i < names.length - 1)
				System.out.print(",");
		}
		System.out.println();
	}

}
