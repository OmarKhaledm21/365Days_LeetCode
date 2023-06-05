class Solution {
    bool count_differences(string &str1, string &str2) {
        int c = 0;
        for (int i = 0; i < str1.size(); i++) {
            if (str1[i] != str2[i]) {
                c++;
                if (c > 1) {
                    return false;
                }
            }
        }
        if (c == 1) {
            return true;
        }
        return false;
    }

public:
    int minMutation(string startGene, string endGene, vector<string> &bank) {
        queue<pair<int, string>> q;
        q.push({0, startGene});
        int res = -1;
        int sz = bank.size();
        while (!q.empty()) {
            pair<int, string> p = q.front();
            q.pop();
            if (p.second == endGene) {
                return p.first;
            }
            for (int i = 0; i < sz; i++) {
                if (count_differences(p.second, bank[i])) {
                    q.push({p.first + 1, bank[i]});
                    bank.erase(bank.begin() + i);
                    i--;
                    sz--;
                }
            }
        }
        return res;
    }
};