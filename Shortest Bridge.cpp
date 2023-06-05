class Solution {
public:
    vector<pair<int, int>> first, second;

    void mark(int i, int j, int island_no, vector<vector<int>> &grid) {
        if (i < 0 || j < 0 || i >= grid.size() || j >= grid[0].size() || grid[i][j] != 1) return;
        grid[i][j] = island_no;

        if (island_no == 2) {
            first.push_back({i, j});
        } else {
            second.push_back({i, j});
        }

        mark(i + 1, j, island_no, grid);
        mark(i - 1, j, island_no, grid);
        mark(i, j + 1, island_no, grid);
        mark(i, j - 1, island_no, grid);
    }


    int shortestBridge(vector<vector<int>> &grid) {
        int island_no = 2;
        for (int i = 0; i < grid.size(); i++) {
            for (int j = 0; j < grid[0].size(); j++) {
                if (grid[i][j] == 1) {
                    mark(i, j, island_no, grid);
                    island_no++;
                }
            }
        }

        int ans = 1e6;
        for (int i = 0; i < first.size(); i++) {
            for (int j = 0; j < second.size(); j++) {
                ans = min(abs(first[i].first - second[j].first) + abs(first[i].second - second[j].second) - 1, ans);
            }
        }
        return ans;
    }
};