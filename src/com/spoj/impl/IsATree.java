package com.spoj.impl;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class IsATree {

	public static void main(String[] args) throws IOException {
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		String line;
		int edgesCount = 0;
		int inputs = 0;
		List edges[] = null;
		boolean first = true;

		while ((line = stdin.readLine()) != null && line.length() != 0) {
			if (first) {
				String nodesAndEdges = line;
				if (validNodesAndEdges(nodesAndEdges)) {
					String[] nAndE = nodesAndEdges.split(" ");
					edgesCount = Integer.parseInt(nAndE[1]);
					edges = new List[Integer.parseInt(nAndE[0])];
				} else {
					System.out.println("NO");
					return;
				}
				first = false;
			} else {
				String edge = line;
				String[] nodes = edge.split(" ");
				int a = Integer.parseInt(nodes[0]);
				int b = Integer.parseInt(nodes[1]);

				List<Integer> nodea = edges[a - 1];
				if (nodea == null) {
					nodea = new ArrayList<Integer>();
				}
				nodea.add(b);
				edges[a - 1] = nodea;

				List<Integer> nodeb = edges[b - 1];
				if (nodeb == null) {
					nodeb = new ArrayList<Integer>();
				}
				nodeb.add(a);
				edges[b - 1] = nodeb;

				inputs++;
				if (edgesCount == inputs) {
					break;
				}
			}
		}

		if (isTree(edges)) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}

	private static boolean validNodesAndEdges(String nodesAndEdges) {
		String[] nAndE = nodesAndEdges.split(" ");
		return (Integer.parseInt(nAndE[0]) == Integer.parseInt(nAndE[1]) + 1);
	}

	private static boolean isTree(List[] edges) {

		boolean accesedNodes[] = new boolean[edges.length];

		dfs(1, accesedNodes, edges);

		for (boolean b : accesedNodes) {
			if (b == false) {
				return false;
			}
		}
		return true;
	}

	private static void dfs(int n, boolean[] accesedNodes, List[] edges) {
		accesedNodes[n-1] = true;
		
		List<Integer> connectedNodes = edges[n-1];

		for (Integer node : connectedNodes) {
			if (accesedNodes[node-1] == false) {
				dfs(node, accesedNodes, edges);
			}
		}
	}

}
