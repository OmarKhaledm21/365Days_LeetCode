class Solution {
    public int equalPairs(int[][] grid) {
        int n = grid.length;
        Map<String, Integer> rowMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            StringBuilder rowRes = new StringBuilder();
            for (int j = 0; j < n; j++) {
                rowRes.append(grid[i][j]).append(",");
            }
            String rowString = rowRes.toString();
            rowMap.put(rowString, rowMap.getOrDefault(rowString, 0) + 1);
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            StringBuilder colRes = new StringBuilder();
            for (int j = 0; j < n; j++) {
                colRes.append(grid[j][i]).append(",");
            }
            String colString = colRes.toString();
            count += rowMap.getOrDefault(colString, 0);
        }

        return count;
    }
}
