class Solution {
    public int longestSubarray(int[] nums) {
        int max = 0;
        int del = 0;
        int j=0;
        for(int i=0; i<nums.length; i++) {
        	if(nums[i] == 0) {
        		del++;
        	}
        	while(del > 1) {
        		if(nums[j] == 0) {
        			del--;
        		}
        		j++;
        	}
        	max = Math.max(max, i-j+1);
        }
        return max - 1;
    }
}
