package com.source.problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
	public int countNegatives(int[][] grid) {
		int count = 0;
		int m = grid.length;
		int n = grid[0].length;
		for (int i = 0; i < m; i++) {
			int l = binarySearch(grid, i);
			if (l < 0) {
				continue;
			}
			int r = grid[0].length - l;
			count += r;
		}

		return count;
	}

	public int binarySearch(int[][] grid, int m) {
		int left = 0;
		int right = grid[0].length - 1;
		int ind = -1;
		int mid;
		while (left <= right) {
			mid = left + (right - left) / 2;
			if (grid[m][mid] < 0) {
				ind = mid;
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}

		return ind;
	}
}
