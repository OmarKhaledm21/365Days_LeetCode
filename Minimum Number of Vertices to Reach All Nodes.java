class Solution {
   
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        int[] freq = new int[n];
        
        for(int i = 0; i < edges.size(); i++){
            int v = edges.get(i).get(1);
            freq[v]++;
        }

        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if(freq[i] == 0){
                res.add(i);
            }
        }

        return res;
    }

}