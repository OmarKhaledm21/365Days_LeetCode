class Solution {
    	public int lengthOfLongestSubstring(String s) {
		int len = 0;
		int cur_len = 0;
		Set<Character> set = new HashSet();
		int j = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (!set.contains(c)) {
				cur_len++;
				set.add(c);
				len = Math.max(len, cur_len);
			} else {
				while (set.contains(c)) {
					set.remove(s.charAt(j));
					cur_len--;
					j++;
				}
				cur_len++;
				set.add(c);
			}
		}

		return len;
	}
}
