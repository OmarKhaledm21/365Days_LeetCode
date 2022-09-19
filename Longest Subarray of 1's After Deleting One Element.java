class Solution {
     public int longestSubarray(int[] nums) {
        int start = 0;
        int end = 0;
        int count = 0;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] == 0 && count == 0) {
                count++;
            } else if (nums[i] == 0 && count >= 1) {
                count++;
                end = i;
                max = Math.max(max, end - start - 1);
            }
            while (count > 1) {
                if (nums[start] == 0) {
                    count--;
                }
                start++;
            }
        }
        if (nums[nums.length - 1] == 1) {
            max = Math.max(max, nums.length - start - 1);
        }
        if (max == Integer.MIN_VALUE) {
            return nums.length - 1;
        }
        return max;
    }

}