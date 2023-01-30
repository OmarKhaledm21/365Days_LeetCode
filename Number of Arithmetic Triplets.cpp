class Solution
{
public:
    int arithmeticTriplets(vector<int> &nums, int diff)
    {
        int total = 0;
        int triplet[3];
        map<int, int> s1;
        for (int i = 0; i < nums.size(); i++)
        {
            s1.insert({nums[i], i});
        }

        for (size_t i = nums.size() - 1; i >= 2; i--)
        {
            triplet[2] = nums[i];
            triplet[1] = triplet[2] - diff;
            triplet[0] = triplet[1] - diff;
            if (s1.count(triplet[0]) > 0 && s1.count(triplet[1]) > 0)
            {
                triplet[2] = s1[triplet[2]];
                triplet[1] = s1[triplet[1]];
                triplet[0] = s1[triplet[0]];
                total++;
            }
        }

        return total;
    }
};