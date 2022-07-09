import java.util.Hashtable;
class Solution {
     public boolean isAnagram(String s, String t) {
        int sl = s.length();
        int tl = t.length();
        if(sl!=tl){
            return false;
        }
        Hashtable<Character,Integer> string_counter = new Hashtable<>();
        for(int i=0; i<sl; i++){
            char c = s.charAt(i);
            if(string_counter.containsKey( c )){
                string_counter.replace(c, string_counter.get(c)+1 );
            }else{
                string_counter.put(c,1);
            }
        }
        for(int i=0; i<sl; i++){
            char c = t.charAt(i);
            if(string_counter.containsKey( c )) {
                int count = string_counter.get(c) - 1;
                if (count == 0) {
                    string_counter.remove(c);
                } else {
                    string_counter.replace(c, string_counter.get(c) - 1);
                }
            }
        }


        return string_counter.size() == 0;
    }
}