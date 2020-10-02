package com.himanshumantri;

import java.util.Arrays;

public class ZigzagConversion {

	public static String convert(String s, int numRows) {
		if (numRows == 1) return s;
		
		StringBuffer sb = new StringBuffer();
		int len = s.length();
		for (int k = 1; k <= numRows; k++) {
			int i = k - 1;
			char dir = 'D';
			while (i < len) {
				int offset = 0;
				sb.append(s.charAt(i));

				if (k == 1) dir = 'D';
				if (k == numRows) dir = 'U';
				
				if (dir == 'D') {
					offset = (numRows - k) * 2;
					i += offset;
					dir = 'U';
				} else if (dir == 'U') {
					offset = (k - 1) * 2;
					i += offset;
					dir = 'D';
				}
			}
		}
		return sb.toString();
	}
	
	public static String convert2(String s, int numRows) {
		
		if (numRows == 1) {
			return s;
		}
		
		int len = s.length();
		String[] rows = new String[numRows];
		Arrays.fill(rows, "");
		
		int row = -1;
		int dir = 1;
		for (int i = 0; i < len; i++) {
			row = row + dir;
			rows[row] += s.charAt(i);
			
			if (row == 0) {
				dir = 1;
			}
			if (row == numRows - 1) {
				dir = -1;
			}
		}
		return String.join("", rows);
	}

	public static void main(String[] args) {
		System.out.println(convert("PAYPALISHIRING", 2));
		System.out.println(convert2("PAYPALISHIRING", 2));
	}
}
