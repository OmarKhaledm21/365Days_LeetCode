class Solution {
public:
    int numIdenticalPairs(vector<int>& nums) {
    if(nums.size()<=1){
        return 0;
    }
    map<int,int>m;
    int total =0;
    int len = nums.size();
    for(int i=0; i<len; i++){
        if(m.count(nums[i])){
            m[nums[i]]++;
        }else{
            m[nums[i]] = 0;
        }
    }
    for(pair<int,int> n : m){
        int v = n.second;
        if(n.second){
            total+= (v* (v+1) )/2;
        }
    }
    return total;
}
};