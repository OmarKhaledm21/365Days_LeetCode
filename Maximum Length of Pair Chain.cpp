class Solution
{
public:
    int LIS(vector<vector<int>> &arr)
    {
        int n = arr.size();
        vector<int> dp(n, 1);
        int maxi = 1;
        for (int i = 0; i < n; i++)
        {
            int c = arr[i][0];
            int d = arr[i][1];
            for (int prev = 0; prev < i; prev++)
            {
                int a = arr[prev][0];
                int b = arr[prev][1];
                if (b < c && 1 + dp[prev] > dp[i])
                {
                    dp[i] = 1 + dp[prev];
                }
            }
            if (dp[i] > maxi)
            {
                maxi = dp[i];
            }
        }
        return maxi;
    }
    int findLongestChain(vector<vector<int>> &pairs)
    {
        sort(pairs.begin(), pairs.end());

        return LIS(pairs);
    }
};