class Solution {
    public int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i=0; i< nums.length; i++){
            int ele = nums[i];
            if(set.contains(ele)){
                set.remove(ele);
            }else{
                set.add(ele);
            }
        }
        return set.iterator().next();
    }
}