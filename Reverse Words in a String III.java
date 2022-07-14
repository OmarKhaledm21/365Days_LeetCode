class Solution {
    public String reverseWords(String s) {
        String[] arr =s.split(" ");
        StringBuilder res = new StringBuilder();
        for(String word : arr){
            res.append(" ");
            for(int i=word.length()-1; i>=0; i--){
                res.append(word.charAt(i));
            }
        }
        
        return res.toString().trim();
    }
}