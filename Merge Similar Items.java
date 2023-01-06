
class Solution {
    class comp implements Comparator<LinkedList<Integer>> {


        @Override
        public int compare(LinkedList<Integer> o1, LinkedList<Integer> o2) {
            return o1.get(0)-o2.get(0);
        }
    }
    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int[] val:items1){
            if(map.containsKey(val[0])){
                map.put(val[0],val[1]+map.get(val[0]));
            }else{
                map.put(val[0],val[1]);
            }
        }
        for(int[] val:items2){
            if(map.containsKey(val[0])){
                map.put(val[0],val[1]+map.get(val[0]));
            }else{
                map.put(val[0],val[1]);
            }
        }


        LinkedList<LinkedList<Integer>> set = new LinkedList<>();

        for(int key: map.keySet()){
            set.add(new LinkedList<>(List.of(key,map.get(key))));
        }
        set.sort(new comp());

        List<List<Integer>> ret = new LinkedList<>(set);
        
        return ret;
    }
}