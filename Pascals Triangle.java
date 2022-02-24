class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        for(int i=1; i<=numRows; i++){
            ArrayList<Integer> currentList = new ArrayList<>();
            currentList.add(1);
            if(i>1){
                for(int j=1; j<i-1; j++){
                    currentList.add(res.get(i-2).get(j)+res.get(i-2).get(j-1));
                }
                currentList.add(1);
            }
            res.add(currentList);
        }
        return res;
    }
}