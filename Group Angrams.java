class Solution {
  public List<List<String>> groupAnagrams(String[] strs) {
		HashMap<String, List<String>> map = new HashMap();
		for (int i = 0; i < strs.length; i++) {
			String curr = strs[i];
			String key = calcKey(curr);
			if (map.containsKey(key)) {
				map.get(key).add(curr);
			} else {
				List<String> l = new ArrayList();
				l.add(curr);
				map.put(key, l);
			}
		}
		List<List<String>> groups = new ArrayList();
		for (String key : map.keySet()) {
			groups.add(map.get(key));
		}
		return groups;

	}

	public String calcKey(String str) {
		int[] count = new int[26];
		for (char c : str.toCharArray()) {
			count[c - 'a']++;
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 26; i++) {
			sb.append("#").append(count[i]);
		}
		String key = sb.toString();
		return key;
	}
}
