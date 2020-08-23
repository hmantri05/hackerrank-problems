package com.himanshumantri;

import java.io.IOException;

public class BeautifulBinaryString {

    // Complete the beautifulBinaryString function below.
    static int beautifulBinaryString(String b) {
        int len = b.length();
        String str = "010";
        int result = 0;
        
        int win_start = 0;
        int win_end = win_start + str.length() - 1;
        
        while (win_end < len) {
        	if (match(b, win_start, win_end, str)) {
        		win_start = win_end + 1;
        		win_end = win_start + str.length() - 1;
        		result++;
        	} else {
        		win_start++;
        		win_end = win_start + str.length() - 1;
        	}
        }
        return result;
    }


    private static boolean match(String b, int win_start, int win_end, String str) {
		int strLen = str.length();
		int i = 0;
		while (i < strLen && b.charAt(win_start) == str.charAt(i)) {
			i++;
			win_start++;
		}
		return (i == strLen);
	}


	public static void main(String[] args) throws IOException {

        int n = 100;

        String b = "0100101010100010110100100110110100011100111110101001011001110111110000101011011111011001111100011101";
//        String b = "0010";

        int result = beautifulBinaryString(b);
        System.out.println(result);
    }
}

