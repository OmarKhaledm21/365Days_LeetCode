class Solution {
       public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int start = 0;
        int end = k;
        int min = nums[start];
        int max = nums[k-1];
        int globalMin = Integer.MAX_VALUE;
        while(end<nums.length)
        {
            globalMin = Math.min(globalMin, max-min);
            start++;
            min = nums[start];
            max = nums[end];
            end++;
        }
        globalMin = Math.min(globalMin, max-min);
        return globalMin;
    }
}