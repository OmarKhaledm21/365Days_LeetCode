class Solution {
     public int removeElement(int[] nums, int val) {
        int i = 0;
        for (var num: nums){
            if (num != val){
                nums[i] = num;
                i++;
            }
        }
        return i;
    }
}