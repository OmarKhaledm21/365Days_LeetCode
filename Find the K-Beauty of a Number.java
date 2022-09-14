class Solution {
    public int divisorSubstrings(int num, int k) {
        int res = 0;
        String snum = String.valueOf(num);
        String cur = snum.substring(0, k);
        long div = Long.parseLong(cur);

        if (num % div == 0) {
            res++;
        }

        for (int i = k; i < snum.length(); i++) {
            int start = i - k + 1;
            int end = i;
            cur = snum.substring(start,end+1);
            div = Long.parseLong(cur);
            if (div != 0 && num % div == 0) {
                res++;
            }

        }

        return res;
    }
}