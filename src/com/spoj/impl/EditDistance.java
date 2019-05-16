package com.spoj.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class EditDistance {

	public static void _main(String[] args) throws IOException {
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		int lines = Integer.parseInt(stdin.readLine());
		
		while(lines-- > 0) {
			String str1 = stdin.readLine();
			String str2 = stdin.readLine();
			System.out.println(counter(str1, str2));
		}
	}
	
	public static void main(String[] args) {
		
		String a = "";
		String b = " ";
		System.out.println(counter(a,b));
		System.out.println(calculate(a,b));
	}
	
	public static int counter(String a, String b) {
		int[][] cache = new int[a.length()][b.length()];
		return dp(a, b, a.length() - 1, b.length() - 1, cache);
	}

	public static int dp(String a, String b, int i, int j, int[][] cache) {
	
		if(i < 0) {
			return j + 1;
		}
		
		if(j < 0) {
			return i + 1;
		}
		
		if(cache[i][j] != 0) {
			return cache[i][j];
		}
		
		int cost = 1;
		
		if (a.charAt(i) == b.charAt(j)) {
			cost = 0; // same
		}

		int add = dp(a, b, i - 1, j, cache) + 1; // add
		int del = dp(a, b, i, j - 1, cache) + 1; // del
		int replace	= dp(a, b, i - 1, j - 1, cache) + cost; // replace
		
		int min =  min(add, del, replace);
		cache[i][j] = min;
		
		return min;
	}

	private static int min(int a, int b, int c) {
		if (a < b) {
			return (a < c ? a : c);
		} else {
			return (b < c ? b : c);
		}
	}
	
	
	static int calculate(String x, String y) {
        if (x.isEmpty()) {
            return y.length();
        }
 
        if (y.isEmpty()) {
            return x.length();
        } 
 
        int substitution = calculate(x.substring(1), y.substring(1)) 
         + costOfSubstitution(x.charAt(0), y.charAt(0));
        int insertion = calculate(x, y.substring(1)) + 1;
        int deletion = calculate(x.substring(1), y) + 1;
 
        return min(substitution, insertion, deletion);
    }
 
    public static int costOfSubstitution(char a, char b) {
        return a == b ? 0 : 1;
    }
 
    public static int min(int... numbers) {
        return Arrays.stream(numbers)
          .min().orElse(Integer.MAX_VALUE);
    }
    
	
 
}
