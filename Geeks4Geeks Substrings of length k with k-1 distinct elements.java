import java.io.*;
import java.util.StringTokenizer;


public class Solution {
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() throws FileNotFoundException {
            br = new BufferedReader(
                    new FileReader("input.txt"));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() throws IOException {
            st = new StringTokenizer(br.readLine());
            String str = "";
            try {
                if (st.hasMoreTokens()) {
                    str = st.nextToken("\n");
                } else {
                    str = br.readLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();

        System.out.println(countOfSubstrings("abcc", 2));
    }


    static int countOfSubstrings(String S, int K) {
        // code here
        int[] freq = new int[123];
        int count = 0;
        int distinction = 0;
        for (int i = 0; i < K; i++) {
            int ch = (int) S.charAt(i);
            freq[ch]++;
            if (freq[ch] == 1) {
                distinction++;
            }
        }
        if (distinction == K - 1) {
            count++;
        }

        for (int i = K; i < S.length(); i++) {
            int ch_old = S.charAt(i - K);
            int ch_new = S.charAt(i);
            if (ch_old == ch_new) {
                if (distinction == K - 1) {
                    count++;
                }
            } else {
                freq[ch_old]--;
                if (freq[ch_old] == 0) {
                    distinction--;
                }
                freq[ch_new]++;
                if (freq[ch_new] == 1) {
                    distinction++;
                }
                if (distinction == K - 1) {
                    count++;
                }
            }
        }


        return count;
    }
}