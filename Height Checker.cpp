class Solution {

public:
    int heightChecker(vector<int>& heights) {
        int total =0;
        vector<int> c = heights;
        sort(c.begin(),c.end());
        for(int i=0; i<heights.size(); i++){
            if(c[i]!= heights[i]){
                total++;
            }
        }
        return total;
    }
};