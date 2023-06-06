class Solution {
    vector<vector<int>> visited;
    vector<int> dx;
    vector<int> dy;

    int DFS(vector<vector<int>> &grid, int x, int y, bool &walkoff) {
        if (x == 0 || x == grid.size() - 1 || y == 0 || y == grid[0].size() - 1) {
            walkoff = true;
        }
        visited[x][y] = 1;
        int count = 1;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i], ny = y + dy[i];
            if (nx >= 0 && nx < grid.size() && ny >= 0 && ny < grid[0].size() && grid[nx][ny] == 1 &&
                !visited[nx][ny]) {
                count += DFS(grid, nx, ny, walkoff);
            }
        }
        return count;
    }

public:
    int numEnclaves(vector<vector<int>> &grid) {
        int m = grid.size();
        int n = grid[0].size();
        dx = {0, 0, 1, -1};
        dy = {1, -1, 0, 0};
        visited = vector<vector<int>>(m, vector<int>(n, 0));
        int total = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    bool walkoff = false;
                    int c = DFS(grid, i, j, walkoff);
                    if (!walkoff) {
                        total += c;
                    }
                }
            }
        }
        return total;
    }
};