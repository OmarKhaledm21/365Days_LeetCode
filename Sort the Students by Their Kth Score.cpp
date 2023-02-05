int globalK;
     bool comp(vector<int>&a,vector<int>&b)
    {
      return a[globalK]>b[globalK];  
    }
class Solution {
public:
   
    vector<vector<int>> sortTheStudents(vector<vector<int>>& score, int k) {
        globalK=k;    
        sort(score.begin(),score.end(),comp);
        return score;
    }
};