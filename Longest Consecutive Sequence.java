class Solution {
  public int longestConsecutive(int[] nums) {
		if(nums.length <=1) {
			return nums.length;
		}
		Set<Integer> set = new TreeSet();
		int sum = 0;
		for (int x : nums) {
			set.add(x);
		}
		if(set.size() == 1) {
			return set.size();
		}
		Iterator<Integer> it = set.iterator();
		int prev = it.next();
		int curr_sum = 1;
		do {
			int next = it.next();
			if (next == prev + 1) {
				curr_sum++;
			} else {
				sum = Math.max(curr_sum, sum);
				curr_sum = 1;
			}

			prev = next;
		} while (it.hasNext());

		sum = Math.max(curr_sum, sum);
		return sum;
	}
}
