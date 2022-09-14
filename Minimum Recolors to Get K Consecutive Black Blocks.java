class Solution {
    
    public int minimumRecolors(String blocks, int k) {
        int min = Integer.MAX_VALUE;
        char[] b = blocks.toCharArray();

        int freq = 0;
        for (int i=0; i<k; i++){
            if(b[i]=='W'){
                freq++;
            }
        }
        min = freq;

        for(int i=k; i<b.length; i++){
            if (b[i-k] == 'W'){
                freq--;
            }
            if(b[i] == 'W') {
                freq++;
            }
            min = Math.min(min,freq);

        }

        return min;
    }
}