package com.himanshumantri;

import java.util.Arrays;
import java.util.Scanner;

public class StrongPrimesInARange {

	public static void main(String[] args) {
		
		int N = 2000;
		boolean sieve[] = prepareSieve(N);
		
		Scanner s = new Scanner(System.in);
		int T = Integer.parseInt(s.nextLine());
		
		for (int t = 0; t < T; t++) {
			String line = s.nextLine();
			int l = Integer.parseInt(line.split(" ")[0]);
			int r = Integer.parseInt(line.split(" ")[1]);
			for (int i = l; i <= r; i++) {
				if (isStrongPrime(i, sieve)) {
					System.out.print(i + " ");
				}
			}
		}
		s.close();
		
	}

	private static boolean isStrongPrime(int i, boolean[] sieve) {
		if (sieve[i] == true) {
			int prevPrime = i - 1;
			int nextPrime = i + 1;
			for (int k = i - 1; k >= 0; k--) {
				if (sieve[k] == true) {
					prevPrime = k;
					break;
				}
			}
			for (int k = i + 1; k <= sieve.length; k++) {
				if (sieve[k] == true) {
					nextPrime = k;
					break;
				}
			}
			return (2*i > (prevPrime + nextPrime));
		}
		return false;
	}

	private static boolean[] prepareSieve(int n) {
		boolean sieve[] = new boolean[n + 1];
		Arrays.fill(sieve, true);
		
		for (int k = 2; k <= n; k++) {
			for (int j = k*k; j <= n; j += k) {
				sieve[j] = false;
			}
		}
		
		return sieve;
	}

}
