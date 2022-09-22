class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int start = 0;
        int end = 0;
        int odd_count = 0;
        int sub_total = 0;
        int total = 0;

        for (; end < nums.length; end++) {
            if (nums[end] % 2 == 1) {
                odd_count++;
                sub_total=0;
            }
            while (odd_count == k) {
                sub_total++;
                if (nums[start] % 2 == 1) {
                    odd_count--;
                }
                start++;
            }
            total += (sub_total);
        }
        return total;
    }
}