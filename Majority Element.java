class Solution {
    public int majorityElement(int[] nums) {
    int n = nums.length;
    int threshold = n / 2;

    HashMap<Integer, Integer> map = new HashMap<>();

    for (int i = 0; i < n; i++) {
        int element = nums[i];
        int freq = map.getOrDefault(element, 0);
        if (freq + 1 > threshold) {
            return element;
        } else {
            map.put(element, freq + 1);
        }
    }
    for (var key : map.keySet()) {
        int freq = map.get(key);
        if (freq > n / 2) {
            return key;
        }
    }
    return 0;
}
}