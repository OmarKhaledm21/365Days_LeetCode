import java.util.ArrayList;
import java.util.HashSet;


class Solution {


    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set1.add(nums1[i]);
        }

        for (int i = 0; i < nums2.length; i++) {
            set2.add(nums2[i]);
        }

        ArrayList<Integer> res = new ArrayList<>();
        for (Integer k : set1) {
            if(set2.contains(k)){
                res.add(k);
            }
        }


        int i = 0;
        int[] ret = new int[res.size()];
        for (int el : res) {
            ret[i++] = el;
        }
        return ret;
    }
}