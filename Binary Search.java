
class Solution {
    public static void main(String[] args) {
        System.out.println(
                new Solution().search(new int[]{-998,-997,-995,-994,-991,-986,-984,-982,-981,-980,-978,-975,-973,-972,-970,-968,-967,-966,-962,-961},986        );
    }

    public int search(int[] nums, int target) {
        int l = 0, h = nums.length - 1;

        while (l <= h) {
            int m = l + (h-l) / 2;
            if (nums[m] == target) {
                return m;
            } else if (nums[m] < target) {
                l = m + 1;
            } else {
                h = m - 1;
            }
        }
        return -1;
    }


}