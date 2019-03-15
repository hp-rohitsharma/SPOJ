package com.spoj.impl;
import java.util.Scanner;

public class CodeGenerator {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		while (scanner.hasNextLine()) {
			Scanner lineScanner = new Scanner(scanner.nextLine());

			while (lineScanner.hasNext()) {
				String name = lineScanner.next();
				if (name.equals("0")) {
					return;
				}
				//System.out.println(count(name.split(""), 0, 0, 0));
			}
			lineScanner.close();
		}

		scanner.close();
	}

	/*private static long count(String[] input, int i, long sub_count, long last_merged_count) {
		
		int current = Integ input[i];
		if( > 0) {
			return count(input, 0, 0, 0);
		} else {
			return count(input, 0, 0, 0);
		}
		 
		
	}*/
	
 	private static long _count(String[] input, int i, long sub_count, long last_merged_count) {

		if (input.length == i + 1) {
			return sub_count;
		}

		int curr = Integer.valueOf(input[i]);
		int next = Integer.valueOf(input[i + 1]);

		int num = curr * 10 + next;
		if (num < 26 && num > 0 && curr > 0) {
			if (sub_count == 0) {
				sub_count = 1;
			} else {
				long new_last_merged_count = sub_count - last_merged_count;
				sub_count = 2 * sub_count - last_merged_count;
				last_merged_count = new_last_merged_count;
			}
		} else {
			last_merged_count = 0;
		}

		return _count(input, i + 1, sub_count, last_merged_count);
	}

}


//25114