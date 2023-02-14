
class Solution
{
public:
    bool isPalindrome(string sub)
    {
        int n = sub.length();
        for (int i = 0; i < n; i++)
        {
            if (sub[i] != sub[n - i - 1])
            {
                return false;
            }
        }
        return true;
    }
    int removePalindromeSub(string s)
    {
        return isPalindrome(s) ? 1 : 2;
    }
};

