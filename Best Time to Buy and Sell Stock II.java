package com.source.problems;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

class Solution {
	public static void main(String[] args) {
		int[] arr = { 7, 1, 5, 3, 6, 4 };
		new Solution().maxProfit(arr);
	}

	public int maxProfit(int[] prices) {
		int max = 0;
		int start = prices[0];
		int len = prices.length;
		for (int i = 1; i < len; i++) {
			if (start < prices[i])
				max += prices[i] - start;
			start = prices[i];
		}
		return max;
	}

}
