class Solution {
public:
    string removeOuterParentheses(string s) {
         stringstream res;
        stack<char> st;
        for (int i = 0; i < s.length(); i++)
        {
            if (st.empty() && s[i] == '(')
            {
                st.push('(');
            }
            else
            {
                if (st.size() > 0 && s[i] == '(')
                {
                    st.push('(');
                    res << '(';
                }
                else if (st.size() > 1 && s[i] == ')')
                {
                    st.pop();
                    res << ')';
                }
                else
                {
                    st.pop();
                }
            }
        }
        return res.str();
    }
    
};