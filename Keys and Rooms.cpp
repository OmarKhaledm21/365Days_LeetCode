class Solution {
    vector<int> adj[1002];
public:
    bool canVisitAllRooms(vector<vector<int>> &rooms) {
        int n = rooms.size();
        for (int i = 0; i < n; i++) {
            adj[i] = vector<int>();
        }
        for (int i = 0; i < n; i++) {
            for (int j: rooms[i]) {
                adj[i].push_back(j);
            }
        }
        vector<bool> visited(n, false);
        queue<int> q;
        q.push(0);
        visited[0] = true;
        while (!q.empty()) {
            int u = q.front();
            q.pop();
            for (int v: adj[u]) {
                if (!visited[v]) {
                    visited[v] = true;
                    q.push(v);
                }
            }
        }
        if (count(visited.begin(), visited.end(), true) == n) {
            return true;
        } else {
            return false;
        }
    }
};