class Solution
{
public:
    ListNode *middleNode(ListNode *head)
    {
        vector<ListNode *> v;
        int count = 0;
        while (head != nullptr)
        {
            v.push_back(head);
            head = head->next;
            count++;
        }
        return v[count / 2];
    }
};
