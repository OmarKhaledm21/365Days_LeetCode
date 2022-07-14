class Solution {
    public int[] sortedSquares(int[] nums) {
        int l = 0, r = nums.length - 1, ptr = nums.length - 1;
        int[] res = new int[nums.length];
        
        while (l <= r) {
            int lsquare = nums[l] * nums[l];
            int rsquare = nums[r] * nums[r];
            if (lsquare > rsquare) {
                res[ptr] = lsquare;
                l += 1;
            } else {
                res[ptr] = rsquare;
                r -= 1;
            }
            ptr -= 1;
        }
        return res;
    }
}