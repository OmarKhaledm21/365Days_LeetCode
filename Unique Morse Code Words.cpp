class Solution
{
public:
    int uniqueMorseRepresentations(vector<string> &words)
    {
        set<string> s;
        string arr[26] = {
            ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
        int alpha = 97;
        int j = 0;
        map<char, string> m;
        for (int i = alpha; i <= 122; i++)
        {
            m.insert({char(alpha), arr[j]});
            alpha++;
            j++;
        }
        for (int i = 0; i < words.size(); i++)
        {
            string current = words[i];
            string moris = "";
            for (j = 0; j < current.length(); j++)
            {
                moris += m[current[j]];
            }
            s.insert(moris);
        }
        return s.size();
    }
};