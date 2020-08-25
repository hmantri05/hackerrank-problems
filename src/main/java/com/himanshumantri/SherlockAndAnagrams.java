package com.himanshumantri;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class SherlockAndAnagrams {

	// Complete the sherlockAndAnagrams function below.
	static int sherlockAndAnagrams(String s) {
		int result = 0;
		int len = s.length();
		Map<String, Boolean> anagramResults = new HashMap<>();

		for (int l = 1; l <= len; l++) {
			for (int i = 0; i + l <= len; i++) {
				String substr = s.substring(i, i + l);
				for (int j = i + 1; j + l <= len; j++) {
					String substr2 = s.substring(j, j + l);
					boolean isAnagram = false;
					if (!anagramResults.containsKey(substr + "-" + substr2)) {
						isAnagram = areAnagrams(substr, substr2);
						anagramResults.put(substr + "-" + substr2, isAnagram);
					} else {
						isAnagram = anagramResults.get(substr + "-" + substr2);
						;
					}
					if (isAnagram) {
						result++;
					}
				}
			}
		}
		return result;
	}

	private static boolean areAnagrams(String s1, String s2) {
		int count[] = new int[26];
		
		if (s1.length() != s2.length()) {
			return false;
		}
		
		for (int i = 0; i < s1.length(); i++) {
			count[s1.charAt(i) - 'a']++;
		}

		for (int i = 0; i < s2.length(); i++) {
			count[s2.charAt(i) - 'a']--;
		}

		for (int i = 0; i < 26; i++) {
			if (count[i] != 0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) throws IOException {
		String s = "ifailuhkqq";

		int result = sherlockAndAnagrams(s);
		System.out.println(result);
	}
}
