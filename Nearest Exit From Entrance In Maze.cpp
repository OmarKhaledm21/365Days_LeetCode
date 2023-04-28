class Solution {
public:
    bool visited[101][101];

    int nearestExit(vector<vector<char>> &grid, vector<int> &entrance) {
        int n = grid.size();
        int m = grid[0].size();
        if (m * n == 2) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (grid[i][j] == '+') {
                        return -1;
                    }
                }
            }
            return 1;
        } else if (m * n == 1) {
            return -1;
        }
        int res = 1;
        queue<vector<int>> q;
        q.push({entrance[0], entrance[1], 1});
        visited[0][0] = true;
        int direction[8][8] = {{0,  1},
                               {1,  0},
                               {-1, 0},
                               {0,  -1},
                               {-1, 1},
                               {1,  1},
                               {1,  -1},
                               {-1, -1}};
        vector<int> exit_{-1, -1};
        while (!q.empty()) {
            vector<int> cur = q.front();
            q.pop();
            res = max(res, cur[2]);
            if (cur[0] == n - 1 || cur[1] == m - 1 || cur[0] == 0 || cur[1] == 0 && grid[cur[0]][cur[1]] == '.') {
                if (cur[0] == entrance[0] && cur[1] == entrance[1]) {

                } else {
                    exit_[0] = cur[0];
                    exit_[1] = cur[1];
                    break;
                }
            }
            for (int i = 0; i < 4; i++) {
                int x = cur[0] + direction[i][0];
                int y = cur[1] + direction[i][1];
                if (x < 0 || x >= n || y < 0 || y >= m || grid[x][y] != '.' || visited[x][y]) {
                    continue;
                }
                if (grid[x][y] == '.') {
                    q.push({x, y, 1 + cur[2]});
                    visited[x][y] = true;
                }
            }
        }
        if (exit_[0] == -1 && exit_[1] == -1) {
            return -1;
        }
        return res - 1;
    }
};