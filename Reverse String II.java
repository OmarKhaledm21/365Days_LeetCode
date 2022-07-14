class Solution {
    public String reverseStr(String s, int k) {
        char[] charArr = s.toCharArray();
        int idx = 0;
        while (idx < s.length()) {
            int aux_idx = Math.min(idx + k - 1, s.length() - 1);
            int dummy_idx = idx;
            while (dummy_idx < aux_idx) {
                char left = charArr[dummy_idx];
                char right = charArr[aux_idx];

                charArr[dummy_idx] = right;
                charArr[aux_idx] = left;

                dummy_idx++;
                aux_idx--;
            }
            idx = idx + (2 * k);
        }
        s = new String(charArr);
        return s;
    }
}