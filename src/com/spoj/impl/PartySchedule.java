package com.spoj.impl;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PartySchedule {

	static int moneySpent = 0;

	public static void main(String[] args) throws IOException {

		int[] costs = { 12, 15, 16, 16, 10 };
		int[] funs = { 3, 8, 9, 6, 2 };
		int money = 31;

		int[] memory = new int[funs.length];

		System.out.println(dp(costs, funs, 0, money, memory));
		System.out.println(moneySpent);

		// cost and fun
		// System.out.println(result[0] + " " + result[1]);
	}

	private static int dp(int[] costs, int[] funs, int i, int money, int[] memory) {

		if (costs.length == i) {
			return 0;
		}

		if (money <= 0) {
			return -funs[i];
		}

		int f1 = dp(costs, funs, i + 1, money - costs[i], memory) + funs[i];
		int f2 = dp(costs, funs, i + 1, money, memory);

		if (f1 > f2) {
			memory[i] = f1;
			moneySpent += costs[i]; 
		} else {
			memory[i] = f2;
		}
		return memory[i];

	}

	/*
	 * private static int[] max(int[] f1, int[] f2, int cost) {
	 * 
	 * int money = f2[1]; if (f1[0] > f1[0]) { money = f1[1] + cost; } return new
	 * int[] { Math.max(f1[0], f2[0]), money }; }
	 */

}
