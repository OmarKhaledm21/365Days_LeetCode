class Solution {
    public int maxProduct(int[] nums) {
          if (nums.length == 2) {
            return (nums[0] - 1) * (nums[1] - 1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int num : nums) {
            pq.add(num);
        }
        return (pq.poll() - 1) * (Math.max(pq.poll(), pq.poll()) - 1);
    }

}