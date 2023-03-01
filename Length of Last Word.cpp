class Solution
{
public:
    int lengthOfLastWord(string s)
    {
        int cur_len = 0;
        bool last_word = false;
        for (int i = s.length() - 1; i >= 0; i--)
        {
            if (s[i] == ' ' && last_word)
            {
                break;
            }
            else if (s[i] != ' ')
            {
                last_word = true;
                cur_len++;
            }
        }
        return cur_len;
    }
};
