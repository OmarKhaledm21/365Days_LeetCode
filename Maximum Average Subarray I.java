class Solution {
    
    public double findMaxAverage(int[] nums, int k) {
        double sum = 0;
        double avg = 0;
        double cur_avg = 0;

        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        avg = (sum / k);
      
        for (int i = k; i < nums.length; i++) {
            sum = sum - nums[i - k] + nums[i] ;
            cur_avg = sum/k;
            avg = Math.max(cur_avg,avg);
        }


        return avg;
    }
}