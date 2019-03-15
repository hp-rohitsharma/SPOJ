package com.spoj.impl;
public class PrimeGenerator {

	static int start = 1000000000;
	static int end = 1000100000;

	static char newLine = '\n';
	static StringBuilder output = new StringBuilder();

	public static void main(String[] args) {

		for (int i = start; i <= end; i++) {
			if (isPrime(i)) {
				output.append(i).append(newLine);
			}
		}
		
		System.out.println(output.toString());

	}

	private static boolean isPrime(int i) {

		for (int j = 2; j < Math.sqrt(i); j++) {
			if (i % j == 0) {
				return false;
			}
		}
		return true;
	}

}
