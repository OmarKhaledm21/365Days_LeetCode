class Solution {
public:
    int total;
    int max_area;
    vector<vector<bool>> visited;

    int maxAreaOfIsland(vector<vector<int>> &grid) {
        total = 0;
        int m = grid.size(), n = grid[0].size();
        for (int i = 0; i < m; i++) {
            vector<bool> v(n);
            visited.push_back(v);
            for (int j = 0; j < n; j++) {
                visited[i][j] = false;
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && grid[i][j] == 1) {
                    DFS(grid, i, j);
                    max_area = max(total, max_area);
                    total = 0;
                }
            }
        }
        return max_area;
    }

    void DFS(vector<vector<int>> &grid, int r, int c) {
        if (r < 0 || c < 0 || r > grid.size() - 1 || c > grid[0].size() - 1) {
            return;
        }
        if (visited[r][c] || grid[r][c] == 0) {
            return;
        }
        visited[r][c] = true;
        total++;
        DFS(grid, r, c + 1);
        DFS(grid, r + 1, c);
        DFS(grid, r - 1, c);
        DFS(grid, r, c - 1);
    }
};