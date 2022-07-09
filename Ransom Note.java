import java.util.Hashtable;
class Solution {
     public boolean canConstruct(String ransomNote, String magazine) {
        Hashtable<Character,Integer> letter_count = new Hashtable<>();
        for(int i =0 ;i<ransomNote.length(); i++){
            char c = ransomNote.charAt(i);
            if(letter_count.containsKey( c )){
                int count = letter_count.get(c) +1;
                letter_count.replace(c,count);
            }else{
                letter_count.put(c,1);
            }
        }

        for(int i=0; i<magazine.length(); i++){
            char c = magazine.charAt(i);
            if(letter_count.containsKey( c )){
                int count = letter_count.get(c) - 1;
                if(count==0){
                    letter_count.remove(c);
                }else{
                    letter_count.replace(c,count);
                }
            }
        }

        return letter_count.size() == 0;
    }
}