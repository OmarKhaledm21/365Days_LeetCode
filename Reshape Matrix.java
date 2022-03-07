
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] mat = {
                {1,2},
                {3,4}
        };
        solution.matrixReshape(mat,1,4);

    }
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        if(mat.length*mat[0].length!= r*c){
            return mat;
        }
        ArrayList<Integer> elements = new ArrayList<>();
        int m = mat.length;
        int n = mat[0].length;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++) {
                elements.add(mat[i][j]);
            }
        }

        int[][] res = new int[r][c];

        for(int i=0; i<r*c; i++){
            res[i/c][i%c] = elements.get(i);
        }
        return res;

    }

}

