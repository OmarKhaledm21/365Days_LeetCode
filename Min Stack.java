class MinStack {

	private class Node {
		int value;
		int min_so_far;
		Node next;

		Node(int value, int min_so_far, Node next) {
			this.value = value;
			this.min_so_far = min_so_far;
			this.next = next;
		}
	}

	private Node top_node;

	public MinStack() {
	}

	public void push(int val) {
		if (top_node == null) {
			this.top_node = new Node(val, val, null);
		} else {
			Node node = new Node(val, Math.min(val, top_node.min_so_far), top_node);
			top_node = node;
		}
	}

	public void pop() {
		top_node = top_node.next;
	}

	public int top() {
		return top_node.value;
	}

	public int getMin() {
		return top_node.min_so_far;
	}
}
/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
