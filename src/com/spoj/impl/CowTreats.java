package com.spoj.impl;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CowTreats {

	public static void main(String[] args) throws IOException {

		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		String line = stdin.readLine();
		int[] input = new int[Integer.parseInt(line)];
		int index = 0;
		while ((line = stdin.readLine()) != null) {
			input[index++] = Integer.parseInt(line);
			if(index == input.length) {
				break;
			}
		}

		int[][] memory = new int[2001][2001];
		System.out.println(dp(0, input.length - 1, input, 1, memory));
	}

	private static int dp(int start, int end, int[] input, int day, int[][] memory) {

		if (memory[start][end] != 0) {
			return memory[start][end];
		}

		if (start == end) {
			return day * input[start];
		}

		memory[start][end] = Math.max(dp(start + 1, end, input, day + 1, memory) + day * input[start],
				dp(start, end - 1, input, day + 1, memory) + day * input[end]);
		
		return memory[start][end];
	}

}
