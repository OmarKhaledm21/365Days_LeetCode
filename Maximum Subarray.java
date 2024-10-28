class Solution {

	public int maxSubArray(int[] nums) {
		int res = nums[0];

		int maxEnding = res;

		for (int i = 1; i < nums.length; i++) {
			int currentElement = nums[i];

			if (maxEnding + currentElement < currentElement) {
				maxEnding = currentElement;
			} else {
				maxEnding += currentElement;
			}

			res = Math.max(res, maxEnding);

		}

		return res;
	}

}
