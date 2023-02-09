class Solution
{
public:
    string reversePrefix(string word, char ch)
    {
        string res = "";
        int i = 0;
        bool x = false;
        for (; i < word.length(); i++)
        {
            if (word[i] == ch)
            {
                x = true;
                break;
            }
        }
        if (x)
        {
            int j = (i + 1);
            while (i >= 0)
            {
                res += word[i];
                i--;
            }
            while (j < word.length())
            {
                res += word[j];
                j++;
            }
            return res;
        }
        else
        {
            return word;
        }
    }
};
