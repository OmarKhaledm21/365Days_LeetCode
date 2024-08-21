class Solution {
    	public int strStr(String haystack, String needle) {
		for (int i = 0; i < haystack.length(); i++) {
			if (haystack.charAt(i) == needle.charAt(0)) {
				int curr = i;
				int startInd = curr;
				int j = 1;
				curr++;
				while (curr < haystack.length() && j < needle.length()) {
					if (haystack.charAt(curr) != needle.charAt(j)) {
						break;
					}
					curr++;
					j++;
				}
				if (j == needle.length()) {
					return startInd;
				}
			}
		}
		return -1;
	}


}
