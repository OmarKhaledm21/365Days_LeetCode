class Solution {
    public int partitionString(String s) {
        ArrayList<Set<Character>> arrayList = new ArrayList();

        for (int i = 0; i < s.length(); i++) {
            int n = arrayList.size();
            Set<Character> set;
            if (n == 0) {
                set = new HashSet();
                set.add(s.charAt(i));
                arrayList.add(set);
                continue;
            }
            set = arrayList.get(n - 1);
            if (set.contains(s.charAt(i))) {
                arrayList.add(new HashSet());
                arrayList.get(n).add(s.charAt(i));
            } else {
                set.add(s.charAt(i));
            }

        }

        return arrayList.size();
    }
}
