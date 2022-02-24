class Solution {
     public void merge(int[] nums1, int m, int[] nums2, int n) {
       m = m-1;
        n = n-1;
        int pointer = nums1.length-1;

        while (m != -1 && n != -1){
            if(nums1[m] > nums2[n]){
                nums1[pointer] = nums1[m];
                pointer--;
                m--;
            }else{
                nums1[pointer] = nums2[n];
                pointer--;
                n--;
            }
        }

        while (n != -1){
            nums1[pointer] = nums2[n];
            pointer--;
            n--;
        }

    }
}