class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> s1 = new HashSet();
        Set<Integer> s2 = new HashSet();

        for (int num : nums1) {
            s1.add(num);
        }
        for (int num : nums2) {
            s2.add(num);
        }

        List<Integer> answer1 = new ArrayList();
        List<Integer> answer2 = new ArrayList();

        
        for(int num : s1) {
        	if(!s2.contains(num)) {
        		answer1.add(num);
        	}
        }
        for(int num : s2) {
        	if(!s1.contains(num)) {
        		answer2.add(num);
        	}
        }
        List<List<Integer>> res = new ArrayList();
        res.add(answer1);
        res.add(answer2);
        return res;

    }
}
