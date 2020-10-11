package com.himanshumantri;

public class PermutationsOfLengthN {

	/*
	 * Given a number with all distinct digits.
	 * Print all the numbers of n digits that can be formed of 
	 * from the digits of the given number.
	 */
	
	public static void main(String[] args) {
		int num = 1234;
		int n = 3;
		char arr[] = String.valueOf(num).toCharArray();

		permute(arr, n);

	}

	private static void permute(char[] arr, int n) {
		
		permuteUtil("", arr, 0, arr.length - 1, n);

	}

	private static void permuteUtil(String str, char[] arr, int start, int end, int n) {
		if (str.length() == n)
			System.out.println(str);
		for (int j = start; j <= end; j++) {
			permuteUtil(str + arr[j], arr, start + 1, end, n);
		}
		
	}
}
