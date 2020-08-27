package com.himanshumantri;

import java.io.IOException;

public class PalindromeIndex {

	static boolean isPalindrome(String s, int low, int high) {
		while (low < high) {
			if (s.charAt(low) != s.charAt(high))
				return false;
			low++;
			high--;
		}
		return true;
	}

	// Complete the palindromeIndex function below.
	static int palindromeIndex(String s) {
		int len = s.length();

		int i = 0;
		int j = len - 1;

		while (i < j) {
			if (s.charAt(i) == s.charAt(j)) {
				i++;
				j--;
				continue;
			} else if (i + 1 == j) {
				return i;
			} else if (isPalindrome(s, i + 1, j)) {
				return i;
			} else if (isPalindrome(s, i, j - 1)) {
				return j;
			}
			return -1;

		}
		return -1;

	}

	public static void main(String[] args) throws IOException {

		String s = "hgygsvlfcwnswtuhmyaljkqlqjjqlqkjlaymhutwsnwcwflvsgygh";
		int result = palindromeIndex(s);
		System.out.println(result);
	}
}
