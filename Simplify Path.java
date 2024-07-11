class Solution {
	public String simplifyPath(String path) {
		Stack<String> stack = new Stack();
		StringBuilder out = new StringBuilder();
		String[] arr = path.split("/");
		for (int i = 0; i < arr.length; i++) {
			String c = arr[i];
			if (c.equals("..")) {
				if (!stack.isEmpty()) {
					stack.pop();
				}
			} else if (c.equals(".")) {
				continue;
			} else if (c.equals("")) {
				continue;
			} else {
				stack.push(c);
			}
		}
		if (stack.size() == 0) {
			return "/";
		}
		int sz = stack.size();
		List<String> list = new ArrayList();
		for (int i = 0; i < sz; i++) {
			list.add(stack.pop());
		}
		for (int i = list.size() - 1; i >= 0; i--) {
			out.append("/");
			out.append(list.get(i));
		}

		return out.toString();
	}
}
