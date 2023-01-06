class Solution {
     public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        HashMap<Integer, Integer> cache = new HashMap<>();
        cache.put(1, 1);
        cache.put(2, 2);
        return climbStairs(n, cache);
    }

    public int climbStairs(int n, HashMap<Integer, Integer> cache) {
        if (n <= 2) {
            return n;
        }
        if (cache.containsKey(n)) {
            return cache.get(n);
        }
        int result = climbStairs(n - 1, cache) + climbStairs(n - 2, cache);
        cache.put(n, result);
        return result;
    }
}