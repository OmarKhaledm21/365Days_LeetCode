import java.util.ArrayList;
import java.util.Hashtable;
class Solution {
     public int[] intersect(int[] nums1, int[] nums2) {
        Hashtable<Integer, Integer> key_freq_pair = new Hashtable<>();
        Hashtable<Integer, Integer> key_freq_pair2 = new Hashtable<>();
        for (int i = 0; i < nums1.length; i++) {
            key_freq_pair.put(nums1[i], key_freq_pair.getOrDefault(nums1[i], 0) + 1);
        }

        for (int i = 0; i < nums2.length; i++) {
            key_freq_pair2.put(nums2[i], key_freq_pair2.getOrDefault(nums2[i], 0) + 1);
        }

        ArrayList<Integer> res = new ArrayList<>();
        for (Integer kvp : key_freq_pair.keySet()) {
            int freq = key_freq_pair.get(kvp);
            int freq2 = key_freq_pair2.getOrDefault(kvp, 0);

            int min = Math.min(freq, freq2);
            for (int i = 0; i < min; i++) {
                res.add(kvp);
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