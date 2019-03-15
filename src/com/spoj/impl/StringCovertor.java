package com.spoj.impl;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StringCovertor {

	public static void main(String[] args) throws IOException {
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		String line = stdin.readLine();
		while ((line = stdin.readLine()) != null && line.length() != 0) {
			System.out.println(dp(line, 0, line.length() - 1, new int[line.length()][line.length()]));
		}
	}

	private static int dp(String line, int start, int end, int[][] momorized) {
		int result = 0;

		if(momorized[start][end] > 0) {
			return momorized[start][end];
		}
		
		if (start >= end)
			return 0;

		if (line.charAt(start) == line.charAt(end))
			result = dp(line, start + 1, end - 1, momorized);
		else
			result = 1 + Math.min(dp(line, start, end - 1, momorized), dp(line, start + 1, end, momorized));

		momorized[start][end] = result;
		return result;
	}

}
