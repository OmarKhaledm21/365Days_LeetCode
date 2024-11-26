class Solution {
    public int largestAltitude(int[] gain) {
        int n =gain.length;
        int m = gain.length+1;
    	int[] alt = new int[m];
    	alt[0]=0;
    	int max = Integer.MIN_VALUE;
    	for(int i=0; i<n; i++) {
    		alt[i+1] = alt[i] + gain[i];
    		max = Math.max(max, alt[i]);
    	}
    	
    	return max = Math.max(max, alt[m-1]);
    	
    }
}
