package com.source.problems;


class Solution {
	public static void main(String[] args) {
		System.out.println(new Solution().maximumCount(new int[] { 0, 0, 0, 0, 0 }));
	}

	public int maximumCount(int[] nums) {
		int n = nums.length;
		int res = binarySearch(nums);

		int pos = n - (res + 1);
		int neg = res + 1;

		int temp = res + 1;
		while (temp < n && nums[temp++] == 0) {
			pos--;
		}

		return Math.max(pos, neg);

	}

	public int binarySearch(int[] arr) {
		int ind = -1;
		int left = 0;
		int right = arr.length - 1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (arr[mid] < 0) {
				left = mid + 1;
				ind = mid;
			} else {
				right = mid - 1;

			}
		}

		return ind;
	}
}
