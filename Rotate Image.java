class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        for (int i = 0, j = n - 1; i < n && i < j; i++, j--) {
            for (int k = 0; k < m; k++) {
                int temp = matrix[i][k];
                matrix[i][k] = matrix[j][k];
                matrix[j][k] = temp;
            }
        }

        int start = 1;
        for (int i = 0; i < n - 1; i++) {
            for (int j = start; j < m; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;

            }
            start++;
        }

    }
}