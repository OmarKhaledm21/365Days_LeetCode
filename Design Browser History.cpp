class node
{
public:
    string url;
    node *left;
    node *right;
    node(string url)
    {
        this->url = url;
        this->left = nullptr;
        this->right = nullptr;
    }
};

class BrowserHistory
{
    node *current;

public:
    BrowserHistory(string homepage)
    {
        this->current = new node(homepage);
    }

    void visit(string url)
    {
        node *new_node = new node(url);
        if (this->current->right != nullptr)
        {
            node *it = this->current->right;
            node *temp = nullptr;
            while (it != nullptr)
            {
                temp = it;
                it = it->right;
                delete temp;
            }
        }
        new_node->left = this->current;
        this->current->right = new_node;
        this->current = new_node;
    }

    string back(int steps)
    {
        while (steps != 0 && this->current->left != nullptr)
        {
            this->current = this->current->left;
            steps--;
        }
        return this->current->url;
    }

    string forward(int steps)
    {
        while (steps != 0 && this->current->right != nullptr)
        {
            this->current = this->current->right;
            steps--;
        }
        return this->current->url;
    }
};