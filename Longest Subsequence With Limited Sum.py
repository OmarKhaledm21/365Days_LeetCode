
class Solution:
    def answerQueries(self, nums: List[int], queries: List[int]) -> List[int]:
        nums.sort()
        prefix_arr = []
        prefix_arr.append(nums[0])
        i = 1
        while i < len(nums):
            prefix_arr.append(prefix_arr[i-1]+nums[i])
            i += 1

        ans = []
        for q in queries:
            seq = 0
            for k in prefix_arr:
                if k <= q:
                    seq += 1
            ans.append(seq)

        return ans