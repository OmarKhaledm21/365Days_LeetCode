class Solution
{
public:
    int countPoints(string rings)
    {
        if (rings.length() < 3)
        {
            return 0;
        }
        int total = 0;
        map<int, set<char>> m;
        set<int> v;
        for (int i = 0; i < rings.length(); i += 2)
        {
            char c = rings[i];
            int pos = rings[i + 1];
            m[pos].insert(c);
            if (m[pos].size() == 3 && v.count(pos) == 0)
            {
                v.insert(pos);
                total++;
            }
        }
        return total;
    }
};