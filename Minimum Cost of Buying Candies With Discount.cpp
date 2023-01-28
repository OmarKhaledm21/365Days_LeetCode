class Solution {
public:
    int minimumCost(vector<int> &cost) {
        sort(cost.begin(), cost.end());
        int total = 0;
        int two_r = 0;
        for (int i = cost.size() - 1; i >= 0; i--) {
            if (two_r == 2) {
                two_r = 0;
                continue;
            }
            total += cost[i];
            two_r++;
        }
        return total;
    }
};