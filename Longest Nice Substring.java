class Solution {
      public String longestNiceSubstring(String s) {
        String nice = "";
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String sub = s.substring(i, j);
                //System.out.println(sub);
                if (check(sub)) {
                    if (sub.length() > max) {
                        max = sub.length();
                        nice = sub;
                    }
                }
            }
        }
        return nice;
    }

    public boolean check(String str) {
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            set.add(str.charAt(i));
        }

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (Character.isLowerCase(ch)) {
                if (!set.contains(Character.toUpperCase(ch))) {
                    return false;
                }
            } else {
                if (!set.contains(Character.toLowerCase(ch))) {
                    return false;
                }
            }
        }
        return true;
    }

}