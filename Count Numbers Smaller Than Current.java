class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] smaller = new int[501];
        for(int i=0; i<501; i++){
            smaller[i]=0;
        }
        
        int len = nums.length;
        for(int i=0; i<len; i++){
            smaller[nums[i]]++;
        }
        
        int out_ind = 0;
        int[] output = new int[len];
        for(int num : nums){
            int total = 0;
            for(int i=0; i<num; i++){
                total+= smaller[i];
            }
            output[out_ind] = total;
            out_ind++;
        }
        
        return output;
    }
}