class Solution
{
public:
    bool isvowel(char c)
    {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
    int maxVowels(string s, int k)
    {
        int i = 0;
        int j = 0;
        int n = s.size();
        int len = 0;
        int cur = 0;
        int res = 0;
        // Code starts
        while (j < n)
        {
            if (isvowel(s[j]))
            {
                cur++;
            }
            len++;
            if (len > k)
            {
                if (isvowel(s[i]))
                {
                    cur--;
                }
                i++;
            }

            res = max(res, cur);

            j++;
        }
        return res;
    }
};