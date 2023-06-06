class Solution {
    vector<int> dx;
    vector<int> dy;
public:
    int shortestPathBinaryMatrix(vector<vector<int>> &grid) {
        dx = {-1, -1, -1, 0, 0, 1, 1, 1};
        dy = {-1, 0, 1, -1, 1, -1, 0, 1};
        int n = grid.size();
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) return -1;
        vector<vector<int>> visited(n, vector<int>(n, 0));
        queue<vector<int>> q;
        q.push({0, 0, 0});
        while (!q.empty()) {
            vector<int> cur = q.front();
            q.pop();
            if (cur[0] == n - 1 && cur[1] == n - 1) return cur[2] + 1;
            for (int i = 0; i < 8; i++) {
                int new_x = cur[0] + dx[i];
                int new_y = cur[1] + dy[i];
                if (new_x >= 0 && new_x < n && new_y >= 0 && new_y < n && grid[new_x][new_y] == 0 &&
                    visited[new_x][new_y] == 0) {
                    grid[new_x][new_y] = 1;
                    q.push({new_x, new_y, cur[2] + 1});
                    visited[new_x][new_y] = 1;
                }
            }
        }
        return -1;
    }
};