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

    public int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length;
        int n = maze[0].length;
        boolean[][] vis = new boolean[m][n];
        int[] dx = { -1, 0, 0, 1 };
        int[] dy = { 0, -1, 1, 0 };

        Queue<Cell> queue = new LinkedList<Cell>();
        int result = Integer.MAX_VALUE;
        int steps = 0;
        Cell currCell = new Cell(entrance[0], entrance[1], steps);
        queue.add(currCell);
        while (!queue.isEmpty()) {
            currCell = queue.poll();
            steps = currCell.steps;
            int u = currCell.u;
            int v = currCell.v;
            if ((u == 0 || u == m - 1 || v == 0 || v == n - 1) && (u != entrance[0] || v != entrance[1])) {
                result = Math.min(result, steps);
            }
            if (!vis[u][v]) {
                vis[u][v] = true;
                for (int i = 0; i < 4; i++) {
                    int x = u + dx[i];
                    int y = v + dy[i];
                    if (x >= 0 && y >= 0 && x < m && y < n && !vis[x][y] && maze[x][y] == '.') {
                        queue.add(new Cell(x, y, steps + 1));
                    }
                }
            }
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }
}
