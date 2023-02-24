class Solution
{
public:
    void dfs(int index, vector<int> &nums, int sum, int &ans)
    {
        if (index == nums.size())
        {
            ans += sum;
            return;
        }

        // take
        dfs(index + 1, nums, sum ^ nums[index], ans);
        
        // not take
        dfs(index + 1, nums, sum, ans);
    }

    int subsetXORSum(vector<int> &nums)
    {
        int ans = 0;
        dfs(0, nums, 0, ans);
        return ans;
    }
};
