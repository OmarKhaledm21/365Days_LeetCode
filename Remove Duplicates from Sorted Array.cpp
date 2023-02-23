class Solution
{
public:
    int removeDuplicates(vector<int> &nums)
    {

        int sz = nums.size();
        int r = 0;
        for (int i = 1; i < nums.size(); i++)
        {
            if (nums[i] == nums[i - 1])
            {
                nums.erase(nums.begin() + i);
                i--;
                r++;
            }
        }

        return sz - r;
    }
};
