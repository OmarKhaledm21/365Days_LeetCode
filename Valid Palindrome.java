class Solution {
    public boolean isPalindrome(String s) {
        int len = s.length();
        s = s.toLowerCase();
        StringBuilder stringBuilder = new StringBuilder();
        for(int i=0; i<len; i++){
            int ascii = (int) s.charAt(i);
            if((ascii > 96 && ascii<123) || (ascii>47 && ascii<58)){
                stringBuilder.append(s.charAt(i));
            }
        }
        String converted = stringBuilder.toString();
        len = converted.length();
        int i=0; int j = len-1;
        while (i!=j && i<len){
            if(converted.charAt(i)==converted.charAt(j)){
                i++;
                j--;
            }else{
                return false;
            }
        }
        return true;
    }
}