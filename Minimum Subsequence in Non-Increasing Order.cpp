class Solution {
public:
    vector<int> minSubsequence(vector<int> &nums) {
        sort(nums.begin(), nums.end());
        int total = 0;
        vector<int> result;
        for (int n: nums) {
            total += n;
        }
        int current = 0;
        for (int i = nums.size() - 1; i >= 0; i--) {
            current += nums.at((i));
            result.push_back(nums.at(i));
            if (current >total-current){
                return result;
            }
        }
        return result;
    }
};