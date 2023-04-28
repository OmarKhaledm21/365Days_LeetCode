class Solution {
public:
    bool visited[101][101];

    int shortestPathBinaryMatrix(vector<vector<int>> &grid) {
        int n = grid.size();
        if (grid[n - 1][n - 1] == 1 || grid[0][0] == 1) {
            return -1;
        }
        int res = 1;
        queue<vector<int>> q;
        q.push({0, 0, 1});
        visited[0][0] = true;
        int direction[8][8] = {{0,  1},{1,  0},{-1, 0},{0,  -1},{-1, 1},{1,  1},{1,  -1},{-1, -1}};

        while (!q.empty()) {
            vector<int> front = q.front();
            q.pop();
            res = max(res, front[2]);
            if (front[0] == n - 1 && front[1] == n - 1) {
                break;
            }
            for (int i = 0; i < 8; i++) {
                int x = front[0] + direction[i][0];
                int y = front[1] + direction[i][1];
                if (x < 0 || x >= n || y < 0 || y >= n || grid[x][y] == 1 || visited[x][y]) {
                    continue;
                }
                if (grid[x][y] == 0) {
                    q.push({x, y, 1 + front[2]});
                    visited[x][y] = true;
                }
            }
        }
        if (!visited[n - 1][n - 1]) {
            return -1;
        }
        return res;
    }
};