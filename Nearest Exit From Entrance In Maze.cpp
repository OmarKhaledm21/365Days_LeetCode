class Solution {
public:
    int nearestExit(vector<vector<char>> &maze, vector<int> &entrance) {
        int dx[] = {1, -1, 0, 0};
        int dy[] = {0, 0, 1, -1};
        int n = (int) maze.size();
        int m = (int) maze[0].size();
        int visited[n][m];
        memset(visited, 0, sizeof(visited));
        queue<vector<int>> q;
        q.push({entrance[0], entrance[1], 0});
        visited[entrance[0]][entrance[1]] = 1;

        while (!q.empty()) {
            vector<int> cur = q.front();
            q.pop();
            if ((cur[0] == 0 || cur[1] == 0 || cur[0] == n - 1 || cur[1] == m - 1) &&
                !(cur[0] == entrance[0] && cur[1] == entrance[1])) {
                return cur[2];
            }
            for (int i = 0; i < 4; i++) {
                int new_x = dx[i] + cur[0];
                int new_y = dy[i] + cur[1];
                if (new_x >= 0 && new_x < n && new_y >= 0 && new_y < m && maze[new_x][new_y] == '.' &&
                    !visited[new_x][new_y]) {
                    q.push({new_x, new_y, cur[2] + 1});
                    visited[new_x][new_y] = 1;
                }
            }
        }
        return -1;
    }
};