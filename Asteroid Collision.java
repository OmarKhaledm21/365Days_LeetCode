class Solution {
	public int[] asteroidCollision(int[] asteroids) {
		Stack<Integer> stack = new Stack<>();
		for (int asteroid : asteroids) {
			boolean destroyed = false;
			while (!stack.isEmpty() && asteroid < 0 && stack.peek() > 0) {
				int top = stack.peek();
				if (Math.abs(asteroid) > Math.abs(top)) {
					stack.pop(); // Top asteroid is destroyed
				} else if (Math.abs(asteroid) == Math.abs(top)) {
					stack.pop(); // Both asteroids are destroyed
					destroyed = true;
					break;
				} else {
					destroyed = true; // Current asteroid is destroyed
					break;
				}
			}

			if (!destroyed) {
				stack.push(asteroid);
			}
		}

		int[] result = new int[stack.size()];
		for (int i = stack.size() - 1; i >= 0; i--) {
			result[i] = stack.pop();
		}
		return result;
	}
}
