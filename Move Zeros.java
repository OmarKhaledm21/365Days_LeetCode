class Solution {
    public void moveZeroes(int[] nums) {
        int i = 0;
        int j = 0;
        while (j < nums.length) {
            if (i < nums.length) {
                if (nums[i] != 0) {
                    nums[j] = nums[i];
                    j++;
                }
                i++;
            } else {
                nums[j] = 0;
                j++;
            }
        }
    }
}