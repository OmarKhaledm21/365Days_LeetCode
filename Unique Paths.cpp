class Solution {
public:
    int m, n;
    int uniquePaths(int m, int n) {
        vector<vector<bool>> visited(m, vector<bool>(n, false));
        vector<vector<int>> dp(m, vector<int>(n, -1));

        this->m = m;
        this->n = n;

        helper(m-1, n-1, visited, dp);

        return dp[m-1][n-1];
    }


    int helper(int i, int j, vector<vector<bool>> &visited, vector<vector<int>> &dp)
    {
        if(i<0 || i>=m || j<0 || j>=n || visited[i][j]) return 0;
        if(i==0 || j==0) return dp[i][j] = 1;

        if(dp[i][j] != -1) return dp[i][j];

        visited[i][j] = true;
        int paths = helper(i-1, j, visited, dp) + helper(i, j-1, visited, dp);
        visited[i][j] = false;

        return dp[i][j] = paths;
    }
};