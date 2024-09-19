class Solution {
   	public int[] topKFrequent(int[] nums, int k) {
		Map<Integer, Integer> frequencyMap = new HashMap<>();
		for (int num : nums) {
			frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
		}

		// Step 2: Use a priority queue (min-heap) to find the top k frequent numbers
		PriorityQueue<Map.Entry<Integer, Integer>> heap = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());

		// Add entries to the heap
		for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
			heap.add(entry);
			if (heap.size() > k) {
				heap.poll(); // Remove the least frequent element
			}
		}

		// Step 3: Extract the top k elements
		int[] result = new int[k];
		int index = 0;
		while (!heap.isEmpty()) {
			result[index++] = heap.poll().getKey();
		}

		return result;
	}
}
