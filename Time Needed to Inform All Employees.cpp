class Solution {
    vector<vector<pair<int, int>>> adj;
    vector<int> visited;

    int dfs(int u) {
        visited[u] = 1;
        int res = 0;
        for (auto &v: adj[u]) {

            res = max(res, dfs(v.first) + v.second);
        }
        return res;
    }

public:
    int numOfMinutes(int n, int headID, vector<int> &manager, vector<int> &informTime) {
        for (int i = 0; i < n; i++) {
            adj.push_back(vector<pair<int, int>>());
        }
        visited = vector<int>(n, 0);
        int manager_ind = -1;
        for (int i = 0; i < n; i++) {
            int u = manager[i];
            if (manager[i] == -1) {
                manager_ind = i;
            } else {
                adj[u].push_back({i, informTime[u]});
            }
        }

        return dfs(manager_ind);
    }
};