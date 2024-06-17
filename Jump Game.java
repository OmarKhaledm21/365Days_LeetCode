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
		int[] arr = { 2, 3, 1, 1, 4 };
		new Solution().canJump(arr);
	}

	public boolean canJump(int[] nums) {
		int gas = nums[0];
		for (int i : nums) {
			if (gas < 0) {
				return false;
			}
			if (i > gas) {
				gas = i;
			}
			gas--;
		}
		return true;
	}

	
}
