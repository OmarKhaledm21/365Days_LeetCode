class Solution {
    public int minimumOperations(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        Set<Integer>  set= new HashSet<>();
        for (int num : nums) {
            if (num > 0 && !set.contains(num)) {
                pq.add(num);
                set.add(num);
            }
        }
        int op_total = 0;
        while (pq.size() > 1) {
            op_total++;
            Integer p = pq.poll();
            Integer q = pq.poll();
            if (p - q > 0) {
                pq.add(p);
            }
        }
        if (pq.size() == 1) {
            return op_total + 1;
        }
        return op_total;
    }
}