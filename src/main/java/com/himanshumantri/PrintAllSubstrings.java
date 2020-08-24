package com.himanshumantri;

public class PrintAllSubstrings {

	public static void main(String[] args) {
		String str = "abc";
		
		printAllSubstrings(str);
	}

	private static void printAllSubstrings(String str) {
		int len = str.length();
		
		for (int l = 1; l <=len; l++) {
			for (int i = 0; i + l <= len; i++) {
				System.out.println(str.substring(i, i + l));
			}
		}
	}
}
