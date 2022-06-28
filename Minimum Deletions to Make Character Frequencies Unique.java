import java.util.*;

class Solution {
    public static void main(String[] args) {
        System.out.println(
                new Solution().minDeletions("aaabbbcc")
        );
    }

    public int minDeletions(String s) {
        int deletions = 0;
        int[] freq_count = new int[123];
        for (int i = 0; i < 123; i++) {
            freq_count[i] = 0;
        }

        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            freq_count[current]++;
        }

        Map<Integer, Integer> freqsMap = new HashMap<>();

        for (int i = 97; i < 123; i++) {
            int n = freq_count[i];
            if (n != 0) {
                freqsMap.put(n, freqsMap.getOrDefault(n, 0) + 1);
            }
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.addAll(freqsMap.keySet());

        while (!pq.isEmpty()) {
            int val = pq.poll(), freq = freqsMap.get(val);
            deletions += freq - 1;
            if (freq > 1 && val > 1) {
                if (!freqsMap.containsKey(val - 1)) pq.add(val - 1);
                freqsMap.put(val - 1, freqsMap.getOrDefault(val - 1, 0) + freq - 1);
            }
        }

        return deletions;
    }
}