class Solution {
    public int partition(int[] arr, int low, int high, int pivot) {
        while (low <= high) {
            while (arr[low] < pivot) {
                low++;
            }
            while (arr[high] > pivot) {
                high--;
            }
            if (low <= high) {
                int temp = arr[low];
                arr[low] = arr[high];
                arr[high] = temp;
                low++;
                high--;
            }
        }
        return low;
    }

    public void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivot = arr[(low + high) / 2];
            int pi = partition(arr, low, high, pivot);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi, high);
        }
        System.out.println();
    }

    public void sortColors(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }
}