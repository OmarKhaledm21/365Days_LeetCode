class Solution {
    public boolean checkIfPangram(String sentence) {
        HashSet<Character> chars = new HashSet<>();
        for(var c : sentence.toCharArray()){
            chars.add(c);
        }
        if(chars.size() == 26){
            return true;
        }
        return false;
    }
}