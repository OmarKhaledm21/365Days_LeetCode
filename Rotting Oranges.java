class Solution {
    public static class Cell {
        public int u;
        public int v;
        public int steps;

        public Cell(int u, int v, int lvl) {
            super();
            this.u = u;
            this.v = v;
            this.steps = lvl;
        }

    }

    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] dx = { 1, 0, -1, 0 };
        int[] dy = { 0, 1, 0, -1 };

        Queue<Cell> queue = new LinkedList<>();
        int freshCount = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new Cell(i, j, 0));
                } else if (grid[i][j] == 1) {
                    freshCount++; // Count fresh oranges
                }
            }
        }

        if (freshCount == 0) {
            return 0;
        }

        int timeElapsed = 0;

        while (!queue.isEmpty()) {
            Cell curr = queue.poll();
            int u = curr.u;
            int v = curr.v;
            int steps = curr.steps;
            timeElapsed = steps;

            for (int i = 0; i < 4; i++) {
                int x = u + dx[i];
                int y = v + dy[i];
                if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 1) {
                    grid[x][y] = 2;
                    queue.add(new Cell(x, y, steps + 1));
                    freshCount--;
                }
            }
        }

        return freshCount == 0 ? timeElapsed : -1;
    }
}
