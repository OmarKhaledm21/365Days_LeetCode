package com.source.problems;

import java.util.Arrays;
import java.util.Collections;

class Solution {
	public static void main(String[] args) {
		System.out.println(
				new Solution().findTheDistanceValue(new int[] { 2, 1, 100, 3 }, new int[] { -5, -2, 10, -3, 7 }, 6));
	}

	public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
		int count = 0;
		Arrays.sort(arr2);

		for (int i = 0; i < arr1.length; i++) {
			int target = arr1[i];
			int less_element_ind = binarySearch(arr2, target);
			int more_element_ind = less_element_ind + 1;
			boolean is_valid = true;

			if (more_element_ind < arr2.length && Math.abs(target - arr2[more_element_ind]) <= d) {
				is_valid = false;
			}
			if (less_element_ind > -1 && Math.abs(target - arr2[less_element_ind]) <= d) {
				is_valid = false;
			}

			if (is_valid) {
				count++;
			}

		}

		return count;
	}

	public int binarySearch(int[] arr2, int target) {
		int ind = -1;
		int left = 0;
		int right = arr2.length - 1;

		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (arr2[mid] <= target) {
				ind = mid;
				left = mid + 1;
			} else {
				right = mid - 1;

			}

		}
		return ind;
	}
}
