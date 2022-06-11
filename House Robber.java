class Solution {
    public int rob(int[] nums) {
        int len = nums.length;
        if(len == 1){
            return nums[0];
        }
        int[] dp = new int[len+2];
        int lendp = dp .length;
        for(int i=2; i<lendp; i++){
            dp[i] = Math.max(dp[i-2] + nums[i-2],dp[i-1]);
        }
        return dp[lendp-1];
    }
}