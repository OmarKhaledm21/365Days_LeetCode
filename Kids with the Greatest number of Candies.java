class Solution {
    
	public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
		List<Boolean> res = new ArrayList<Boolean>();

		int mx = 0;
		for (int i : candies) {
			mx = Math.max(i, mx);
		}

		for (int i = 0; i < candies.length; i++) {
			if (candies[i] + extraCandies >= mx) {
				res.add(true);
				continue;
			}
			res.add(false);
		}

		return res;
	}
}
