package com.himanshumantri;

import java.io.IOException;

public class MinimumSwaps {

    // Complete the minimumSwaps function below.
    static int minimumSwaps(int[] arr) {
    	int noOfSwaps = 0;
    	int temp = -1;
    	for (int i = 0; i < arr.length; i++) {
    		if (arr[i] == -1) {
    			continue;
    		} else {
    			int j = i;
    			int hops = 0;
    			while (arr[j] != -1) {
    				temp = arr[j];
    				arr[j] = -1;
    				j = temp - 1;
    				hops++;
    			}
    			noOfSwaps += (hops - 1);
    		}
    	}
    	
        return noOfSwaps;
    }

    public static void main(String[] args) throws IOException {

//        int n = 50;

        int[] arr = {8,45,35,84,79,12,74,92,81,82,61,32,36,1,65,44,89,40,28,20,97,90,22,87,48,26,56,18,49,71,23,34,59,54,14,16,19,76,83,95,31,30,69,7,9,60,66,25,52,5,37,27,63,80,24,42,3,50,6,11,64,10,96,47,38,57,2,88,100,4,78,85,21,29,75,94,43,77,33,86,98,68,73,72,13,91,70,41,17,15,67,93,62,39,53,51,55,58,99,46};

        int res = minimumSwaps(arr);
        System.out.println(res);
    }
}
