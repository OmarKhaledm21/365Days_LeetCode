import java.util.Hashtable;

class Solution {
    public int romanToInt(String s) {
        Hashtable<String, Integer> romanIntMap = new Hashtable<>();
        romanIntMap.put("I",1);
        romanIntMap.put("V",5);
        romanIntMap.put("X",10);
        romanIntMap.put("L",50);
        romanIntMap.put("C",100);
        romanIntMap.put("D",500);
        romanIntMap.put("M",1000);

        romanIntMap.put("IV",4);
        romanIntMap.put("IX",9);
        romanIntMap.put("XL",40);
        romanIntMap.put("XC",90);
        romanIntMap.put("CD",400);
        romanIntMap.put("CM",900);

        int res = 0;
        for(int i=0; i<s.length(); i++){
            String seq = String.valueOf(s.charAt(i));
            int temp = romanIntMap.get(seq);
            if( i+1 < s.length() ){
                seq+= s.charAt(i+1);
                if(romanIntMap.containsKey(seq)) {
                    res+= romanIntMap.get(seq);
                    i ++;
                }else{
                    res += temp;
                }
            }else{
                res+= temp;
            }
        }




        return res;
    }
}