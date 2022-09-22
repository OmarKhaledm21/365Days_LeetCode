class Solution {
     public int fib(int n) {
        if (n <= 1) {
            return n;
        }
        int[] seq = new int[n + 1];
        seq[0] = 0;
        seq[1] = 1;
        fib(n, seq);
        return seq[n];

    }

    public int fib(int i, int[] seq) {
        if (i <= 1) {
            return i;
        }
        if (seq[i] == 0) {
            seq[i] = fib(i - 1, seq) + fib(i - 2, seq);
        }
        return seq[i];
    }
}