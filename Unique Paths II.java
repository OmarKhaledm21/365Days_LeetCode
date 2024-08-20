class Solution
{
    vector<vector<int>> dp;
    string str;
    string res;
    bool ispalindrome(int i, int j)
    {
        while (i < j)
        {
            if (str[i] != str[j])
                return false;
            i++;
            j--;
        }
        return true;
    }
    int helper(int i, int j)
    {
        if (i > j)
            return 0;
        if (i == str.length() || j == str.length())
            return 0;
        if (dp[i][j] != -1)
            return dp[i][j];
        if (str[i] == str[j])
        {
            if (ispalindrome(i, j))
            {
                string tmp = str.substr(i, j - i + 1);
                if (tmp.length() > res.length())
                {
                    res = str.substr(i, j - i + 1);
                    return j - i + 1;
                }
            }
        }

        int c1 = helper(i + 1, j);
        int c2 = helper(i, j - 1);
        return dp[i][j] = max(c1, c2);
    }

public:
    string longestPalindrome(string s)
    {
        res = "";
        str = s;
        dp = vector<vector<int>>(s.length() + 1, vector<int>(s.length() + 1, -1));
        helper(0, s.length() - 1);
        return res;
    }
};