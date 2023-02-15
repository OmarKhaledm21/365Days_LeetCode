
class Solution
{
public:
    vector<int> targetIndices(vector<int> &nums, int target)
    {
        vector<int> res;
        int commulative = -1;
        int count = 0;
        for (int &x : nums)
        {
            if (x == target)
            {
                count++;
            }
            else if (x < target)
            {
                commulative++;
            }
        }

        while (count > 0)
        {
            res.push_back(++commulative);
            count--;
        }
        return res;
    }
};
