class Solution
{
public:
    vector<int> majorityElement(vector<int> &nums)
    {
        int th = nums.size() / 3;
        unordered_map<int, int> m;
        set<int> s;
        vector<int> res;
        for (int i = 0; i < nums.size(); i++)
        {
            m[nums[i]]++;
            if (m[nums[i]] > th)
            {
                s.insert({nums[i]});
            }
        }
        for (const int &x : s)
        {
            res.push_back(x);
        }

        return res;
    }
};