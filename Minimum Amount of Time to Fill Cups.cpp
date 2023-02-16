class Solution
{
public:
    int fillCups(vector<int> &amount)
    {
        int n = amount.size();
        int cnt = 0;
        priority_queue<int> pq;
        if (amount[0] != 0)
            pq.push(amount[0]);
        if (amount[1] != 0)
            pq.push(amount[1]);
        if (amount[2] != 0)
            pq.push(amount[2]);

        while (pq.size() > 0)
        {
            cnt++;
            int a = 0, b = 0;
            if (pq.size() != 0)
            {
                a = pq.top();
                pq.pop();
                a = a - 1;
            }
            if (pq.size() != 0)
            {
                b = pq.top();
                pq.pop();
                b = b - 1;
            }
            if (a > 0)
            {
                pq.push(a);
            }
            if (b > 0)
            {
                pq.push(b);
            }
        }
        return cnt;
    }
};
