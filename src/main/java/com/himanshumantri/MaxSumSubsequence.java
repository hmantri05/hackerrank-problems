package com.himanshumantri;

public class MaxSumSubsequence {

	/*
	 * Given an array, find out maximum sum of the subsequence 
	 * less than or equal to given target
	 * that can be obtained.
	 * 
	 */
	public static void main(String[] args) {

		int arr[] = {1,2,3,4,5,7,16};
		int target = 15;
		
		System.out.println(maxSumSeq(arr, target));
	}

	private static int maxSumSeq(int[] arr, int target) {
		
		//dp[i][j] = max sum less than equal to j
		//when upto starting i elements are considered 
		int dp[][] = new int[target + 1][arr.length + 1];
		
		for (int i = 0; i <= target; i++ ) {
			dp[i][0] = 0;
		}
		
		for (int j = 1; j <= arr.length; j++) {
			dp[0][j] = 0;
		}
		
		
		for (int i = 1; i <= target; i ++) {
			for (int j = 1; j <= arr.length; j++) {
				if (arr[j-1] <= i) {
					int sumInc = arr[j-1] + dp[i - arr[j-1]][j-1];
					int sumExc = dp[i][j-1];
					dp[i][j] = Math.max(sumInc, sumExc);
				} else {
					dp[i][j] = dp[i][j-1];
				}
			}
		}
//		printDP(dp);
		return dp[target][arr.length];
	}

	private static void printDP(int[][] dp) {
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++) {
				System.out.printf("%4d", dp[i][j]);
			}
			System.out.println();
		}
		
	}
	
	

}
