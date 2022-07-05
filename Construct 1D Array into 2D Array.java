class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        int olen = original.length;
        if(m*n != olen) {
            
            
            return new int[][]{};
        }
        int[][] _2DArray = new int[m][n];
        for(int i=0; i<m*n; i++){
            _2DArray[i/n][i%n] = original[i];
        }
        return _2DArray;
    }
}