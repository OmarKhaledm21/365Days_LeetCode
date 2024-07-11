class Solution {
public boolean containsNearbyDuplicate(int[] nums, int k) {
		HashMap<Integer, List<Integer>> map = new HashMap();
		for (int i = 0; i < nums.length; i++) {
			List<Integer> list;
			if (map.containsKey(nums[i])) {
				list = map.get(nums[i]);
				for (var j : list) {
					if (i != j && Math.abs(i - j) <= k) {
						return true;
					}
				}
				list.add(i);
				map.put(nums[i], list);
			} else {
				list = new ArrayList();
				list.add(i);
				map.put(nums[i], list);
			}
		}
		return false;
	}
}
