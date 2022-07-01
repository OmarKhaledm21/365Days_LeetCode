import java.util.Hashtable;
import java.util.Map;
class Solution {
    public int countKDifference(int[] nums, int k) {
        Map<Integer, Integer> map = new Hashtable<>();
        int count = 0;
        for (var num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for(int i=0; i<nums.length; i++){
            count += (map.getOrDefault(k+nums[i],0));
        }
        return count;
    }
}