class Solution {
    public int countVowelSubstrings(String word) {
        HashSet<Character> vowel_set = new HashSet<>();
        vowel_set.add('a');
        vowel_set.add('e');
        vowel_set.add('i');
        vowel_set.add('o');
        vowel_set.add('u');
        HashSet<Character> set = new HashSet<>();
        
        int count = 0;
        int max_range = word.length();
        for (int i = 0; i < max_range - 4; i++) {
            for (int j = i; j < max_range; j++) {
                char c = word.charAt(j);
                if (vowel_set.contains(c)) {
                    set.add(c);
                    if (set.size() >= 5) {
                        count++;
                    }
                }else{
                    break;
                }
            }
            set.clear();
        }
        return count;
    }
}