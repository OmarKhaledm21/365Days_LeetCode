class Solution
{
public:
    vector<vector<int>> flipAndInvertImage(vector<vector<int>> &image)
    {
        int n = image.size();
        for (int i = 0; i < n; i++)
        {
            int j = 0, k = n - 1;
            while (j < k)
            {
                int temp = image[i][j];
                image[i][j] = 1 - image[i][k];
                image[i][k] = 1 - temp;
                j++;
                k--;
            }
            if (j == k)
            {
                image[i][j] = 1 - image[i][j];
            }
        }
        return image;
    }
};
