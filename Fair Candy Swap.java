class Solution {
    	public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
		int sumAlice = 0, sumBob = 0;
        for (int size : aliceSizes) sumAlice += size;
        for (int size : bobSizes) sumBob += size;

        int delta = (sumAlice - sumBob) / 2;

        Set<Integer> setBobSizes = new HashSet();
        for (int size : bobSizes) setBobSizes.add(size);

        for (int x : aliceSizes) {
            int y = x - delta;
            if (setBobSizes.contains(y)) {
                return new int[]{x, y};
            }
        }
		return null;
	}
}
