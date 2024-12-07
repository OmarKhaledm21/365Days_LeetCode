class Solution {
	public long maxScore(int[] nums1, int[] nums2, int k) {
		int n = nums1.length;
		Integer[] indices = new Integer[n];
		for (int i = 0; i < n; i++)
			indices[i] = i;
		Arrays.sort(indices, (a, b) -> Integer.compare(nums2[b], nums2[a]));

		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		long sum = 0, maxScore = 0;

		for (int idx : indices) {
			int num1 = nums1[idx];
			int num2 = nums2[idx];

			minHeap.add(num1);
			sum += num1;

			if (minHeap.size() > k) {
				sum -= minHeap.poll();
			}

			// Calculate the score if we have exactly k elements in the heap
			if (minHeap.size() == k) {
				maxScore = Math.max(maxScore, sum * num2);
			}
		}

		return maxScore;
	}
}
