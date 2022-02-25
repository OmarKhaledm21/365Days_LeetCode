class Solution {
     public int islandPerimeter(int[][] grid) {
        if(grid.length==1&& grid[0].length==1){
            return 4;
        }
        int res =0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j]==1) {
                    if (j - 1 >= 0 && grid[i][j - 1] == 0) {
                        res++;
                    }
                    if (j + 1 <= grid[0].length - 1 && grid[i][j + 1] == 0) {
                        res++;
                    }

                    if (i - 1 >= 0 && grid[i - 1][j] == 0) {
                        res++;
                    }
                    if (i + 1 <= grid.length - 1 && grid[i + 1][j] == 0) {
                        res++;
                    }
                    if(i-1 <0){
                        res++;
                    }
                    if(j-1 <0){
                        res++;
                    }
                    if(i+1 > grid.length-1){
                        res++;
                    }
                    if(j+1 >grid[0].length-1){
                        res++;
                    }

                }
            }
        }
        return res;
    }
}