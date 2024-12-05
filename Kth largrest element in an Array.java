class Solution {
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b) -> b - a);
        for (int num : nums) {
            pq.add(num);
        }
        while (k != 0) {
            k--;
            if (k == 0) {
                return pq.peek();
            }

            pq.poll();
        }
        return 0;
    }
}
