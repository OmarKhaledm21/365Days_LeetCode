class Solution {
    public int numberOfSubstrings(String s) {
        int res = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int i = 0;
        for (int j = 0; j < s.length(); j++) {
            map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);
            while (map.size() == 3) {
                res += (s.length() - j);
                if (map.get(s.charAt(i)) > 1) {
                    map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
                } else {
                    map.remove(s.charAt(i));
                }
                i++;
            }
        }
        return res;
    }
}