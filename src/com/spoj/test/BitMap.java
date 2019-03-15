package com.spoj.test;

import static org.junit.Assert.assertArrayEquals;

import org.junit.jupiter.api.Test;

import com.spoj.impl.Bitmap;

class BitMap {

	@Test
	void test1() {
		int[][] result = Bitmap.execute(new int[][] { { 0, 0 } });
		assertArrayEquals(new int[][] { { 0, 0 } }, result);
	}

	@Test
	void test2() {
		int[][] result = Bitmap.execute(new int[][] { { 0, 0, 0, 1 }, { 0, 0, 1, 1 }, { 0, 1, 1, 0 } });
		assertArrayEquals(new int[][] { { 3, 2, 1, 0 }, { 2, 1, 0, 0 }, { 1, 0, 0, 1 } }, result);
	}

	@Test
	void test3() {
		int[][] result = Bitmap.execute(new int[][] { { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } });
		assertArrayEquals(new int[][] { { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } }, result);
	}

	@Test
	void test4() {
		int[][] result = Bitmap.execute(new int[][] { { 1, 1, 1 }, { 1, 1, 1 }, { 1, 1, 1 } });
		assertArrayEquals(new int[][] { { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } }, result);
	}

	@Test
	void test5() {
		int[][] result = Bitmap.execute(new int[][] { { 1 } });
		assertArrayEquals(new int[][] { { 0 } }, result);
	}

	@Test
	void test6() {
		int[][] result = Bitmap.execute(new int[][] { { 0 } });
		assertArrayEquals(new int[][] { { 0 } }, result);
	}

	@Test
	void test7() {
		int[][] result = Bitmap.execute(new int[][] { { 0 } });
		assertArrayEquals(new int[][] { { 0 } }, result);
	}

	@Test
	void test8() {
		int[][] result = Bitmap
				.execute(new int[][] { 
					{ 0, 0, 0, 0, 0, 0, 0 }, 
					{ 0, 0, 0, 1, 0, 0, 0 }, 
					{ 0, 0, 0, 1, 0, 0, 0 } });
		//assertArrayEquals(new int[][] { { 0 } }, result);
	}
}
