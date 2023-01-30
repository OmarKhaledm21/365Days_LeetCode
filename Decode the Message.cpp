class Solution
{
public:
    string decodeMessage(string key, string message)
    {
        stringstream res;
        map<char, char> m;
        m[' '] = ' ';
        int alpha = 97;
        int i = 0;
        while (m.size() <= 26)
        {
            char cur = key[i++];
            char cur_alpha = char(alpha);
            if (m.count(cur) == 0)
            {
                m.insert({cur, cur_alpha});
                alpha++;
            }
        }

        for (i = 0; i < message.length(); i++)
        {
            res << m[message[i]];
        }

        return res.str();
    }
};