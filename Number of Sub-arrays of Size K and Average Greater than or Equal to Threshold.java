class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int count = 0;
        double global_sum = 0;

        for (int i = 0; i < k; i++) {
            global_sum += arr[i];
        }
        if (global_sum / k >= threshold) {
            count++;
        }

        for (int i = k; i < arr.length; i++) {
            global_sum += arr[i];
            global_sum -= arr[i - k];
            if (global_sum / k >= threshold) {
                count++;
            }
        }
        return count;
    }
}