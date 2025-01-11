class Solution {
	public String removeStars(String s) {
		Stack<Character> stack = new Stack();

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '*') {
				stack.pop();
			} else {
				stack.push(c);
			}
		}
		if(stack.isEmpty()) {
			return "";
		}
		StringBuilder result = new StringBuilder();
		while(!stack.isEmpty()) {
			result.append(stack.pop());
		}
		return result.reverse().toString();
	}
}