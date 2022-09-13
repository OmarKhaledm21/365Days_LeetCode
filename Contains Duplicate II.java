class Solution {
   public boolean containsNearbyDuplicate(int[] nums, int k) {
      if (nums.length == k || k > nums.length) {
            k = nums.length - 1;
        }
       Set<Integer> set = new HashSet<>();
        for (int i = 0; i <= k; i++) {
            if (set.contains(nums[i])){
                return true;
            }
            set.add(nums[i]);
        }

        for (int i=1; i<nums.length-k; i++){
            set.remove(nums[i-1]);
            if (set.contains(nums[i+k])){
                return true;
            }else{
                set.add(nums[i+k]);
            }
        }
        return false;
    }
}