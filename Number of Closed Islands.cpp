
class Solution {
public:
    int closedIsland(vector<vector<int>> &grid) {
        queue<pair<int, int>> q;
        int n = grid.size(), m = grid[0].size();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 || i == n - 1 || j == 0 || j == m - 1) {
                    if (grid[i][j] == 0) {
                        grid[i][j] = 1;
                        q.push({i, j});
                    }
                }
            }
        }

        int dx[4] = {1, -1, 0, 0};
        int dy[4] = {0, 0, 1, -1};

        while (q.size()) {
            auto l = q.front();
            q.pop();
            int x = l.first;
            int y = l.second;
            for (int i = 0; i < 4; i++) {
                int new_x = dx[i] + x;
                int new_y = dy[i] + y;
                if (new_x >= 0 && new_x < n && new_y >= 0 && new_y < m && grid[new_x][new_y] == 0) {
                    grid[new_x][new_y] = 1;
                    q.push({new_x, new_y});
                }
            }
        }
        int counter = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!grid[i][j]) {
                    counter++;
                    q.push({i, j});
                    while (q.size()) {
                        auto l = q.front();
                        q.pop();
                        int x = l.first;
                        int y = l.second;
                        for (int i = 0; i < 4; i++) {
                            int new_x = dx[i] + x;
                            int new_y = dy[i] + y;
                            if (new_x >= 0 && new_x < n && new_y >= 0 && new_y < m && grid[new_x][new_y] == 0) {
                                grid[new_x][new_y] = 1;
                                q.push({new_x, new_y});
                            }
                        }
                    }
                }
            }
        }
        return counter;
    }
};