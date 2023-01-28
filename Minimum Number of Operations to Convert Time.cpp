
class Solution {
public:
    int getTime(string &s) {
        return (stoi(s.substr(0, 2)) * 60) + stoi(s.substr(3));
    }

    int convertTime(string current, string correct) {
        int gap = getTime(correct) - getTime(current);
        int moves[4] = {60, 15, 5, 1};
        int ans = 0;

        for (int move: moves) {
            ans += gap / move;
            gap %= move;
            if (gap == 0) {
                return ans;
            }
        }
        return ans;
    }
};