class Solution {
    	public int numIslands(char[][] grid) {
		int sum = 0;
		boolean[][] visited = new boolean[grid.length][grid[0].length];

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == '1' && !visited[i][j]) {
					BFS(grid, visited, i, j);
					sum++;
				}
			}
		}
		return sum;
	}

	public void BFS(char[][] grid, boolean[][] visited, int i, int j) {
		int[][] directions = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
		visited[i][j] = true;
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[]{i,j});
		while(!queue.isEmpty()) {
			int[] current = queue.poll();
			for (int[] dir : directions) {
				int x = current[0] + dir[0];
				int y = current[1] + dir[1];
				if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == '1' && !visited[x][y]) {
					visited[x][y] = true;
					queue.add(new int[] { x, y });
				}
			}
		}
	}
}
