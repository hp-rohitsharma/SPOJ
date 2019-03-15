package com.spoj.impl;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PrimePath {

	public static void main(String[] args) throws IOException {
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		String line = stdin.readLine();
		while ((line = stdin.readLine()) != null && line.length() != 0) {
			String[] splits = line.split(" ");
			String target = splits[1];
			int[] input = toIntArray(splits[0].toCharArray());

			System.out.println(dp(input[0], input[1], input[2], input[3], Integer.parseInt(target), 0));
		}
	}

	private static int[] toIntArray(char[] charArray) {

		int[] intArray = new int[charArray.length];
		for (int i = 0; i < charArray.length; i++) {
			intArray[i] = charArray[i] - '0';
		}
		return intArray;
	}

	private static int dp(int a, int b, int c, int d, int target, int pos) {

		System.out.println(a + " " + b + " " + c + " " + d);

		if (number(a, b, c, d) == target) {
			return 0;
		}

		int min = Integer.MAX_VALUE;

		for (int i = 0; i < 10; i++) {

			if (pos == 0) {
				a = i;
			} else if (pos == 1) {
				b = i;
			} else if (pos == 2) {
				c = i;
			} else if (pos == 3) {
				d = i;
			}

			if (isPrime(number(a, b, c, d))) {
				if(pos == 3) {
					min++;
				} else {
					int steps = dp(a, b, c, d, target, pos + 1) + 1;
					min = steps < min ? steps : min;
				}
			}
		}

		return min;
	}

	private static int number(int a, int b, int c, int d) {
		return a * 1000 + b * 100 + c * 10 + d;
	}

	private static boolean isPrime(int number) {
		for (int i = 2; i <= Math.ceil(Math.sqrt(number)); i++) {
			if (number % i == 0)
				return false;
		}
		return true;
	}

}
