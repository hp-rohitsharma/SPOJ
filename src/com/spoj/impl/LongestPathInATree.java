package com.spoj.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LongestPathInATree {

	public static void main(String[] args) throws IOException {

		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		int lines = Integer.parseInt(stdin.readLine().trim()) - 1;

		List[] edges = new ArrayList[lines + 2];

		while (lines-- > 0) {
			String edge = stdin.readLine().trim();
			String[] nodes = edge.split(" ");

			int nodeOne = Integer.parseInt(nodes[0]);
			int nodeTwo = Integer.parseInt(nodes[1]);
			
			if (edges[nodeOne] == null) {
				edges[nodeOne] = new ArrayList<>();
			}
			edges[nodeOne].add(nodeTwo);

			if (edges[nodeTwo] == null) {
				edges[nodeTwo] = new ArrayList<>();
			}
			edges[nodeTwo].add(nodeOne);
		}

		Set<Integer> processedNodes = new HashSet<>();

		calculate(1, edges, processedNodes);
		System.out.println(max);
	}
	
	static int max = 0;
	
	private static int calculate(int node, List<Integer>[] edges, Set<Integer> processedNodes) {

		processedNodes.add(node);
		List<Integer> children = edges[node];

		if (children == null) {
			return 0;
		}

		int maxOne = 0;
		int maxTwo = 0;

		for (int i = 0; i < children.size(); i++) {
			int child = children.get(i);
			if (processedNodes.contains(child)) {
				continue;
			}
			int height = calculate(child, edges, processedNodes) + 1;
			
			if (height > maxOne) {
				maxTwo = maxOne;
				maxOne = height;
			} else if (height > maxTwo) {
				maxTwo = height;
			}
		}
		
		System.out.println("max height of node "+node+" is "+(maxOne+maxTwo));
		
		max = max > maxOne+maxTwo ? max : maxOne+maxTwo;
		
		return maxOne;

	}

}
