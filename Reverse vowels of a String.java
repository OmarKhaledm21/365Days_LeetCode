class Solution {
  	public String reverseVowels(String s) {
		Set<Character> set = new HashSet();
		set.add('a');
		set.add('A');
		set.add('e');
		set.add('E');
		set.add('i');
		set.add('I');
		set.add('U');
		set.add('u');
		set.add('o');
		set.add('O');

		ArrayList<Character> list = new ArrayList();

		for (int i = 0; i < s.length(); i++) {
			if (set.contains(s.charAt(i))) {
				list.add(s.charAt(i));
			}
		}

		StringBuilder res = new StringBuilder();

		int q = list.size()-1;
		for (int i = 0; i < s.length(); i++) {
			if (set.contains(s.charAt(i))) {
				res.append(list.get(q--));
			} else {
				res.append(s.charAt(i));
			}
		}

		return res.toString();
	}

}
