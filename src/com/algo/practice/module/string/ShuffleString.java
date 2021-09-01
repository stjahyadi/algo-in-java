package com.algo.practice.module.string;
import java.util.Map;
import java.util.TreeMap;

public class ShuffleString {
	public static void main(String[] args) {
		String s = "codeleet";
		int[] indices = { 4, 5, 6, 7, 0, 2, 1, 3 };
		System.out.println(restoreString(s, indices));
	}

	public static String restoreString(String s, int[] indices) {
		/*
		StringBuilder output = new StringBuilder();
        Map<Integer, String> map = new TreeMap<Integer, String>();
        for(int i = 0; i < indices.length; i++){
            map.put(indices[i], ""+s.charAt(i));
        }
        
        for(int i : map.keySet()){
            output.append(map.get(i));
        }
        
        return output.toString();
        */
		
		char[] tmp = new char[indices.length];
		for (int i = 0; i < indices.length; i++) {
			tmp[indices[i]] = s.charAt(i);
		}
		return new String(tmp);
	}
}
