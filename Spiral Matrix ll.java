class Solution {
    
    public int[][] generateMatrix(int n) {
        int rowEnd = n - 1;
        int colEnd = n - 1;
        int val = 1;
        int colStart = 0;
        int rowStart = 0;

        int[][] res = new int[n][n];

        while (rowStart <= rowEnd && colStart <= colEnd) {

            for (int i = colStart; i <= colEnd; i++) {
                res[rowStart][i] = val++;
            }
            rowStart++;
            for (int i = rowStart; i <= rowEnd; i++) {
                res[i][colEnd] = val++;
            }
            colEnd--;

            if (rowStart <= rowEnd) {
                for (int i = colEnd; i >= colStart; i--) {
                    res[rowEnd][i] = val++;
                }
            }
            rowEnd--;

            if (colStart <= colEnd) {
                for (int i = rowEnd; i >= rowStart; i--) {
                    res[i][colStart] = val++;
                }
            }
            colStart++;
        }
        return res;
    }
}