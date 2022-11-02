import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

class MyHashMap {
    static class Pair {
        int key;
        int value;

        public Pair(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int BUCKET_SIZE = 10_000;
    private ArrayList<Pair>[] BUCKET;
    private Set<Integer> keySet = new HashSet<>();
    public MyHashMap() {
        this.BUCKET = new ArrayList[BUCKET_SIZE];
    }

    public int hash(int key) {
        return key % BUCKET_SIZE;
    }

    public void put(int key, int value) {
        int hashIndex = hash(key);
        if (BUCKET[hashIndex] == null) {
            BUCKET[hashIndex] = new ArrayList<>();
        }
        if(keySet.contains(key)){
            for(Pair pair: BUCKET[hashIndex]){
                if(pair.key==key){
                    pair.value = value;
                }
            }
        }else{
            keySet.add(key);
            BUCKET[hashIndex].add(new Pair(key, value));
        }
    }

    public int get(int key) {
        int hashIndex = hash(key);
        if (BUCKET[hashIndex] == null) {
            return -1;
        } else {
            ArrayList<Pair> pairs = BUCKET[hashIndex];
            for (Pair pair : pairs) {
                if (pair.key == key) {
                    return pair.value;
                }
            }
            return -1;
        }
    }

    public void remove(int key) {
        int hashIndex = hash(key);
        if (BUCKET[hashIndex] != null) {
            for (int i=0; i<BUCKET[hashIndex].size(); i++) {
                Pair pair = BUCKET[hashIndex].get(i);
                if (pair.key == key) {
                    keySet.remove(pair.key);
                    BUCKET[hashIndex].remove(i);
                }
            }
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */