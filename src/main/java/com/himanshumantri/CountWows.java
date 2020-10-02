package com.himanshumantri;

/**
 * 
 * Check how many times a pattern occurs as a subsequence in a given string
 * 
 * @author mantri
 *
 */
public class CountWows {

	static String pat = "wow";

	// wwow
	static int countWowsRec(String str, int pos, int l, int h) {
		int res = 0;

		if (pos >= pat.length()) {
			return 1;
		}

		if (l >= h) {
			return 0;
		}

		for (int i = l; i < h; i++) {
			if (str.charAt(i) == pat.charAt(pos)) {
				res += countWowsRec(str, pos + 1, i + 1, h);
			}
		}

		return res;
	}

	static int countWowsDP(String str, String pat) {
		int m = str.length();
		int n = pat.length();

		int dp[][] = new int[m + 1][n + 1];

		dp[0][0] = 1;
		
		// if pat is ""
		for (int i = 1; i <= m; i++) {
			dp[i][0] = 1;
		}

		for (int j = 1; j <= n; j++) {
			dp[0][j] = 0;
		}

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (str.charAt(i-1) == pat.charAt(j-1)) {
					dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}

		return dp[m][n];
	}

	public static void main(String[] args) {
		String str = "wwwow";

		System.out.println(countWowsRec(str, 0, 0, str.length()));
		System.out.println(countWowsDP(str, pat));
	}
}
