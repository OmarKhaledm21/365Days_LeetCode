class Solution {

	public int maxSubarraySumCircular(int[] nums) {
		int totalSum = 0; 
		int maxSum = Integer.MIN_VALUE;
		int curMax = 0;
		int minSum = Integer.MAX_VALUE;
		int curMin = 0; 

		for (int num : nums) {
			curMax = Math.max(curMax + num, num);
			maxSum = Math.max(maxSum, curMax);

			curMin = Math.min(curMin + num, num);
			minSum = Math.min(minSum, curMin);

			totalSum += num;
		}

		if (maxSum < 0) {
			return maxSum;
		}
		
		return Math.max(maxSum, totalSum - minSum);
	}
}
