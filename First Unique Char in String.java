import java.util.ArrayList;
import java.util.Hashtable;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(
            solution.firstUniqChar(new String("aadadaad"))
        );
    }
    public int firstUniqChar(String s) {
        Hashtable<Character,Integer> chars = new Hashtable<>();
        int min_ind = Integer.MAX_VALUE;
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(chars.containsKey(c)){
                chars.replace(c, -1);
            }else{
                chars.put(c,i);
            }
        }
        for(char c : chars.keySet()){
            int ind =chars.get(c);
            if(ind<min_ind && ind!= -1){
                min_ind = ind;
            }
        }
        return min_ind==Integer.MAX_VALUE? -1:min_ind;
    }

}

