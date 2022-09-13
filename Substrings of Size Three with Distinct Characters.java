class Solution {
   public int countGoodSubstrings(String s) {
        if (s.length() < 3) {
            return 0;
        }
        int K = 3;
        int count = 0;

        Set<Character> set = new HashSet<>();

        for (int i = 0; i < s.length() - 2; i++) {
            set.add(s.charAt(i));
            set.add(s.charAt(i + 1));
            set.add(s.charAt(i + 2));
            if (set.size() == K) {
                count++;
            }
            set.clear();
        }
        return count;
    }
}