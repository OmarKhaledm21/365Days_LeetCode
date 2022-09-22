class Solution {
   public int tribonacci(int n) {
        if (n <= 1) {
            return n;
        }
        int[] seq = new int[n + 1];
        seq[0] = 0;
        seq[1] = 1;
        seq[2] = 1;
        tribonacci(n, seq);
        return seq[n];

    }

    public int tribonacci(int i, int[] seq) {
        if (i <= 1) {
            return seq[i];
        }
        if (seq[i] == 0) {
            seq[i] = tribonacci(i - 1, seq) + tribonacci(i - 2, seq) + tribonacci(i - 3, seq);
        }
        return seq[i];
    }
}