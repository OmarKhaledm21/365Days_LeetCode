package com.source.problems;

class Solution {
	public static void main(String[] args) {
		char[] letters = { 'x', 'x', 'y','y' };
		char target = 'z';
		System.out.println(new Solution().nextGreatestLetter(letters, target));
	}

	public char nextGreatestLetter(char[] letters, char target) {
		char res = letters[0];
		int t_ascii = (int) target;
		int[] ascii = new int[letters.length];
		int i = 0;
		for (char l : letters)
			ascii[i++] = (int) l;

		int ind = binarySearch(ascii, t_ascii);
		res = letters[ind];
		return res;
	}

	int binarySearch(int[] ascii, int target) {
		int res = 0;
		int n = ascii.length;
		int left = 0;
		int right = n - 1;

		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (ascii[mid] >target) {
				res = mid;
				right = mid - 1;
			} else {
				left= mid + 1;
			}
		}

		return res;
	}
}
