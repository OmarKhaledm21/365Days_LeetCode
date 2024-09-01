class Solution {
    	public void solve(char[][] board) {
		int m = board.length;
		int n = board[0].length;
		for (int i = 0; i < m; ++i) {
			for (int j = 0; j < n; ++j) {
				if ((i == 0 || i == m - 1 || j == 0 || j == n - 1) && board[i][j] == 'O') {
					dfs(board, i, j);
				}
			}
		}
		for (int i = 0; i < m; ++i) {
			for (int j = 0; j < n; ++j) {
				if (board[i][j] == 'O') {
					board[i][j] = 'X';
				}
			}
		}
		for (int i = 0; i < m; ++i) {
			for (int j = 0; j < n; ++j) {
				if (board[i][j] == 'Y') {
					board[i][j] = 'O';
				}
			}
		}
	}

	private void dfs(char[][] board, int i, int j) {
		int m = board.length;
		int n = board[0].length;
		int[][] dir = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
		board[i][j] = 'Y';
		for (int[] d : dir) {
			int x = i + d[0];
			int y = j + d[1];
			if (x > 0 && x < m - 1 && y > 0 && y < n - 1 && board[x][y] == 'O') {
				dfs(board, x, y);
			}
		}
	}
}
