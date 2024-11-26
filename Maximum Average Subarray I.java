class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double sum = 0;
        double gsum = 0;
        int j = 0;
        for (; j < k; j++) {
            sum += nums[j];
        }
        gsum = sum;
        int i = 0;

        while (j < nums.length) {
            sum -= nums[i++];
            sum += nums[j++];
            gsum = Math.max(sum, gsum);
        }

        return gsum / k;
    }
}
