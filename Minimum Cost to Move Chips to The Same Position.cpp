
class Solution {
public:
    int minCostToMoveChips(vector<int> &position) {
        int even = 0, odd = 0;
        for (int p: position) {
            if (p % 2 == 0) {
                even += 1;
            } else {
                odd += 1;
            }
        }
        return min(even, odd);
    }
};