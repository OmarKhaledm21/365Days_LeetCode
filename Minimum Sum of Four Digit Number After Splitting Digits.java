class Solution {
    public int minimumSum(int num) {
        int[] arr = new int[4];
        int d1;
        int i = 0;
        while (num > 0) {
            d1 = num % 10;
            num = num / 10;
            arr[i++] = d1;
        }
        Arrays.sort(arr);
        return ((arr[0] * 10) + arr[2]) + ((arr[1] * 10) + arr[3]);

    }
}