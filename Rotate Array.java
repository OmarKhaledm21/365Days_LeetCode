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
		int[] arr = { 1, 2, 3, 4, 5, 6, 7 };
		new Solution().rotate(arr, 3);
		System.out.println(Arrays.toString(arr));
	}

	class node {
		int num;
		node prev;
		node next;
	}

	public void rotate(int[] nums, int k) {

		int n = nums.length;
		if (k == 0) {
			return;
		} else if (n == 1) {
			return;
		}
		node head = new node();
		head.num = nums[0];
		node tail;
		node next = head;
		for (int i = 1; i < n; i++) {
			node nd = new node();
			nd.prev = next;
			nd.num = nums[i];
			next.next = nd;
			next = nd;
		}
		tail = next;

		while (k > 0) {
			node temp = tail;
			tail = tail.prev;
			tail.next = null;

			temp.next = head;
			temp.prev = null;

			head.prev = temp;
			head = temp;

			k--;
		}
		int q = 0;
		nums[q++] = head.num;
		while (head.next != null) {
			head = head.next;
			nums[q++] = head.num;
		}
	}
}
