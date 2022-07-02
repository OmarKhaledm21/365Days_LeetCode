class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        HashSet<Character> allowed_set = new HashSet<>();
        for(var c : allowed.toCharArray()){
            allowed_set.add(c);
        }
        
        int count = 0;
        boolean flag;
        for(var word : words){
            flag = true;
            for(var c : word.toCharArray()){
                if(! allowed_set.contains(c)){
                    flag = false;
                    break;
                }
            }
            if(flag){
                count++;
            }
        }
        return count;
    }
}