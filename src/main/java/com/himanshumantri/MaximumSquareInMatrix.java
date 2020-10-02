package com.himanshumantri;

class MaximunSquareInMatrix {
    public static int maximalSquare(char[][] matrix) {
        int[][] dp =  new int[matrix.length][matrix[0].length];   
        
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
            	if (i == 0 || j == 0) {
            		dp[i][j] = matrix[i][j] - '0';
            	} else if (matrix[i][j] == '1') {
                    dp[i][j] = Math.min(dp[i-1][j], Math.min(dp[i-1][j-1], dp[i][j-1])) + 1;                     
                } else {
                    dp[i][j] = 0;
                }                
            	max = Math.max(max, dp[i][j]);
            }
        }
        
        return max * max;
    }
    
    static void printDP(int[][] dp, int m, int n){
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
    	char matrix[][] = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};

    	System.out.println(maximalSquare(matrix));
	}
}
