class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ranges = new ArrayList();
        if (nums.length == 0) {
            return ranges;
        }
        if (nums.length == 1) {
            ranges.add(nums[0] + "");
            return ranges;
        }
        int ind1 = 0;
        int ind2 = 0;
        for (int i = 1; i < nums.length; i++) {
            int curr = nums[i];
            if (curr == nums[i - 1] + 1) {
                ind2 = i;
            } else {
                if (ind1 == ind2) {
                    ranges.add(nums[ind1] + "");
                } else {
                    ranges.add(nums[ind1] + "->" + nums[ind2]);
                }
                ind1 = i;
                ind2 = i;
            }
        }
        if (ind1 == ind2) {
            ranges.add(nums[ind1] + "");
        } else {
            ranges.add(nums[ind1] + "->" + nums[ind2]);
        }

        return ranges;
    }
}
