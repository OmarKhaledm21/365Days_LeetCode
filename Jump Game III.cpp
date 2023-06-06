class Solution {
public:
    bool canReach(vector<int> &arr, int start) {
        vector<int> visited(arr.size(), 0);
        queue<pair<int, int>> q;
        q.push({start, arr[start]});
        visited[start] = 1;
        while (!q.empty()) {
            pair<int, int> p = q.front();
            q.pop();
            if (p.second == 0) {
                return true;
            }

            int c1 = p.first + p.second;
            int c2 = p.first - p.second;

            if (c1 < arr.size() && visited[c1] == 0) {
                q.push({c1, arr[c1]});
                visited[c1] = 1;
            }
            if (c2 >= 0 && visited[c2] == 0) {
                q.push({c2, arr[c2]});
                visited[c2] = 1;
            }
        }
        return false;
    }
};