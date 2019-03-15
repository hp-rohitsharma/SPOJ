package com.spoj.impl;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Farida {

	public static void main(String[] args) throws IOException {
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		String line = stdin.readLine();
		int cases = Integer.parseInt(line);
		int counter = 0;
		while (cases > counter++) {
			int monsters = Integer.parseInt(stdin.readLine());
			if(monsters == 0) {
				String ignored = stdin.readLine();
				System.out.println("Case " + (counter) + ": 0");
				continue;
			}	
			long[] coins = toIntArray(stdin.readLine().split(" "));
			long[] memory = new long[coins.length];
			System.out.println("Case " + (counter) + ": " + dp(0, coins, memory));
		}
	}

	private static long dp(int i, long[] input, long[] memory) {

		if (input.length <= i) {
			return 0;
		}

		if (memory[i] != 0) {
			return memory[i];
		}

		memory[i] = Math.max(dp(i + 1, input, memory), dp(i + 2, input, memory) + input[i]);

		return memory[i];
	}

	private static long[] toIntArray(String[] chars) {

		long[] intArray = new long[chars.length];
		for (int i = 0; i < chars.length; i++) {
			intArray[i] = Long.parseLong(chars[i]);
		}
		return intArray;
	}

}
