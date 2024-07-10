
import java.util.Hashtable;

class Solution {
   		public boolean wordPattern(String pattern, String s) {
		Hashtable<Character, String> map = new Hashtable();
		HashSet<String> set = new HashSet();
		String[] arr = s.split(" ");
        if(arr.length != pattern.length()) {
			return false;
		}
		for (int i = 0; i < pattern.length(); i++) {
			char c = pattern.charAt(i);
			String curr = arr[i];
			if (!map.containsKey(c)) {
				if (!set.contains(curr)) {
					map.put(c, curr);
					set.add(curr);
				}else {
					return false;
				}
			} else if (map.containsKey(c) && !map.get(c).equals(curr)) {
				return false;
			}
		}
		return true;
	}
}
