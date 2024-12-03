class Solution {
	public int findCircleNum(int[][] isConnected) {
		int n = isConnected.length;
		boolean[] visited = new boolean[n];
		int count = 0;
		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				visit(isConnected, visited, i);
				count++;
			}
		}
		return count;
	}

	private void visit(int[][] isConnected, boolean[] visited, int i) {
		visited[i] = true;
		for (int j = 0; j < isConnected.length; j++) {
			if (isConnected[i][j] == 1 && !visited[j]) {
				visit(isConnected, visited, j);
			}
		}
	}
}
