class Solution {
    vector<vector<pair<int, int>>> adj;

    int helper(int target) {
        vector<vector<int>> visited(adj.size(), vector<int>(2, 0));
        queue<vector<int>> q;
        q.push({0, -1, 0});

        while (!q.empty()) {
            vector<int> curr = q.front();
            q.pop();
            int node = curr[0];
            int color = curr[1];
            int dis = curr[2];

            for (int i = 0; i < adj[node].size(); i++) {
                int next = adj[node][i].first;
                int nextColor = adj[node][i].second;
                if (nextColor != color && visited[next][nextColor] == 0) {
                    visited[next][nextColor] = 1;
                    q.push({next, nextColor, dis + 1});
                    if (next == target) {
                        return dis + 1;
                    }
                }
            }
        }
        return -1;
    }

public:
    vector<int> shortestAlternatingPaths(int n, vector<vector<int>> &redEdges, vector<vector<int>> &blueEdges) {
        for (int i = 0; i < n; i++) {
            adj.push_back(vector<pair<int, int>>());
        }
        for (int i = 0; i < redEdges.size(); i++) {
            int u = redEdges[i][0];
            int v = redEdges[i][1];
            adj[u].push_back({v, 0});
        }
        for (int i = 0; i < blueEdges.size(); i++) {
            int u = blueEdges[i][0];
            int v = blueEdges[i][1];
            adj[u].push_back({v, 1});
        }
        vector<int> ans(n, -1);
        ans[0] = 0;
        for (int i = 1; i < n; i++) {
            ans[i] = helper(i);
        }
        return ans;
    }
};