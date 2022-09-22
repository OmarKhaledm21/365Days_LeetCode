
class Solution
{
    //Function to check if two strings are isomorphic.
   public static boolean areIsomorphic(String str1, String str2) {
        // Your code here
        if (str1.length() != str2.length()) {
            return false;
        }

        HashSet<Character> set = new HashSet<>();
        int[] map = new int[256];
        Arrays.fill(map, -1);

        for (int i = 0; i < str1.length(); i++) {
            char s1 = str1.charAt(i);
            char s2 = str2.charAt(i);
            if (map[s1] == -1) {
                if (set.contains(s2)) {
                    return false;
                }
                set.add(s2);
                map[s1] = s2;
            } else if (map[s1] != s2) {
                return false;
            }
        }
        return true;
    }
}