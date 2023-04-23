class Solution {
public:
    int target = -1;
    vector<vector<int>> res;
    static const int MAX = 50;
    int visited[MAX][MAX];

    vector<vector<int>> floodFill(vector<vector<int>> &image, int sr, int sc, int color) {
        for (int i = 0; i < 50; i++) {
            for (int j = 0; j < 50; j++) {
                visited[i][j] = -1;
            }
        }
        for (int i = 0; i < image.size(); i++) {
            vector<int> v(image[0].size());
            res.push_back(v);
        }
        target = image[sr][sc];
        res[sr][sc] = color;
        visited[sr][sc] = 1;
        helper(image, sr + 1, sc, color);
        helper(image, sr - 1, sc, color);
        helper(image, sr, sc - 1, color);
        helper(image, sr, sc + 1, color);
        for (int i = 0; i < image.size(); i++) {
            for (int j = 0; j < image[0].size(); j++) {
                if (res[i][j] != color) {
                    res[i][j] = image[i][j];
                }
            }
        }
        return res;
    }

    void helper(vector<vector<int>> &image, int sr, int sc, int color) {
        if (sr < 0 || sc < 0 || sr > image.size() - 1 || sc > image[0].size() - 1) {
            return;
        }
        if (image[sr][sc] != target) {
            return;
        }
        if (visited[sr][sc] == 1) {
            return;
        }
        res[sr][sc] = color;
        visited[sr][sc] = 1;
        helper(image, sr + 1, sc, color);
        helper(image, sr - 1, sc, color);
        helper(image, sr, sc - 1, color);
        helper(image, sr, sc + 1, color);

    }

};