class Solution {
   	public int romanToInt(String s) {
		Map<String, Integer> map = new HashMap();
		map.put("I", 1);
		map.put("V", 5);
		map.put("X", 10);
		map.put("L", 50);
		map.put("C", 100);
		map.put("D", 500);
		map.put("M", 1000);
		map.put("IV", 4);
		map.put("IX", 9);
		map.put("XL", 40);
		map.put("XC", 90);
		map.put("CD", 400);
		map.put("CM", 900);

		int res = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			int val = map.get(String.valueOf(c));
			if (i + 1 < s.length() && (c == 'I' || c == 'X' || c == 'C')) {
				StringBuilder ex = new StringBuilder();
				ex.append(c);
				ex.append(s.charAt(i + 1));
				if (map.containsKey(ex.toString())) {
					val = map.get(ex.toString());
					i++;
				}
			}
			res += val;
		}
		return res;
	}
}
