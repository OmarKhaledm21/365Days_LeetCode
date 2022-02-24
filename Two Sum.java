import java.util.Arrays;
import java.util.Hashtable;
class Solution {
public int[] twoSum(int[] nums, int target) {
        Hashtable<Integer,Integer> hashtable = new Hashtable<>();
        for(int i=0; i<nums.length; i++){
            hashtable.put(nums[i],i);
        }
        for(int i=0; i<nums.length; i++){
            if(hashtable.containsKey(target-nums[i])){
                if(i != hashtable.get(target-nums[i])) {
                    return new int[]{i, hashtable.get(target - nums[i])};
                }
            }
        }

        return new int[]{0,0};
    }
}