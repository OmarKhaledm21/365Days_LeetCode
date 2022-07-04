class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        boolean contains_double = false;
        for(int val : nums){
            if(set.contains(val)){
                contains_double = true;
                break;
            }else{
                set.add(val);
            }
        }
        
        
        
        return contains_double;
    }
}