class Solution
{
public:
    int maximumUniqueSubarray(vector<int> &nums)
    {
        int j = 0;
        int total = 0;
        int gmax = 0;
        set<int> unique;
        for (int i = 0; i < nums.size(); i++)
        {
            if (unique.count(nums[i]) > 0)
            {

                if (gmax < total)
                {
                    gmax = total;
                }
                while (j < i)
                {
                    if (nums[j] == nums[i])
                    {
                        j++;
                        break;
                    }
                    else
                    {
                        unique.erase(nums[j]);
                        total -= nums[j];
                        j++;
                    }
                }
            }
            else
            {
                total += nums[i];
                unique.insert(nums[i]);
            }
        }
        if (gmax < total)
        {
            gmax = total;
        }
        return gmax;
    }
};