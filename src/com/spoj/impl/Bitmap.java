package com.spoj.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Bitmap {

	public static void main(String[] args) throws IOException {

		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		int cases = Integer.parseInt(stdin.readLine());

		while (cases-- > 0) {
			String size = stdin.readLine();
			int[] dimensions = toInt(size.split(" "));
			int[][] input = new int[dimensions[0]][dimensions[1]];
			int rowInd = 0;
			while (rowInd++ < dimensions[0]) {
				String row = stdin.readLine();
				int[] rowData = toInt(row.split(""));
				input[rowInd-1] = rowData;
			}
			int[][] result = execute(input);
			print(result);
			String empty = stdin.readLine();
		}
	}

	public static int[][] execute(int[][] input) {
		Queue<int[]> queue = new LinkedList<>();

		boolean[][] processedNodes = new boolean[input.length][input[0].length];
		int[][] result = new int[input.length][input[0].length];

		for (int i = 0; i < input.length; i++) {
			for (int j = 0; j < input[i].length; j++) {
				if (input[i][j] != 1) {
					queue.add(new int[] { i, j });
					bfs(queue, processedNodes, input, result, i, j);
					queue.clear();
					processedNodes = new boolean[input.length][input[0].length];
				}
			}
		}

		return result;
	}

	private static int[] toInt(String[] split) {
		int[] intArray = new int[split.length];
		for (int i = 0; i < split.length; i++) {
			intArray[i] = Integer.parseInt(split[i]);
		}
		return intArray;
	}

	private static void print(int[][] result) {
		for (int[] i : result) {
			for (int j = 0; j < i.length; j++) {
				System.out.print(i[j]);
				if (j != i.length - 1) {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}

	private static void bfs(Queue<int[]> queue, boolean[][] processedNodes, int[][] input, int[][] result, int i,
			int j) {

		int[] node = queue.poll();

		if (node == null) {
			return;
		}
		// white then this is nearest
		if (input[node[0]][node[1]] == 1) {
			// mod
			int value = ((node[0] - i) < 0 ? (i - node[0]) : (node[0] - i))
					+ ((node[1] - j) < 0 ? (j - node[1]) : (node[1] - j));

			if (result[i][j] > value) {
				result[i][j] = value;
			} else if (result[i][j] == 0) {
				result[i][j] = value;
			}
		}

		processedNodes[node[0]][node[1]] = true;
		List<int[]> children = getUnProcessedChildNodes(input, node[0], node[1], processedNodes);
		queue.addAll(children);
		bfs(queue, processedNodes, input, result, i, j);

	}

	private static List<int[]> getUnProcessedChildNodes(int[][] input, int i, int j, boolean[][] processedNodes) {

		int iMax = input.length;
		int jMax = input[0].length;

		List<int[]> children = new ArrayList<>();

		// right
		if (i + 1 < iMax) {
			addChild(i + 1, j, children, processedNodes);
			// right top
			if (j + 1 < jMax) {
				addChild(i + 1, j + 1, children, processedNodes);
			}
			// right bottom
			if (j - 1 >= 0) {
				addChild(i + 1, j - 1, children, processedNodes);
			}
		}

		// left
		if (i - 1 >= 0) {
			addChild(i - 1, j, children, processedNodes);
			// left top
			if (j + 1 < jMax) {
				addChild(i - 1, j + 1, children, processedNodes);
			}
			/// left bottom
			if (j - 1 >= 0) {
				addChild(i - 1, j - 1, children, processedNodes);
			}
		}
		// top
		if (j + 1 < jMax) {
			addChild(i, j + 1, children, processedNodes);
		}
		// bottom
		if (j - 1 >= 0) {
			addChild(i, j - 1, children, processedNodes);
		}

		return children;
	}

	private static void addChild(int i, int j, List<int[]> children, boolean[][] processedNodes) {

		if (!processedNodes[i][j]) {
			children.add(new int[] { i, j });
		}
	}

}
