public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        int[] prefixSums = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0)
                prefixSums[i] = nums[i];
            else
                prefixSums[i] = prefixSums[i - 1] + nums[i];
        }

        int max1 = FindMaxSum(prefixSums, firstLen, secondLen);
        int max2 = FindMaxSum(prefixSums, secondLen, firstLen);

        return Math.max(max1, max2);
    }

    int FindMaxSum(int[] prefixSums, int firstLen, int secondLen) {
        int globalMax = prefixSums[firstLen + secondLen - 1];
        int max1 = prefixSums[firstLen - 1];
        for (int i = 0; i < prefixSums.length - firstLen - secondLen; i++) {
            int sum1 = prefixSums[i + firstLen] - prefixSums[i];
            int sum2 = prefixSums[i + firstLen + secondLen] - prefixSums[i + firstLen];
            max1 = Math.max(max1, sum1);
            globalMax = Math.max(globalMax, max1 + sum2);
        }
        return globalMax;
    }