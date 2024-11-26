class Solution {
    public int maxOperations(int[] nums, int k) {
        if (nums.length == 1) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int op = 0;
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        for (int num : nums) {
            if (map.containsKey(k - num)) {
                int x = map.get(k - num);
                int y = map.get(num);
                if (k - num == num && x >= 2) {
                    op++;
                    map.put(num, x - 2);
                } else if (k - num != num && x > 0 && y > 0) {
                    op++;
                    map.put(k - num, x - 1);
                    map.put(num, y - 1);
                }

            }
        }
        return op;
    }
}
