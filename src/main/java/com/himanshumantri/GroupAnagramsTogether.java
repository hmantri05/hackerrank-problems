package com.himanshumantri;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GroupAnagramsTogether {
	
    public static List<List<String>> groupAnagrams(String[] strs) {
    	List<List<String>> result = new ArrayList<>();
    	Map<String, List<String>> anagramMap = new HashMap<>(); 
        for (String str : strs) {
        	char[] arr = str.toCharArray();
        	Arrays.sort(arr);
        	String newStr = new String(arr);
        	if (!anagramMap.containsKey(newStr)) {
        		anagramMap.put(newStr, new ArrayList<>());
        	}
        	anagramMap.get(newStr).add(str);
        }
        
        for (String key : anagramMap.keySet()) {
        	result.add(new ArrayList(anagramMap.get(key)));
        }
        
        return result;
    }

	public static void main(String[] args) {
		String[] strs = {"", ""};
		
		
		System.out.println(groupAnagrams(strs));

	}

}
