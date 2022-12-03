class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Character> hashMap = new HashMap();
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            char c1 = t.charAt(i);

            if (hashMap.containsKey(c)) {
                if (hashMap.get(c) != c1) {
                    return false;
                }
            } else {
                if (set.contains(c1)) {
                    return false;
                }
                hashMap.put(c, c1);
                set.add(c1);
            }
        }
        return true;
    }
}