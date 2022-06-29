class OrderedStream {
int ptr = 0; //Starting position of pointer
    List<String> output;
    public OrderedStream(int n) {
       output = new ArrayList<>(n);
        for(int i=0; i<n; i++){
            output.add(i,"-1");
        } 
    }
    
   public List<String> insert(int idKey, String value) {
        int id = idKey - 1;
        output.set(id,value);
        List<String> res = new ArrayList<>();
        while (ptr < output.size() && !(output.get(ptr).equals( "-1"))) {
            res.add(output.get(ptr));
            ptr++;
        }
        return res;
    }
}

/**
 * Your OrderedStream object will be instantiated and called as such:
 * OrderedStream obj = new OrderedStream(n);
 * List<String> param_1 = obj.insert(idKey,value);
 */