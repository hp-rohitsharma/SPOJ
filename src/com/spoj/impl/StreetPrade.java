package com.spoj.impl;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class StreetPrade {

	public static void main(String[] args) throws IOException {
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		String line;
		boolean first = true;

		while ((line = stdin.readLine()) != null && line.length() != 0) {
			if (line.equals("0")) {
				return;
			}
			if (first) {
				first = false;
			} else {
				first = true;
				System.out.println(canArrange(line.split(" ")));
			}
		}
	}

	private static String canArrange(String[] trucks) {

		Stack<Integer> sideStreet = new Stack<>();
		int lastPassedTruck = 0;

		for (String truck : trucks) {
			int truckName = Integer.parseInt(truck);
			if (truckName == lastPassedTruck + 1) {
				lastPassedTruck = truckName;
			} else {
				while(!sideStreet.isEmpty() && sideStreet.peek() == lastPassedTruck + 1) {
					lastPassedTruck = sideStreet.pop();
				}
				sideStreet.push(truckName);
			}
		}

		if (sideStreet.isEmpty()) {
			return "yes";
		} else {
			while (!sideStreet.isEmpty()) {
				int truckName = sideStreet.pop();
				if (truckName != lastPassedTruck + 1) {
					return "no";
				}
				lastPassedTruck = truckName;
			}
			return "yes";
		}
	}

}
