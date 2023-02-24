class Solution
{
public:
    vector<string> helper(TreeNode *&root)
    {
        // base case
        if (root == nullptr)
            return {};

        vector<string> res;
        string root_val = to_string(root->val);
        vector<string> left = helper(root->left);
        vector<string> right = helper(root->right);
        for (auto it : left)
            res.push_back(root_val + "->" + it);
        for (auto it : right)
            res.push_back(root_val + "->" + it);

        if (res.size() == 0)
            return {root_val};
        return res;
    }
    vector<string> binaryTreePaths(TreeNode *root)
    {
        return helper(root);
    }
};
