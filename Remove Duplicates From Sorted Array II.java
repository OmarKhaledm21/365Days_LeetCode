package com.source.problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
	public static void main(String[] args) {
		int[] arr = { 1,1,1,2,2,3};
		System.out.println(new Solution().removeDuplicates(arr));
	}

	public int removeDuplicates(int[] nums) {
		HashMap<Integer, Integer> map = new HashMap();
		int i = 0;
		for (int num : nums) {
			if (!map.containsKey(num)) {
				nums[i++] = num;
				map.put(num, 1);
			} else if (map.get(num) < 2) {
				nums[i++] = num;
				map.put(num, map.get(num) + 1);
			}
		}
		return i;
	}
}
