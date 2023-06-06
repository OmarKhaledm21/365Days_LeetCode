class Solution {
public:
    vector<vector<int>> updateMatrix(vector<vector<int>> &mat) {
        int n = mat.size(), m = mat[0].size();
        vector<vector<int>> res(n, vector<int>(m, 1e6));
        int dx[] = {0, 0, 1, -1};
        int dy[] = {1, -1, 0, 0};
        queue<pair<int, int>> q;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 0) {
                    res[i][j] = 0;
                    q.push({i, j});
                }
            }
        }

        while (!q.empty()) {
            pair<int, int> cur = q.front();
            q.pop();

            for (int i = 0; i < 4; i++) {
                int new_x = cur.first + dx[i];
                int new_y = cur.second + dy[i];
                if (new_x >= 0 && new_x < n && new_y >= 0 && new_y < m) {
                    if (res[new_x][new_y] > res[cur.first][cur.second] + 1) {
                        res[new_x][new_y] = res[cur.first][cur.second] + 1;
                        q.push({new_x, new_y});
                    }
                }
            }
        }
        return res;
    }
};