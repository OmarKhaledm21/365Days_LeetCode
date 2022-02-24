class Solution {
    public int maximumDifference(int[] nums) {
            int res=-1;
            int min_ind=0;

            for(int i=1; i<nums.length; i++){
                if(nums[i]<nums[min_ind]){
                    min_ind=i;
                }
                int curDiff = nums[i]-nums[min_ind];
                if(curDiff>res && curDiff>0){
                    res = curDiff;
                }
            }
            return res;
    }
}