class Solution {
    public int findCenter(int[][] edges) {

        int len = edges.length;
        int[] freq = new int[len + 2];
        for (int i = 0; i < len; i++) {
            System.out.println(edges[i][0]);
            System.out.println(edges[i][1]);
            freq[edges[i][0]]++;
            freq[edges[i][1]]++;
        }
        
        int max = -1;
        int ind = -1;
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] > max) {
                max = freq[i];
                ind = i;
            }
        }
        return ind;
    }
}