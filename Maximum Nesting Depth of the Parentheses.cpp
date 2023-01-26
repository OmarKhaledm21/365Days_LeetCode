class Solution {
public:
    int maxDepth(string s) {
        int res = 0;
        int max = 0;
        for (int i = 0; i < s.size(); i++) {
            if (s[i] == '(') {
                res++;
                if (res > max) {
                    max = res;
                }
            }
            if (s[i] == ')') {
                res--;
            }
        }
        return max;
    }
};