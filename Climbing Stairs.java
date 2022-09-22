class Solution {
     public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int[] seq = new int[n + 1];
        seq[1] = 1;
        seq[2] = 2;

        for (int i = 3; i <= n; i++) {
            seq[i] = seq[i - 1] + seq[i - 2];
        }

        return seq[n];
    }
}