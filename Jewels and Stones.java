import java.util.HashSet;
class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        HashSet<Character> set = new HashSet<>();
        for(int i=0; i<jewels.length(); i++){
            char current = jewels.charAt(i);
            set.add(current);
        }
        int total = 0;
        for(int i=0; i<stones.length(); i++){
            char current = stones.charAt(i);
            if(set.contains(current)){
                total++;
            }
        }
        
        return total;
    }
}