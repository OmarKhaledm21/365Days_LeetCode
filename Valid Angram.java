class Solution {
	public boolean isAnagram(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}
		int[] arr = new int[200];

		for (int i = 0; i < s.length(); i++) {
			int c = (int) s.charAt(i);
			arr[c]++;
		}
		for (int i = 0; i < t.length(); i++) {
			int c = (int) t.charAt(i);
			if (arr[c] == 0) {
				return false;
			} else {
				arr[c]--;
			}
		}
		return true;
	}
}
