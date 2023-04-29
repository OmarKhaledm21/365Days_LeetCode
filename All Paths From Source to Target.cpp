class Solution {
public:
    vector<int> visited;

    vector<vector<int>> allPathsSourceTarget(vector<vector<int>> &graph) {
        vector<vector<int>> paths;
        int n = graph.size();
        vector<int> v;
        dfs(0, n, graph, v, paths);
        return paths;

    }

    void dfs(int i, int n, vector<vector<int>> &graph, vector<int> &v, vector<vector<int>> &paths) {
        v.push_back(i);
        for (int p: graph[i]) {
            if (p != n - 1) {
                dfs(p, n, graph, v, paths);
            } else {
                v.push_back(p);
                paths.push_back(v);
                v.pop_back();
            }
        }
        v.pop_back(); 
    }
};
