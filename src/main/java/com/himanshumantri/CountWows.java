package com.himanshumantri;


/**
 * 
 * Check how many times wow occurs as a subsequence in a given string
 * @author mantri
 *
 */
public class CountWows {
	
	static String pat = "wow";
	//wwow
	static int countWows(String str, int pos, int l, int h) {
		int res = 0;

		if (pos >= pat.length()) {
			return 1;
		}
		
		if (l >= h) {
			return 0;
		}
		
		for (int i = l; i < h; i++) {
			if (str.charAt(i) == pat.charAt(pos)) {
				res += countWows(str, pos+1, i+1, h);
			}
		}
		
		return res;
	}

	public static void main(String[] args) {
		String str = "wwwow";
		
		System.out.println(countWows(str, 0, 0, str.length()));
	}
}
