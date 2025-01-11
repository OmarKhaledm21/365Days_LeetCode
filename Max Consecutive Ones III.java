class Solution {
	public static int longestOnes(int[] nums, int k) {
		int max = 0;
		int flips = 0;
		int j = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0) {
				flips++;
			}
			while (flips > k) {
				if (nums[j] == 0) {
					flips--;
				}
				j++;
			}
			max = Math.max(max, i - j + 1);
		}

		return max;
	}
}
