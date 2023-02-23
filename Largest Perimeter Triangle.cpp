class Solution
{
public:
    int largestPerimeter(vector<int> &nums)
    {
        sort(nums.begin(), nums.end());
        int max = 0;
        for (int i = 0; i < nums.size() - 2; i++)
        {
            if (nums[i] + nums[i + 1] > nums[i + 2])
            {
                int perim = nums[i] + nums[i + 1] + nums[i + 2];
                if (perim > max)
                {
                    max = perim;
                }
            }
        }
        return max;
    }
};
